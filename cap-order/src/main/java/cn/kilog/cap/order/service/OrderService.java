package cn.kilog.cap.order.service;

import cn.kilog.cap.common.pojo.ResponseResult;
import cn.kilog.cap.manager.pojo.*;
import cn.kilog.cap.order.model.CartItem;

import java.util.List;

public interface OrderService {
    ResponseResult createOrder(String userId, List<CartItem> items, CapOrderShipping shipping);
    ResponseResult showOrder(String userId);
    ResponseResult createAddress(String userId, CapOrderShipping shipping);
    ResponseResult showAddressList(String userId);
    ResponseResult updateAddress(CapOrderShipping shipping);
}
