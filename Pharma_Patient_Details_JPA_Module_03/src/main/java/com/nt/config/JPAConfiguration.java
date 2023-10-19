package com.nt.config;

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
public class JPAConfiguration 
{
  @Bean
  public DataSource getSource()
  {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	  dataSource.setUsername("XXXX");
	  dataSource.setPassword("XXXX");
	  
	  return dataSource;
  }//dataSource
  
  @Bean("entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
  {
	    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    
	    //load dataSource to entityManagerFactoryBean
	    entityManagerFactoryBean.setDataSource(getSource());
	    
	    //load entity Factory 
	    entityManagerFactoryBean.setPackagesToScan("com.nt.patient.entity");
	    
	    //Hibernate Properties
	    entityManagerFactoryBean.setJpaProperties(getProperties());
	    
	    //Hibernate Implementation
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    entityManagerFactoryBean.setJpaVendorAdapter(adapter);
	    
	  return entityManagerFactoryBean;
  }
  
  @Bean("transactionManager")
  public PlatformTransactionManager manager()
  {
	  JpaTransactionManager transactionManager = new JpaTransactionManager();
	  transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
	  
	  return transactionManager;
  }//transactionManager
  
  public Properties getProperties()
  {
	  Properties properties = new Properties();
	  properties.setProperty("hibernate.hbm2ddl.auto", "update");
	  properties.setProperty("hibernate.show_sql", "true");
	  
	  return properties;
  }//properties
}//class