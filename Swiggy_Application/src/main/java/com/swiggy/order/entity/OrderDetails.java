package com.swiggy.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="order_details")
public class OrderDetails 
{
	@Id
	@Column
	private String emailId;
	@Column
	private String orderId;
	@Column
	private String orderStatus;
	@Column
	private String orderCurrentStatus;
}//class