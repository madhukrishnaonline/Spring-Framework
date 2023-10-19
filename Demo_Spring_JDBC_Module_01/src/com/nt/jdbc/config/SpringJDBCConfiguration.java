package com.nt.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJDBCConfiguration
{
   @Bean
   public JdbcTemplate getJdbcTemplate()
   {
	   DriverManagerDataSource dataSource = new DriverManagerDataSource();
	   dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	   dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	   dataSource.setUsername("XXXXX");
	   dataSource.setPassword("XXXXX");

	   return new JdbcTemplate(dataSource);
   }
}
