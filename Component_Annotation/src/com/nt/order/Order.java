package com.nt.order;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("order")
public class Order {
	private String orderId;
	private Date orderDeliveryDate;

	
	public Order() {	
		System.out.println("Order Object Created");
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

}//class
