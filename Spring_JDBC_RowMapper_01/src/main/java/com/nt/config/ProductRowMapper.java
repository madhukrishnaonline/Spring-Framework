package com.nt.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.product.Product;

public class ProductRowMapper implements RowMapper<Product> 
{
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Product product = new Product();
		
		product.setOrderId(rs.getString("id"));
		product.setOrderName(rs.getString("name"));
		product.setOrderPrice(rs.getInt("price"));
		
		return product;
	}//mapRow method
}//class