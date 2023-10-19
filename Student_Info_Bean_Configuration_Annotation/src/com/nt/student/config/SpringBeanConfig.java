package com.nt.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.student.info.Student;

@Configuration
public class SpringBeanConfig 
{
	@Bean("krishna")
   Student studentDetails()
   {
	   Student student = new Student();
	   student.setId(1996);
	   student.setName("Madhu Krishna");
	   student.setMarks(79.2f);
	   return student;
   }
}
