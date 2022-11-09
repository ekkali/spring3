package com.demo3.DTO;

import com.demo3.DTO.UserDao;

import com.demo3.DTO.userdaoimpl;
import com.demo3.DTO.userdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.security.Principal;
import java.util.List;

public class customuserdetailsservice implements UserDetailsService {

    @Autowired
    private userdaoimpl impl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {




           List<userdto> userdto = impl.show(com.demo3.DTO.userdto.class.getName());
     
           
           

                userdto.get(0).getUsername();


              if(userdto.isEmpty()){

                  throw new UsernameNotFoundException("invalid credentials");
              }

                 userdto dto =  userdto.get(0);

        UserDetails user = User.withUsername(dto.getUsername())
                .password(dto.getPassword())
                .authorities("user").build();


        return user;
    }
}
