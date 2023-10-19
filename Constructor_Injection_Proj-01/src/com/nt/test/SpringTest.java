package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.Employee;

public class SpringTest 
{
 @SuppressWarnings("resource")
	public static void main(String[] args) 
	 {
		BeanFactory factory = new FileSystemXmlApplicationContext
				("C:\\Users\\krishna\\FS-NTSP64-Spring\\Constructor_Injection_Proj-01\\src\\com\\nt\\cfg\\applicationContext.xml");
		Employee employee = (Employee)factory.getBean("emp");
		System.out.println("  =======Employee Details=======");
		System.out.println("  "+employee);
		System.out.println("  Id :: "+employee.geteId());
		System.out.println("  Name :: "+employee.geteName());
		System.out.println("  Salary :: "+employee.getSal());
		System.out.println("  Mobile :: "+employee.getMobile());
		System.out.println("  =======Address=======");
		System.out.println("  "+employee.getAddress());
		System.out.println("  City :: "+employee.getAddress().getCity());
		System.out.println("  State :: "+employee.getAddress().getState());
		System.out.println("  Country :: "+employee.getAddress().getCountry());
		System.out.println("  PinCode :: "+employee.getAddress().getPincode());
	}//main
}
