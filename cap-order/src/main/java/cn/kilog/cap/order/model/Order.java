package cn.kilog.cap.order.model;

import cn.kilog.cap.manager.pojo.CapOrder;
import cn.kilog.cap.manager.pojo.CapOrderItem;
import cn.kilog.cap.manager.pojo.CapOrderShipping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class Order extends CapOrder {

	private List<CapOrderItem> orderItems;
	private CapOrderShipping orderShipping;

    public List<CapOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<CapOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public CapOrderShipping getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(CapOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }
}
