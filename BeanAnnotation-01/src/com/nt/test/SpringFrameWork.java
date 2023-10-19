package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.UserDetails;
import com.nt.config.BeansConfiguration;

public class SpringFrameWork
{
  public static void main(String[] args) 
   {
	   AnnotationConfigApplicationContext context = 
	               new AnnotationConfigApplicationContext();
	   
	   context.register(BeansConfiguration.class);
	   context.refresh();
	   
	   UserDetails uDetails = (UserDetails) context.getBean("userDetails");
	   System.out.println(uDetails);
	   context.close();
   }
}
