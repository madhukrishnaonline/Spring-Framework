package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCConfiguration 
{
   @Bean
   public JdbcTemplate getJdbcTemplate()
   {
	   DriverManagerDataSource dataSource = new DriverManagerDataSource();
	   dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	   dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	   dataSource.setUsername("XXXX");
	   dataSource.setPassword("XXXX");
	   
	   return new JdbcTemplate(dataSource);
   }//jdbcTemplate
}//class