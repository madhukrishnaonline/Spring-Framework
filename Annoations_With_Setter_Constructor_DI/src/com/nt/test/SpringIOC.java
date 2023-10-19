package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.student1.Student;

public class SpringIOC {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
       
		context.scan("com.nt.student1");
		context.refresh();
		
		Student student = context.getBean(Student.class);
		System.out.println(student.getAddress());
		
	}//main
}//class