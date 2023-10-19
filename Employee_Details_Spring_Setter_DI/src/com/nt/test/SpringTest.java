package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.student.info.Student;
import com.nt.student.info.StudentDetails;

public class SpringTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		BeanFactory factory = new FileSystemXmlApplicationContext
                             ("C:\\Users\\krishna\\FS-NTSP64-Spring\\Employee_Details_Spring_Setter_DI\\src\\com\\nt\\cfgs\\applicationContext.xml");
		Student student = (Student)factory.getBean("student1");
		System.out.println(student);
		System.out.println("======Student Details======");
		System.out.println("Student Id :: "+student.getId());
		System.out.println("Student Name :: "+student.getName());
		System.out.println("=====Student Address=====");
		System.out.println("Street :: "+student.getAddr().getStreet());
		System.out.println("City :: "+student.getAddr().getCity());
		System.out.println("Pincode :: "+student.getAddr().getPincode());
		System.out.println("Country :: "+student.getAddr().getCountry());
		System.out.println("-----------------------------------------------------------------------------");
		StudentDetails sDetails = (StudentDetails) factory.getBean("details");
		System.out.println(sDetails.getStudent().add(student));
	}//main
}//class