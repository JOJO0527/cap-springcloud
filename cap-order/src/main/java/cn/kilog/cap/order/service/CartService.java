package cn.kilog.cap.order.service;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.order.model.CartItem;

import java.util.List;

public interface CartService {

    ResponseResult addCart(String  userId, Long itemId, Integer number);
    ResponseResult getCartList(String userId);
    ResponseResult delCart(String userId, Long itemId);
    ResponseResult clearCart(String userId);
    ResponseResult getCartListByids(String userId,  List<CartItem> list);

}
