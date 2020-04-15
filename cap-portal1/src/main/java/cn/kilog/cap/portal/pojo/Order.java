package cn.kilog.cap.portal.pojo;

import cn.kilog.cap.manager.pojo.CapOrder;
import cn.kilog.cap.manager.pojo.CapOrderItem;
import cn.kilog.cap.manager.pojo.CapOrderShipping;

import java.util.List;

public class Order extends CapOrder {

	private List<CapOrderItem> orderItems;
	private CapOrderShipping orderShipping;

	public CapOrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(CapOrderItem orderItem) {
		this.orderItem = orderItem;
	}

	private CapOrderItem orderItem;

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
