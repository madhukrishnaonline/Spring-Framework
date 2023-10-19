package com.nt.student.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.student.config.SpringBeanConfig;
import com.nt.student.info.Student;

public class SpringTest 
{
  @SuppressWarnings("resource")
public static void main(String[] args) 
  {
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	 
	 context.register(SpringBeanConfig.class);
	 context.refresh();
	 
	 Student student = (Student)context.getBean("krishna");
	 System.out.println(student.getId());
	 System.out.println(student.getName());
	 System.out.println(student.getMarks());
  }
}//class