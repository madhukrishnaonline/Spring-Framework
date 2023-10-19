package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.queries.DBOperations;

public class JDBCMainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	    context.scan("com.nt.*");
	    context.refresh();
	    
	    DBOperations dbOperations =  context.getBean(DBOperations.class);
	    System.out.println(dbOperations);
	    System.out.println("=====Product Table Details=====");
	    System.out.println(dbOperations.loadAllProducts());
	}//main
}//class