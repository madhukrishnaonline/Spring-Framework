package com.swiggy.order.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRegisterResponse
{
	private String orderId;
	private String emailId;
	private String orderStatus;
	private String orderCurrentStatus;
}//class