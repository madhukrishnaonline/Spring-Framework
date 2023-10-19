package com.nt.beans;

import java.util.Map;
import java.util.Set;

public class Product {
	private String orderId;
	private float price;
	private boolean isOrderDeliverd;
	private Map<String,Integer> itemPrices;

	public Map<String, Integer> getItemPrices() {
		return itemPrices;
	}

	public void setItemPrices(Map<String, Integer> itemPrices) {
		this.itemPrices = itemPrices;
	}

	public boolean getisOrderDeliverd() {
		return isOrderDeliverd;
	}

	public void setIsOrderDeliverd(boolean isOrderDeliverd) {
		this.isOrderDeliverd = isOrderDeliverd;
	}

	private Set<String> items;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<String> getItems() {
		return items;
	}

	public void setItems(Set<String> items) {
		this.items = items;
	}

	public void OrderDetails() {
		System.out.println("=====Order Details=====");
	}
}
