package com.nt.address;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("office")
@Scope("prototype")
public class Address {
	private String street, city;

	public Address() {
        System.out.println("Address Object");
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
