package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.nt.address.Address;
import com.nt.address.Employee;

@Configuration
public class SpringConfig 
{
	@Bean("home")
	@Primary
	  public Address getDetailss()
	  {
		System.out.println("Home Address");
		 return new Address();
	  }
	
		@Bean("madhu")
		public Employee getEmployee()
		{
			return new Employee();
		}
}//class