package com.swiggy.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.user.entity.SwiggyUsers;

@Repository
public interface UserRepository extends JpaRepository<SwiggyUsers, String>{

	List<SwiggyUsers> findByCityAndAge(String city, int age);

	List<SwiggyUsers> findByCity(String city);

	SwiggyUsers findByEmailAndPassword(String email,String password);
	
	
     
}
