package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.Address;

public class Test 
{
  @SuppressWarnings("resource")
public static void main(String[] args) 
  {
	  BeanFactory factory =new  FileSystemXmlApplicationContext
			                 ("C:/Users\\krishna/FS-NTSP64-Spring/Demo_Spring_1/src/com/nt/cfgs/applicationContext.xml");
	  Address address = (Address) factory.getBean("addr");
	  address.address();
	  System.out.println("Street Name :: "+address.getStreet());
	  System.out.println("City :: "+address.getCity());
	  System.out.println("PinCode :: "+address.getPinCode());
  }//main
}//class
