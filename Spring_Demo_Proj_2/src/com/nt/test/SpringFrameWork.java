package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

@SuppressWarnings("deprecation")
public class SpringFrameWork 
{
	public static void main(String[] args) 
	{
		FileSystemResource resource = new FileSystemResource("C:\\Users\\krishna\\FS-NTSP64-Spring\\Spring_Core_Proj-05\\src\\com\\nt\\cfgs\\applicationContext.xml");
		/*BeanFactory factory = new FileSystemXmlApplicationContext
			       ("C:\\Users\\krishna\\FS-NTSP64-Spring\\Spring_Core_Proj-05\\src\\com\\nt\\cfgs\\applicationContext.xml");*/
		XmlBeanFactory factory = new XmlBeanFactory(resource);
           WishMessageGenerator generator = (WishMessageGenerator) factory.getBean("wmg");
           
           String msg = generator.wishMessage("Madhu Krishna");
           System.out.println(msg);
	}//main
}//class