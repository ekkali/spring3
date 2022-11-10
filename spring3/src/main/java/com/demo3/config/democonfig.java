package com.demo3.config;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages="com.demo3")
public class democonfig {

	@Bean
	 public ViewResolver Resolver() {
		 
		 InternalResourceViewResolver view = new InternalResourceViewResolver();
		 
		 view.setPrefix("/WEB-INF/views/");
		 
		 view.setSuffix(".jsp");
		 
		 
		 return view;
		 
	 }
	
	 @Bean     
	 public DataSource dataSource() {
		 
		 DriverManagerDataSource data = new DriverManagerDataSource();
		 
		 data.setUsername("root");
		 
		 data.setPassword("12345");
		 
		 data.setUrl("jdbc:mysql://localhost:3306/spring");
		 
		 data.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 
		 return data;
		 
	 }
	
	
	
	  @Bean
	  public JdbcTemplate tem() {
		  
		  
		  JdbcTemplate template = new JdbcTemplate(dataSource());
		  
		  return template;
	  }
	  
	  
	  
	   @Bean
	   public UserDetailsManager manager() {
		   
		   
		   
		   JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager(dataSource());
		   
		   return detailsManager;
	   }
	   
	   
	   @Bean
	   public PasswordEncoder passwordEncoder() {
		   
		   
		   BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		   
		   
		   return bCryptPasswordEncoder;
		   
	   }
	   
	   
	   
	  
	  
	  
	
	
}
