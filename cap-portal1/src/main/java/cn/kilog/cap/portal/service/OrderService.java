package cn.kilog.cap.portal.service;

import cn.kilog.cap.manager.pojo.CapOrder;
import cn.kilog.cap.portal.pojo.Order;

import java.util.List;

public interface OrderService {

	String createOrder(Order order);
    List<CapOrder> findOrderByUserid(Long userid);
    String findOrderitemByOrderid(Long orderid);

}
