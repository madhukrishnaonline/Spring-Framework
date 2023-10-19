package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController 
{	
	@GetMapping("/login")
	public String getLoginForm()
	{
		return "login";
	}
	
	@PostMapping("/loginCheck")
	public String getLoginDetails(Model model, HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		
		if("madhukrishnaonline".equalsIgnoreCase(name) && "Madhu@123".equals(password))
		{
		  model.addAttribute("isLoginSuccessOrNot", "Login Successful....<br>"
		                                     +"Hello Mr."+name+"<br>Your Password is :: "+password);
		}
		else
		{
			model.addAttribute("isLoginSuccessOrNot","Login Failed<br> UserName / Password Invalid ");
		}
		return "loginResponse";
	}
	
}//class