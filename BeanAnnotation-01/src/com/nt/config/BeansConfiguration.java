package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.beans.UserDetails;

@Configuration
public class BeansConfiguration {
	/*	private UserDetails userDetails;*/

	@Bean("userDetails")
	 UserDetails getUserDetails() {
		return new UserDetails();
	}

	/*public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}*/

}
