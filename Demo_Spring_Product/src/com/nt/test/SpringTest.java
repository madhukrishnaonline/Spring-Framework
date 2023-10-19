package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.Product;

public class SpringTest 
{
  @SuppressWarnings("resource")
public static void main(String[] args) 
  {
	 BeanFactory factory = new FileSystemXmlApplicationContext
			  ("C:\\Users\\krishna\\FS-NTSP64-Spring\\Demo_Spring_Product\\src\\com\\nt\\cfgs\\applicationContext.xml");
	 
	 Product pro = (Product)factory.getBean("product");
	 pro.OrderDetails();
	 System.out.println("OrderId :: "+pro.getOrderId());
	 System.out.println("Price :: "+pro.getPrice());
	 System.out.println("Items :: "+pro.getItems());
	 System.out.println("isOrderDeliverd :: "+pro.getisOrderDeliverd());
	 System.out.println("Count :: "+pro.getItems().size());
	 System.out.println("Item Prices :: "+pro.getItemPrices());
	 System.out.println("===After Set Cleared===");
	 pro.getItems().clear();
	 System.out.println("Items :: "+pro.getItems());
	 System.out.println("Count :: "+pro.getItems().size());
  }
}
