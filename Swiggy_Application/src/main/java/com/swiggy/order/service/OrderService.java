package com.swiggy.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swiggy.order.AccountResponse.UserAccountDetailsResponse;
import com.swiggy.order.entity.OrderDetails;
import com.swiggy.order.repository.OrderRepository;
import com.swiggy.order.request.OrderRegisterRequest;
import com.swiggy.order.response.OrderRegisterResponse;

@Service
public class OrderService 
{
	@Autowired
	private OrderRepository orderRepository;
	
	public String registerOrderDetails(OrderRegisterRequest request) 
	{
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(request.getOrderId());
		orderDetails.setEmailId(request.getEmailId());
		orderDetails.setOrderStatus(request.getOrderStatus());
		orderDetails.setOrderCurrentStatus(request.getOrderCurrentStatus());
		
		orderRepository.save(orderDetails);
	
		return "Order Details Registered Successfully...";
	}//register

	public OrderRegisterResponse getOrderDetails(String emailId)
	{
		OrderDetails details  = orderRepository.findById(emailId).get();
		
		OrderRegisterResponse response = new OrderRegisterResponse();
		 response.setOrderId(details.getOrderId());
		 response.setEmailId(details.getEmailId());
		 response.setOrderStatus(details.getOrderStatus());
		 response.setOrderCurrentStatus(details.getOrderCurrentStatus());
	
		return response;
	}//get

	public UserAccountDetailsResponse getAccountDetails(long accountNumber) 
	{	
		String URL = "http://localhost:8080/StateBankOfIndia/sbi/user/get/account/"+accountNumber;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("protect", "protected");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<UserAccountDetailsResponse> responseEntity =
				                                      template.exchange(URL, HttpMethod.GET, entity, UserAccountDetailsResponse.class);
		
		return responseEntity.getBody();
	}

}//class
