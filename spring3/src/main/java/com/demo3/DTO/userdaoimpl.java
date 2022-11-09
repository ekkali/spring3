package com.demo3.DTO;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userdaoimpl implements UserDao {

	 @Autowired
	public JdbcTemplate template;
	 
	 @Autowired
	 public PasswordEncoder encoder;
	
	
	@Override
	public List<userdto> show(String username) {
		// TODO Auto-generated method stub

		
		
		
		String sql = " SELECT * FROM spring.users where username=? ";
		
		Object[] obj = {username};
		
		       @SuppressWarnings("deprecation")
			 List<userdto> query = template.query(sql, obj, new BeanPropertyRowMapper<userdto>(userdto.class));
		
		     
		       
		          return query;
		
		
		     
		
		
		
	}


	@Override
	public void register(userdto dto) {
		// TODO Auto-generated method stub
		
		
		String sql=" Insert into Spring.Users values(?,?,?) ";
		
		 String username = dto.getUsername();
		
		 System.out.println(username);
		 
		Object[] obj= {dto.getUsername(),encoder.encode(dto.getPassword()),1};
		
		  //template.query(sql, obj, new BeanPropertyRowMapper<userdto>(userdto.class));
		
		  template.update(sql, obj);
		 
		
		 
	}

}
