package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.address.Employee;

public class SpringFramework {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        
        context.scan("com.nt.*");
        context.refresh();
        
        Employee emp = (Employee)context.getBean("madhu");
        System.out.println(emp);
        System.out.println(emp.getAddress());
	}//main
}//class