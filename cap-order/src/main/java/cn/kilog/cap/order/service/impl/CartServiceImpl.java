package cn.kilog.cap.order.service.impl;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.common.utils.JsonUtils;
import cn.kilog.cap.manager.pojo.CapItem;
import cn.kilog.cap.order.service.CartService;
import cn.kilog.cap.rest.client.provider.RestService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RestService restService;

    @Value("${REDIS_CART_PRE}")
    private String REDIS_CART_PRE;

    @Override
    public ResponseResult addCart(String userId, Long itemId, Integer number) {
        String itemBaseInfo = restService.getItemBaseInfo(itemId);
        ResponseResult responseResult = ResponseResult.formatToPojo(itemBaseInfo, CapItem.class);
        if (responseResult == null || responseResult.getStatus() != 200 || responseResult.getData() == null)
            return ResponseResult.build(404, "No such Item!");
       /*
        capitem capitem = (capitem) responseresult.getdata();
        hashoperations<string, object, object> operations = stringredistemplate.opsforhash();
        operations.put(redis_cart_pre + ":" + userid, capitem.getid() + " " , objects.requirenonnull(jsonutils.object*//*ToJson(capItem)));
         */
        addCartToRedis(userId, itemId, number);
        return ResponseResult.ok();
    }

    public void addCartToRedis(String userId, Long itemId, Integer num) {
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        operations.put(REDIS_CART_PRE + ":" + userId, String.valueOf(itemId), String.valueOf(num));
    }


    @Override
    public ResponseResult getCartList(String userId) {
        //根据用户id查询购车列表
//        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
//        Map<String, String> entries = operations.entries(REDIS_CART_PRE + ":" + userId);
//        if (entries.isEmpty()) return ResponseResult.ok("cart is null!");
//        Set<Map.Entry<String, String>> set = entries.entrySet();
//        ArrayList<CapItem> list = new ArrayList<>();
//        set.forEach(x -> {
//            JSONObject jsonObject = JSONObject.parseObject(x.getValue());
//            CapItem item = jsonObject.toJavaObject(CapItem.class);
//            list.add(item);
//        });
        List<CapItem> list = getCarts(userId);
        return ResponseResult.ok(list);
    }

    public List<CapItem> getCarts(String userId) {
        HashOperations<String, String, String> ops = stringRedisTemplate.opsForHash();
        Map<String, String> entries = ops.entries(REDIS_CART_PRE + ":" + userId);
        if (entries.isEmpty()) return null;
        Set<Map.Entry<String, String>> set = entries.entrySet();
        ArrayList<String> list = new ArrayList<>();
        set.forEach(x -> list.add(x.getKey()));
        ArrayList<CapItem> capItemArrayList = new ArrayList<>();
        list.forEach(x -> capItemArrayList.add((CapItem) ResponseResult.formatToPojo(restService.getItemBaseInfo(Long.parseLong(x)), CapItem.class).getData()));
        return capItemArrayList;
    }

    @Override
    public ResponseResult delCart(String userId, Long itemId) {
        HashOperations<String, String, String> ops = stringRedisTemplate.opsForHash();
        Long result;
        if (!ops.hasKey(REDIS_CART_PRE + ":" + userId, String.valueOf(itemId)))
            return ResponseResult.build(404, "item not found");
        result = ops.delete(REDIS_CART_PRE + ":" + userId, String.valueOf(itemId));
        if (result != null) return ResponseResult.ok();
        return ResponseResult.build(500, "server error");

    }

    public ResponseResult clearCart(String userId) {
        HashOperations<String, String, String> ops = stringRedisTemplate.opsForHash();
        Set<String> keys = ops.keys(REDIS_CART_PRE + ":" + userId);
        Consumer<String> delKeys = x -> ops.delete(REDIS_CART_PRE + ":" + userId,x);
        keys.forEach(delKeys);
        return ResponseResult.ok();
    }


}
