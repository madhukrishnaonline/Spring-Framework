package com.nt.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nt.config.ProductRowMapper;
import com.nt.product.Product;

@Component
public class DBOperations 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> loadAllProducts()
	{
		String query = "Select*from product";
		
		List<Product> products = jdbcTemplate.query(query, new ProductRowMapper());
		
		//System.out.println(products);
	
		for(Product p:products)
		{
			System.out.print(p.getOrderId()+"\t");
			System.out.print(p.getOrderName()+"\t");
			System.out.print(p.getOrderPrice()+"\t");
		}//for
		
		return products;
	}//loadAllProducts
}//class