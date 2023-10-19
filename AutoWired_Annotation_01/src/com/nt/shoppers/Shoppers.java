package com.nt.shoppers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Shoppers 
{
	private String shoppersURL;
	
	@Autowired
	private List<Products> products;

	public Shoppers() 
	{
        System.out.println("Shoppers Object Created");
	}//0-constructor
	public String getShoppersURL() {
		return shoppersURL;
	}

	public void setShoppersURL(String shoppersURL) {
		this.shoppersURL = shoppersURL;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

}//class
