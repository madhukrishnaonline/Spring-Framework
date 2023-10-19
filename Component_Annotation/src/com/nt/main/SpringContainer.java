package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.Config.SpringBeanConfiguration;
import com.nt.order.Order;

public class SpringContainer 
{
	 @SuppressWarnings("resource")
	public static void main(String[] args) 
	 {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		/*context.scan("com.nt.order");	   */
		context.register(SpringBeanConfiguration.class);
		context.refresh(); 
		
        Order order = context.getBean(Order.class);
        System.out.println(order.getOrderId());
        System.out.println(order.getOrderDeliveryDate());
	 }//main
}//class