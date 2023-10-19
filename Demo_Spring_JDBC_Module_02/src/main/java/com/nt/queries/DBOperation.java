package com.nt.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nt.product.Product;

@Component
public class DBOperation {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addProduct(Product product) {
		String query = "insert into product values('" + product.getOrderId() + "','" + product.getOrderName() + "',"
				+ product.getOrderPrice() + ")";
		jdbcTemplate.update(query);
	}
}//class