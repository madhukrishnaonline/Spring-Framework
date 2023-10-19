package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController 
{
	@GetMapping("/reg")
   public String getRegisterForm()
   {
	   return "register";
   }
	
	@PostMapping("/register")
	public String registerDetails(Model model, HttpServletRequest request)
	{
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String qualify = request.getParameter("qualify");
		String percent = request.getParameter("percent");
		String gender = request.getParameter("gender");
		
		if(fName!=null && lName!=null && qualify!=null && percent!=null && gender!=null) {
			model.addAttribute("fName",fName);
			model.addAttribute("lName", lName);
			model.addAttribute("qualify",qualify);
			model.addAttribute("percent",percent);
			model.addAttribute("gender",gender);
			
			model.addAttribute("loginSuccess","*****User Details*****");
		}
		else
		{
			model.addAttribute("isLoginSuccessOrNot", "Invalid Values.........");
		}
		return "loginResponse";
	}
}//class