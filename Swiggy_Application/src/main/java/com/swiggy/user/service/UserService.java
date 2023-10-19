package com.swiggy.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.swiggy.user.entity.SwiggyUsers;
import com.swiggy.user.jwt.JWTTokenUtil;
import com.swiggy.user.repository.UserRepository;
import com.swiggy.user.request.UserRegisterRequest;
import com.swiggy.user.response.UserRegisterResponse;

// Component class
@Service
public class UserService implements UserDetailsService
{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JWTTokenUtil jwtToken;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String registerUserDetails(UserRegisterRequest registerRequest) {

		// Transferring data to Repository

		SwiggyUsers user = new SwiggyUsers();
		user.setEmail(registerRequest.getEmail());
		user.setMobile(registerRequest.getMobile());
		user.setName(registerRequest.getName());
		user.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
	    System.out.println("password Length ::"+user.getPassword().length());
		user.setCity(registerRequest.getCity());
		user.setGender(registerRequest.getGender());
		user.setAge(registerRequest.getAge());

		repository.save(user);

		return "User Registered Successfully";

	}

	public UserRegisterResponse getUserDetails(String email) {

		SwiggyUsers user = repository.findById(email).get();

		//user.orElseThrow(()-> new RuntimeException("Email Not Found"));
		
		UserRegisterResponse response = new UserRegisterResponse();
		response.setEmail(user.getEmail());
		response.setMobile(user.getMobile());
		response.setName(user.getName());
		response.setCity(user.getCity());
		response.setGender(user.getGender());
		response.setAge(user.getAge());

		return response;
	}

	public List<SwiggyUsers>  getAllUserDetails() {

		return  repository.findAll();

	}

	public List<UserRegisterResponse> getCity(String city) 
	{
	    List<SwiggyUsers> users = repository.findByCity(city);
	    
	   List<UserRegisterResponse> response = users.stream().map(v->new UserRegisterResponse(
	    		v.getName(),
	    		v.getEmail(),
	    		v.getMobile(),
	    		v.getCity(),
	    		v.getGender(),
	    		v.getAge(), city
	    		)).collect(Collectors.toList());
	    
		return response;
	}

	public String deleteRecord(String email) 
	{
		     repository.deleteById(email);
		     
		return "Successfully deleted record";
	}

	public String updateRecord(UserRegisterRequest registerRequest) 
	{
		SwiggyUsers user = new SwiggyUsers();
		user.setEmail(registerRequest.getEmail());
		user.setMobile(registerRequest.getMobile());
		user.setName(registerRequest.getName());
		user.setPassword(registerRequest.getPassword());
		user.setCity(registerRequest.getCity());
		user.setGender(registerRequest.getGender());
		user.setAge(registerRequest.getAge());
		
		 repository.save(user);
		 
		return "record Updated Successfully...";
	}

	public String generateToken(String email) 
	{
		SwiggyUsers user = repository.findById(email).get();
		
		if(repository.existsById(email))
		{
			UserRegisterResponse response = new UserRegisterResponse();
			response.setEmail(user.getEmail());
			return jwtToken.createToken(response.getEmail());			
		}
		else
		{
			return "Not Found";
		}
	}

	public boolean validateToken(String email, String token) 
	{
		 SwiggyUsers user = repository.findById(email).get();
		  
		 if(repository.existsById(email))
		 {
			 UserRegisterResponse response = new UserRegisterResponse();
			 response.setEmail(user.getEmail());
			 
			 jwtToken.isValidToken(response.getEmail(), token);
			 return true;
		 }//if
		 else
		 {
			 return false;
		 }//else
			     	
		//return jwtToken.isValidToken(email, token);
	}//validateToken()


	/*public String  loginUser(UserRegisterRequest request) 
	{
	    SwiggyUsers swiggyUsers =	repository.findByEmailAndPassword(request.getEmail(),request.getPassword());
	   
	   if(swiggyUsers!=null)
	   {
		  return "Login Successfull";
	   }
	   else
	   {
		   	   return "Invalid UserName or Password ";
	   }
	}*/

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		Optional<SwiggyUsers> swiggyUsers = repository.findById(email);
		
	SwiggyUsers userDetails = swiggyUsers.orElseThrow(()-> new RuntimeException("Email Not Found"));
		
		return userDetails;
	}	
	
	
	
	
	
}//class