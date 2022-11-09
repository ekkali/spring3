package com.demo3.controller;


import java.security.Principal;





import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.resource.HttpResource;

import com.demo3.DTO.userdto;
import com.mysql.cj.Session;
import com.demo3.DTO.UserDao;
import com.demo3.DTO.changepasswordDTO;
import com.demo3.DTO.userdaoimpl;



@Controller
public class democontroller {
	
	@Autowired
	private  UserDao  userdaoimpl;
	
	@Autowired
	private PasswordEncoder encode;
	
	
	@Autowired
	private UserDetailsManager manager;
	
	private static final Logger log = Logger.getAnonymousLogger();

	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") userdto dto ) {
		
		log.info(" login filter called ");
		
		  
		return "login";
	}
	
	
	
	
	@RequestMapping("/process-login")
	public String processlogin(userdto dto ,HttpServletRequest req, HttpSession session) {
		
		String username =    dto.getUsername();
		
		      System.out.println(username );
		
		      //String user = (String)  req.getAttribute("username");
		
		      //System.out.println(user);
		      
		      
		         session.setAttribute("username", username);
		         
		
		         userdaoimpl.show(dto.getUsername());
		
		      log.info("  debugging inside load user by user name ");
		      
		        long lastAccessedTime = session.getLastAccessedTime();
		
		        System.out.println(lastAccessedTime);
		        
		        
		return "process-login";
		
		
		
	}
	
	
	
	
	
	@RequestMapping("/home")
	 public String Home(HttpSession session,Model model ) {
		 
	  String username =  (String) 	session.getAttribute("username");
		
	  model.addAttribute("username", username);
	  
	  System.out.println(username);
	  
	  log.info("inside demo home controller ");
	  
		 return "home";
	 }
	
	
	
	
	 
	 
	@RequestMapping("/changepassword")
	 public String changepassword(@ModelAttribute("changepassword")changepasswordDTO dto) {
		 
		 
		 
		 return "changepassword";
	 }
	       
	 
	 
	@RequestMapping("/processchange")
	 public String processchangepassword(changepasswordDTO dto,Principal principal) {
		 
		 List<userdto> loaduser = userdaoimpl.show(principal.getName());
		 
		 
	          if(loaduser.isEmpty()) {
	        	  
	        	  
	        	  throw new UsernameNotFoundException(" Invalid User ");
	        	  
	        	  
	          }
	          
	          
		         boolean matches = encode.matches(dto.getOldpassword(), principal.getName());
		 
		         
		           if(matches) {
		        	   
		        	   
		        	   String encode2 = encode.encode(dto.getConfirmpassword());
		        	   
		               manager.changePassword(dto.getOldpassword(), encode2);  	   
		        	   
		           }
		           
		            if(!matches) {
		            	
		            	log.info("  Invalid Credentials ");
		            }
		           
		           
		           if(!dto.getNewpassword().equals(dto.getConfirmpassword())) {
		        	   
		        	   
		        	    throw new UsernameNotFoundException("invalid Password");
		        	   
		           }
		         
		           
		              log.info(" inside process change password ");
		              
		              log.info("");
		              
		             
		              
		              
		              
		              
		          
		 
		              
		               
		 
		 return "processchangepassword";
	 }
	
	
	 
	
	
	@RequestMapping("/register")
	 public String register(@ModelAttribute("user") userdto dto) {
		 
		 String username = dto.getUsername();
		  
		 System.out.println(username);
		 
		 return "register";
	 }
	
	
	
	
	@RequestMapping("/processregister")
	 public String processregister(userdto dto) {
		 
		  String username = dto.getUsername();
		
		  System.out.println(username);
		  
		       encode.encode(dto.getPassword());
		
		       userdaoimpl.register(dto);
		 
		 return "processregister";
	 }
	
	
	
	@RequestMapping("/admin")
	 public String dashboard() {
		 
		 return "admindashboard";
	 }
	
	
	  
	
	
	
	
	@RequestMapping("/logout")
	 public String logout() {
		
		
		log.info("  logout filer called ");
		 
		
		 return "logout";
	 }
	
	






}