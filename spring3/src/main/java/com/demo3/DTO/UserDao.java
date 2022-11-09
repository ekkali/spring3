package com.demo3.DTO;

import java.util.List;

public interface UserDao {
	
  public List<userdto>  show(String username);
  
  public void register(userdto dto);
  
  

}
