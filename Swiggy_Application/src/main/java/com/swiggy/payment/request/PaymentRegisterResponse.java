package com.swiggy.payment.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRegisterResponse 
{
	private String paymentId;
	private String paymentStatus;
	private String paymentMode; 
	private String paymentDate;
	private String paymentTime;
}
