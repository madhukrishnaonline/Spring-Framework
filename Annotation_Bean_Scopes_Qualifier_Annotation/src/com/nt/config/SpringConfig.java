package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nt.address.Address;
import com.nt.address.Employee;

@Configuration
//@ComponentScan("com.nt.address")
public class SpringConfig 
{
	@Bean("home")
	@Scope("prototype")
	  public Address getDetailss()
	  {
		 return new Address();
	  }
	
	@Bean("madhu")
	public Employee getEmployee()
	{
		return new Employee();
	}
}//class
