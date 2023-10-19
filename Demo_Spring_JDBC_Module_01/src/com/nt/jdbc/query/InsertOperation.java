package com.nt.jdbc.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InsertOperation 
{
	@Autowired
   private JdbcTemplate jdbcTemplate;
	
	public int addStudent()
	{
		String query = "insert into students values(1021,'madhu','java')";
		int insertedRowsCount = jdbcTemplate.update(query);
		
		return insertedRowsCount;
	}//adding student details to db
}
