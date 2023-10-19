package com.nt.jdbc.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.jdbc.query.InsertOperation;

public class JDBCTest {
	@SuppressWarnings("resource" )
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.nt.jdbc.*");
		context.refresh();

		InsertOperation insertOperation = context.getBean(InsertOperation.class);
		int insertedRowsCount =  insertOperation.addStudent();
		if(insertedRowsCount>0)
		{
			System.out.println("Row's Inserted "+insertedRowsCount);
		}
	}//main
}//class
