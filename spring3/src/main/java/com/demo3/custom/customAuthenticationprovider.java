package com.demo3.custom;

import com.demo3.DTO.userdaoimpl;


import com.demo3.DTO.userdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessEventPublishingLogoutHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class customAuthenticationprovider implements AuthenticationProvider {

	@Autowired
	private userdaoimpl impl;
	
	
	@Autowired
	private PasswordEncoder encoder;



	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub


	    Logger log = Logger.getAnonymousLogger();

		
		String name = authentication.getName();
		
		 String string = (String)  authentication.getCredentials();
		 
		 
		 System.out.println(name+" "+string);
		
		  List<userdto> show = impl.show(name);
		  
		   userdto userdto = show.get(0);
		   
		   
		   boolean matches = encoder.matches(string, userdto.getPassword() );
		  
		     if(show.size() > 0) {
		    	 
		    	 userdto dto = show.get(0);
		    	 
		    	 
		    	 
		    	 if(matches) {
			    	  
			    	  
			    	  
			    	  ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
			    	  
			    	   auth.add(new SimpleGrantedAuthority("user"));


			    	     log.info(" inside username password authentication token  ");
			    	   
			    	       
			    	     
			    	  return new UsernamePasswordAuthenticationToken(name, string, auth);

			      }else {
			    	  
			    	  throw new BadCredentialsException(" invalid user ");
			    	  
			      }
		    	 
		    	 
		    	 
		    	 
		    	 
		     }else {
		    	 
		    	 
		    	 throw new UsernameNotFoundException(" Users Not found inside DataBase ");
		    	
		    	  
		    	 
		     }
		     
		     
		    
		     
		     
		      
		      
		   
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
