package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.shoppers.Products;

@Configuration
@ComponentScan("com.nt.shoppers")
public class SpringConfiguration 
{
	@Bean("mouse")
  public Products getDetails()
  {
	  Products products = new Products();
	  products.setProductId("mo235");
	  products.setProductName("Mouse");
	  return products;
  }
}
