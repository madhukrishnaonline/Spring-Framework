package com.nt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderControl 
{
	@PostMapping("/add")
    public String addOrders()
    {
    	return "Order Added";
    }
	
	@PutMapping("/add")
	public String updateOrders()
	{
		return "Order Updated";
	}
}//class