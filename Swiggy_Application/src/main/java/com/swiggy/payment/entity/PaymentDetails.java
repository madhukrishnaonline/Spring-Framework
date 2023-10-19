package com.swiggy.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="payment_details")
public class PaymentDetails {
	@Id
	@Column
	private String paymentId;
	@Column
	private String paymentDate;
	@Column
	private String paymentTime;
	@Column
	private String paymentStatus;
	@Column
	private String paymentMode; 
}
