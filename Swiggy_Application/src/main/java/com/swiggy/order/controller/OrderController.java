package com.swiggy.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.order.AccountResponse.UserAccountDetailsResponse;
import com.swiggy.order.request.OrderRegisterRequest;
import com.swiggy.order.response.OrderRegisterResponse;
import com.swiggy.order.service.OrderService;

      //register order details
@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/registerOrderDetails")
	public String registerOrderDetails(@RequestBody OrderRegisterRequest request)
	{
		String response = orderService.registerOrderDetails(request);
		return response;
	}
	
	//get details based on Id
	@GetMapping("/orderDetails/{emailId}")
	public OrderRegisterResponse getOrderDetails(@PathVariable String emailId)
	{
	     OrderRegisterResponse response = orderService.getOrderDetails(emailId);
	    
		return response;
	}
	
	//get account details
	
	@GetMapping("/get/{accountNumber}")
	public UserAccountDetailsResponse getAccountDetails(@PathVariable long accountNumber)
	{
		return orderService.getAccountDetails(accountNumber);
		
	}
	
}//class