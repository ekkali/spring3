package com.demo3.api;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.demo3.config.democonfig;

public class demoapi implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		
		context.register(democonfig.class);
		
		
		DispatcherServlet servlet = new DispatcherServlet(context);
		
		
 	ServletRegistration.Dynamic custom =  servletContext.addServlet("dispatcherservlet", servlet);
		
 	
 	         custom.setLoadOnStartup(1);
 	         
 	         
 	        custom.addMapping("/demo/*");

	}

}
