package com.demo3.security;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import com.demo3.custom.customAuthenticationprovider;

@EnableWebSecurity
public class demo3securityconfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsManager manager;

	@Autowired
	private DataSource source;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private customAuthenticationprovider provider;
	

	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception { // TODO Auto-generated method stub
	  
			
			/*
			 * auth.jdbcAuthentication() .dataSource(source) . passwordEncoder(encoder);
			 */
	  
		  
		    auth.authenticationProvider(provider);
		   
		   
	  }
	 
	
	  @Override protected void configure(HttpSecurity http) throws Exception { //
	 
	  
	       http.authorizeRequests()
	        //.antMatchers("/demo/process-login").hasAnyAuthority("user")
	        .antMatchers("/demo/home").hasAnyAuthority("user")
	        .antMatchers("/demo/admin").hasAnyAuthority("Admin")
	        .antMatchers("demo/admin").hasAuthority("Admin")
	        
	         .and()
	             .formLogin().loginPage("/demo/login").loginProcessingUrl("/demo/process-login")//.loginProcessingUrl("/demo/process-login").loginProcessingUrl("/demo/home")//.successForwardUrl("/demo/home")//.loginProcessingUrl( "/demo/process-login").successForwardUrl("/demo/home")
	              .and()
	            .logout().logoutUrl("/demo/logout").logoutSuccessUrl("/demo/login");   
	     
	  }
	 

}
