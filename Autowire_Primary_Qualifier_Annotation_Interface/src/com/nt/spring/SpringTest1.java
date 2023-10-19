package com.nt.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.zoo.Zoo;

public class SpringTest1 {
	@SuppressWarnings( "resource" )
	public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.scan("com.nt.*");
      context.refresh();
      
		/*Tiger tiger1 = context.getBean(Tiger.class);
		System.out.println(tiger1);
		
		Tiger tiger2 = context.getBean(Tiger.class);
		System.out.println(tiger2);*/
      
      Zoo zoo = context.getBean(Zoo.class);
      System.out.println(zoo);
      
		/*System.out.println(zoo.getTiger());
		System.out.println(zoo.getLion());*/
	}//main
}//class
