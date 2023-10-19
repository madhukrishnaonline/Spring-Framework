package com.swiggy.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.order.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, String> 
{

}//interface