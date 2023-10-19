package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.product.Product;

//@Component
public interface ProductRepository extends JpaRepository<Product, String>  
{

	//select allProducts
	List<Product> selectAllProducts();
}//interface