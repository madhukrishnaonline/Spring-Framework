package com.nt.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.product.Product;
import com.nt.queries.DBOperation;

public class SpringMain {
	@SuppressWarnings({"resource","unused"})
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.nt.*");
		context.refresh();

			Product product = new Product();
		
			DBOperation dbOperation = context.getBean(DBOperation.class);
		
			List<Product> products = dbOperation.loadAllProducts();
			System.out.println(products);
	}//main
}//class