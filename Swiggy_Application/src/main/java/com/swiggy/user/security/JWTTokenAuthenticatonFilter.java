package com.swiggy.user.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.swiggy.user.jwt.JWTTokenUtil;
import com.swiggy.user.service.UserService;

@Component
public class JWTTokenAuthenticatonFilter extends OncePerRequestFilter
{
	@Autowired
	JWTTokenUtil jwtToken;
	
	@Autowired
	UserService service;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		//get token from header
	     String token = request.getHeader("Authorization");
	     System.out.println("token : "+token);
	     
	     //get username from token
	     String emailFromToken = null;
	     
	     //verify token is available or not
	     if(token==null)
	     {
	    	 System.out.println("token is missing......  please add token");
	     }//if
	     else
	     {
	    	 //if token available verify userName
	    	  emailFromToken = jwtToken.getEmailFromToken(token);	 
	     }//else
	     
	     if(emailFromToken!=null && SecurityContextHolder.getContext().getAuthentication()==null)
	     {
	    	 //security layer will verify that email is available in DB or not
	    	 UserDetails userDetails = service.loadUserByUsername(emailFromToken);
	    	 
	    	 //validate token w.r.t expiry time & username
	    	 boolean isValidToken = jwtToken.isValidToken(userDetails.getUsername(), token);
	    	 
	    	 if(isValidToken)
	    	 {
	    		 //update security context data for user
	    		 
	    		 //spring security provided a token class and as part of  token class we are going to pass user information
	    		 
	    		 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                        	    				 new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
	    		 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	    	 }//if
	    	 else
	    	 {
	    		 System.out.println("Token is Invalid.... Enter a Valid Token..");
	    	 }//else
	    	 //allow requests from controller
	    			 
	     }//if
	     //next filter forwarding
	      filterChain.doFilter(request, response);
	     
	}//doFilterInternal

}//class
