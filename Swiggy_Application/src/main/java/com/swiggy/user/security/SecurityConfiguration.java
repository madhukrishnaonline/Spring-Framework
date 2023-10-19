package com.swiggy.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration 
{
	@Autowired
	JWTTokenAuthenticatonFilter jwtTokenAuthenticatonFilter;
	
	//pre-defined classes beans
	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception 
	{
		return configuration.getAuthenticationManager();
	}
	
	//password should be encoded/encrypted
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception 
	{
		System.out.println("This SecurityFilterChain rules");
		
		security.csrf().disable()
		.authorizeHttpRequests().antMatchers("/user/register","/user/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(this.jwtTokenAuthenticatonFilter, UsernamePasswordAuthenticationFilter.class);
		
		return security.build();
	}
	
}//class