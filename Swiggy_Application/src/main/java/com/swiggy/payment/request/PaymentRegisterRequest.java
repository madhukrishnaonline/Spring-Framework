package com.swiggy.payment.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRegisterRequest 
{
	private String paymentId;
	private String paymentStatus;
	private String paymentMode; 
}
