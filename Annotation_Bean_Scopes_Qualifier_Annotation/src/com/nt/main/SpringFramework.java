package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.address.Address;
import com.nt.address.Employee;

public class SpringFramework {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        
        context.scan("com.nt.*");
       //context.register(SpringConfig.class);
        context.refresh();
        
        Address address1 = (Address)context.getBean("office");
        System.out.println(address1);
        
		Address address2 = (Address)context.getBean("office");
		System.out.println(address2);
        
		Address address3 = (Address)context.getBean("home");
        System.out.println(address3);
        
		Address address4 = (Address)context.getBean("home");
		System.out.println(address4);
		
        Employee employee1 = (Employee)context.getBean("madhu");
        System.out.println(employee1);
        System.out.println(employee1.getAddress());
	}//main
}//class
