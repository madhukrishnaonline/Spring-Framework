package com.swiggy.payment.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.payment.entity.PaymentDetails;
import com.swiggy.payment.repository.PaymentRepository;
import com.swiggy.payment.request.PaymentRegisterRequest;
import com.swiggy.payment.request.PaymentRegisterResponse;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repository;

	public String registerPayment(PaymentRegisterRequest request) 
	{
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPaymentId(request.getPaymentId());
		paymentDetails.setPaymentDate(LocalDate.now().toString());
		paymentDetails.setPaymentTime(LocalTime.now().toString().substring(1,8));
		paymentDetails.setPaymentMode(request.getPaymentMode());
		paymentDetails.setPaymentStatus(request.getPaymentStatus());
		
		repository.save(paymentDetails);
		return "Payment Registartion Successfull......";
	}

	public PaymentRegisterResponse getPaymentDetails(String paymentId)
	{
		PaymentDetails details = repository.findById(paymentId).get();
				
		PaymentRegisterResponse response = new PaymentRegisterResponse();
		if(repository.existsById(paymentId))
		{
			response.setPaymentId(details.getPaymentId());
			response.setPaymentStatus(details.getPaymentStatus());
			response.setPaymentMode(details.getPaymentMode());
			response.setPaymentDate(details.getPaymentDate());
			response.setPaymentTime(details.getPaymentTime());
			
			return response;
		}
		else
		{
			return response;
		}
	}

}//class
