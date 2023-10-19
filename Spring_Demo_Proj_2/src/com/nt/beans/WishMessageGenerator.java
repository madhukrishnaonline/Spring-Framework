package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@SuppressWarnings("deprecation")
	public String wishMessage(String user)
	{
		int hour = date.getHours();
		if(hour<12)
		{
			return "Good Morning "+user;
		}
		else if(hour<16)
		{
			return "Good AfterNoon "+user;
		}
		else if(hour<20)
		{
			return "Good Evening "+user;
		}
		else
		{
			return "Good Night "+user;
		}
	}
}//class