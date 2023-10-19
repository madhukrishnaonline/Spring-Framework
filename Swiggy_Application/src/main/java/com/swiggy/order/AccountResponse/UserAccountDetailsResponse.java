package com.swiggy.order.AccountResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserAccountDetailsResponse 
{
	private long accountNumber;
	private String accountHolder;
	private String ifscCode;
	private long mobile;
	private String accountType;
	private String branchName;
	private double accountBalance;
	private String accountAddress;
}//class