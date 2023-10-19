package com.swiggy.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.user.entity.SwiggyUsers;
import com.swiggy.user.jwt.JWTTokenUtil;
import com.swiggy.user.request.UserRegisterRequest;
import com.swiggy.user.response.UserRegisterResponse;
import com.swiggy.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;

	@Autowired
	JWTTokenUtil jwtToken;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public String registerUserDetails(@RequestBody UserRegisterRequest request) 
	{
		
		String response = userService.registerUserDetails(request);

		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserRegisterResponse> loginUser(@RequestBody UserRegisterRequest request)
	{
		//===> To Do:
		//we need to pass the Credentials to Spring Security
		doAuthentication(request.getEmail(), request.getPassword());
		
		String token = jwtToken.createToken(request.getEmail());
		
		UserRegisterResponse response = new UserRegisterResponse();
		response.setEmail(request.getEmail());
		response.setToken(token);
		
		//Internally Spring Security Validate the User Credentials
		
		//Internally Security connects to DB, and check for username & password
		
		//if User is valid and certified by Security	, Generates token and attach as part of response object
		
		//jwt token generation : by passing userName
		
		//incase user is invalid , then we will send a message like invalid credentials
		
		 
		 return new ResponseEntity<UserRegisterResponse>(response,HttpStatus.FOUND);
	}//login
	
	private void doAuthentication(String userName,String password)
	{
		//passing userName and password to authenticationManager
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
		try
		{
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);			
		}
		catch(BadCredentialsException badCredentialsException)
		{
			throw new RuntimeException("Invalid Username and password");
		}
	}

	// Fetch user Details of one Person by email ID

	@GetMapping("/fetch/{emailId}")
	public UserRegisterResponse getUserDetails(@PathVariable("emailId") String email) 
	{

		UserRegisterResponse response = userService.getUserDetails(email);

		// JAVA should be converted to JSON
		return response;
	}

	// Loading all User Details

	@GetMapping("/fetch/all")
	@ResponseBody
	public List<SwiggyUsers> getAllUserDetails() {

		return userService.getAllUserDetails();
	}
	
	//queryString and QueryParameters
	
	@GetMapping("/get")
	public List<UserRegisterResponse> getCityAndAge(@RequestParam("city") String city)
	{
		return   userService.getCity(city);	
	}
	
	@DeleteMapping("/delete/{email}")
	public String deleteRecord(@PathVariable String email)
	{
		  return userService.deleteRecord(email);
	}
	
	@PutMapping("/update")
	public String updateRecord(@RequestBody UserRegisterRequest request)
	{
		return userService.updateRecord(request);	
	}
	
	@GetMapping("/get/token/{email}")
	public ResponseEntity<String> generateToken(@PathVariable String email)
	{
		String response = userService.generateToken(email);
		
		if(response!=null)
		{
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/validate/token/{email}")
	public ResponseEntity<Boolean> validateToken(@PathVariable String email,@RequestHeader String token)
	{
		
		boolean result = userService.validateToken(email,token);
		if(result)
		{
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
	}
	
}//class
