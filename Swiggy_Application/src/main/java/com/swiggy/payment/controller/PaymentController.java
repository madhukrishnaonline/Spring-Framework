package com.swiggy.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.payment.request.PaymentRegisterRequest;
import com.swiggy.payment.request.PaymentRegisterResponse;
import com.swiggy.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController 
{
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String registerPayment(@RequestBody PaymentRegisterRequest request)
	{
		return paymentService.registerPayment(request);
	}
	
	@GetMapping("/get/{paymentId}")
	public ResponseEntity<PaymentRegisterResponse> getPaymentDetails(
			                                                 @PathVariable String paymentId, 
			                                                @RequestHeader(value = "city",required = false,defaultValue = "hyderabad") String city)
	{
		PaymentRegisterResponse response = paymentService.getPaymentDetails(paymentId);
		
		if(response!=null)
		{
		      return new ResponseEntity<PaymentRegisterResponse>(response,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<PaymentRegisterResponse>(response,HttpStatus.NOT_FOUND);
		}
	}
}//class
