package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.product.Product;
import com.nt.queries.DBOperation;

public class SpringMain 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
         context.scan("com.nt.*");
         context.refresh();
         
         Product product = context.getBean(Product.class);
         System.out.println(product);
         product.setOrderId("mo143se");
         product.setOrderName("Mouse");
         product.setOrderPrice(599);
         DBOperation dbOperation =  context.getBean(DBOperation.class);
         System.out.println(dbOperation);
         dbOperation.addProduct(product);
        	System.out.println("Row's Inserted :: ");
	}//main
}//class