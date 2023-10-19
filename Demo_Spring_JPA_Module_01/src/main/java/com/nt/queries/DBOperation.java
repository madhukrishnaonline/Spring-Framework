package com.nt.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.product.Product;
import com.nt.repository.ProductRepository;

@Component
public class DBOperation 
{
	@Autowired
   private ProductRepository productRepository;
	
	//insert single || Update
	public void addProduct(Product product)
	{
		productRepository.save(product);
	}
	
	//insert multiple
	public void addMultipleProducts(List<Product> products)
	{
		productRepository.saveAll(products);
	}
	
	//select
	public List<Product> loadAllProducts()
	{
		return productRepository.findAll();
	}
	
}//class