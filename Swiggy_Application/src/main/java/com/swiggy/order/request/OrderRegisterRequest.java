package com.swiggy.order.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRegisterRequest
{
	private String orderId;
	private String emailId;
	private String orderStatus;
	private String orderCurrentStatus;
}//class