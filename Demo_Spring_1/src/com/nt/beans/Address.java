package com.nt.beans;

public class Address 
{
   private String street,city;
   private int pinCode;

   
	/*public Address(String street, String city, String pinCode)
	{
		super();
		this.street = street;
		this.city = city;
		this.pinCode = pinCode;
	}*/

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
	
	public int getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
   
   public void address()
   {
	   System.out.println("Address Of Employee...");
   }
}
