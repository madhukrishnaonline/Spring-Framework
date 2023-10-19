package com.swiggy.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterResponse 
{
	private String name;
	private String email;
	private String mobile;
	private String city;
	private String gender;
	private int age;
	private String token;

}//class
