package com.nt.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.order.Order;

@Configuration
@ComponentScan("com.nt.order")
public class SpringBeanConfiguration 
{
	@Bean("order")
   public Order getOrderInstance()
   {
	   return new Order();
   }
}//class