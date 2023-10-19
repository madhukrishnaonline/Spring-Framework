package com.nt.jpa.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories("com.nt.repository")
public class SpringJPAConfiguration 
{
   @Bean
   public DataSource getDataSource()
   {
	   DriverManagerDataSource dataSource = new DriverManagerDataSource();
	   dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	   dataSource.setUsername("XXXX");
	   dataSource.setPassword("XXXX");
	   
	   return dataSource;
   }//getDataSource
   
   @Bean("entityManagerFactory")
   public LocalContainerEntityManagerFactoryBean createEntityManagerFactory()
   {
	   LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
	   
	   factoryBean.setDataSource(getDataSource());
	   
	   factoryBean.setPackagesToScan("com.nt.product");
	   
	   factoryBean.setJpaProperties(getProperties());
	   
	   HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
	   factoryBean.setJpaVendorAdapter(adaptor);
	   
	   return factoryBean;
   }//entityContainer
   
   @Bean("transactionManager")
   public PlatformTransactionManager createTransactionManager()
   {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(createEntityManagerFactory().getObject());
	   return transactionManager;
   }
   
  
   public Properties getProperties()
   {
	 Properties properties = new Properties();
	 properties.setProperty("hibernate.hbm2ddl.auto", "validate");
	 properties.setProperty("hibernate.show_sql", "true");
	 
	 return properties;
   }//properties
   
}//class