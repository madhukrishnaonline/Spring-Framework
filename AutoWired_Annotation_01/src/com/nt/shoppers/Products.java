package com.nt.shoppers;

import org.springframework.stereotype.Component;

@Component
public class Products {
	private String productId, productName;

	public Products() {
      System.out.println("Product Object Created");
	}
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}//class
