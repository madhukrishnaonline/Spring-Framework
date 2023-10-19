package com.swiggy.user.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest 
{
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String city;
	private String gender;
	private int age;

}//class
