package com.nt.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product 
{
	@Id
	@Column
	private String orderId;
	
	@Column
	private String OrderName;
	
	@Column
	private int orderPrice;

	//public Product() {	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	
}//class