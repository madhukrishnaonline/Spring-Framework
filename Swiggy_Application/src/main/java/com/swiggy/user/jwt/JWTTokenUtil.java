package com.swiggy.user.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenUtil 
{
	private long expirationTime = 3*60000;
	private final String SECRET_KEY  = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			                                                               + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			                                                               + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			                                                               + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	
	@SuppressWarnings("deprecation")
	public String createToken(String email)
	{
		return Jwts.builder()
		.setSubject(email)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+expirationTime))
		.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
		.compact();
	}
	
              	//validate token
	public boolean isValidToken(String email,String token)
	{
		String tokenMail = getEmailFromToken(token);
		
		boolean isExpired = isTokenExpired(token);
		
		return email.equals(tokenMail) && !isExpired;
	}
	
          	//  validate mail from token
	@SuppressWarnings("deprecation")
	public String getEmailFromToken(String token)
	{
		String mailFromToken = Jwts.parser()
				                                          .setSigningKey(SECRET_KEY)
				                                          .parseClaimsJws(token)
				                                          .getBody().getSubject();
				
		return mailFromToken;
	}
	
	// validate token is expired or not
	@SuppressWarnings("deprecation")
	public boolean isTokenExpired(String token)
	{
		Date isExpired = Jwts.parser()
				                           .setSigningKey(SECRET_KEY)
				                           .parseClaimsJws(token)
				                           .getBody().getExpiration();
		
		return isExpired.before(new Date());
	}
	
}//class