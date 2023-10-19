package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringConfiguration;
import com.nt.shoppers.Products;
import com.nt.shoppers.Shoppers;

public class SpringFramework {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        
        //context.scan("com.nt.shoppers");
        context.register(SpringConfiguration.class);
        context.refresh();
        
        Products products = context.getBean(Products.class);
        System.out.println("Products :: "+products);
        Shoppers shoppers = context.getBean(Shoppers.class);
        System.out.println("Shoppers :: "+shoppers);
        System.out.println("GetProducts :: "+shoppers.getProducts());
        
        Products products2 = (Products) context.getBean("mouse");
        System.out.println("Products2 :: "+products2);
	}//main
}//class
