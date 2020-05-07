package cn.kilog.cap.order.service.impl;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.manager.mapper.CapOrderItemMapper;
import cn.kilog.cap.manager.mapper.CapOrderMapper;
import cn.kilog.cap.manager.mapper.CapOrderShippingMapper;
import cn.kilog.cap.manager.pojo.*;
import cn.kilog.cap.order.model.CartItem;
import cn.kilog.cap.order.model.Order;
import cn.kilog.cap.order.service.OrderService;
import cn.kilog.cap.rest.client.provider.RestService;
import com.alibaba.nacos.common.util.UuidUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Example;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Value("${REDIS_CART_PRE}")
    private String REDIS_CART_PRE;
    @Autowired
    private RestService restService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CapOrderMapper capOrderMapper;
    @Autowired
    private CapOrderItemMapper capOrderItemMapper;
    @Autowired
    private CapOrderShippingMapper capOrderShippingMapper;

    /**
     * 创建订单
     * 创建订单 --> 创建订单项  --> 通过将订单的orderId设置给订单项来维护主外键关系
     * @param userId
     * @param list
     * @param shipping
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult createOrder(String userId, List<CartItem> list, CapOrderShipping shipping) {
        HashOperations<String, String, String> opsForHash = stringRedisTemplate.opsForHash();

        // 获取收货地址信息
        CapOrderShipping capOrderShipping = capOrderShippingMapper.selectByPrimaryKey(shipping.getId());
        // 构建订单实体
        CapOrder order = new CapOrder();
        order.setOrderId(UUID.randomUUID().toString());
        order.setUserId(userId);
        order.setCreateTime(new Date());
        // 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
        order.setStatus(1);
        order.setBuyerAddress(capOrderShipping.getReceiverAddress());
        order.setBuyerName(capOrderShipping.getReceiverName());
        order.setBuyerPhone(capOrderShipping.getReceiverPhone());
        capOrderMapper.insert(order);

        for (CartItem item : list) {
            Long itemId = item.getId();
            String num = opsForHash.get(REDIS_CART_PRE + ":" + userId, String.valueOf(itemId));
            log.info("获取到购物车中商品编号为: {}", itemId);


            // remote fetching the itemInfo
            String itemBaseInfo = restService.getItemBaseInfo(itemId);
            ResponseResult responseResult = ResponseResult.formatToPojo(itemBaseInfo, CapItem.class);
            CapItem capItem = (CapItem) responseResult.getData();
            int number;
            if (StringUtils.isEmpty(num)) throw new RuntimeException("cartItem can not be null");

                number = Integer.parseInt(num);
                // 构建订单项实体， 其中orderId为订单id
                CapOrderItem orderItem = CapOrderItem.builder()
                        .num(number)
                        .orderId(order.getOrderId())
                        .id(UUID.randomUUID().toString())
                        .price(capItem.getPrice())
                        .totalFee(number * capItem.getPrice())
                        .picPath(capItem.getImage())
                        .itemId(String.valueOf(capItem.getId()))
                        .title(capItem.getTitle()).build();
                capOrderItemMapper.insert(orderItem);

                // 订单项插入成功后删除购物车
                Long delete = opsForHash.delete(REDIS_CART_PRE + ":" + userId, String.valueOf(itemId));
                log.info("生成订单删除原来购物车，商品编号为: {}, 结果为： {}", itemId, delete);

                log.info("插入订单项成功！订单项Id为：{} ,订单Id为: {}", orderItem.getId(), orderItem.getOrderId());

        }

        return ResponseResult.ok();

    }

    @Override
    public ResponseResult showOrder(String userId) {
        log.info("获取订单列表，当前用户Id为： {}", userId);
        CapOrderExample example = new CapOrderExample();
        CapOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        //执行查询
        List<CapOrder> capOrders = capOrderMapper.selectByExample(example);
        ArrayList<CapOrderItem> orderItems = new ArrayList<>();


        capOrders.forEach(x -> {
            CapOrderItemExample capOrderItemExample = new CapOrderItemExample();
            CapOrderItemExample.Criteria criteria1 = capOrderItemExample.createCriteria();
            criteria1.andOrderIdEqualTo(x.getOrderId());
            // 根据订单Id将订单项和订单绑定
            List<CapOrderItem> capOrderItems = capOrderItemMapper.selectByExample(capOrderItemExample);
            x.setOrderItems(capOrderItems);
        });


        return ResponseResult.ok(capOrders);
    }

    /**
     * 添加收货地址
     * @param userId
     * @param shipping
     * @return
     */
    @Override
    public ResponseResult createAddress(String userId, CapOrderShipping shipping) {
        if (StringUtils.isEmpty(shipping.getReceiverName()) || StringUtils.isEmpty(shipping.getReceiverAddress()) || StringUtils.isEmpty(shipping.getReceiverPhone()))
            return ResponseResult.build(400, "收货人姓名、电话、住址不能为空！");
        shipping.setUserId(userId);
        shipping.setId(UuidUtils.generateUuid());
        capOrderShippingMapper.insert(shipping);
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult showAddressList(String userId) {
        CapOrderShippingExample capOrderShippingExample = new CapOrderShippingExample();
        CapOrderShippingExample.Criteria criteria = capOrderShippingExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<CapOrderShipping> capOrderShippings = capOrderShippingMapper.selectByExample(capOrderShippingExample);
        return ResponseResult.ok(capOrderShippings);
    }

    @Override
    public ResponseResult updateAddress(CapOrderShipping shipping) {
            capOrderShippingMapper.updateByPrimaryKey(shipping);
        return ResponseResult.ok();
    }
}
