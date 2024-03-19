package com.example.demo.configurationsecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UsersEntity;
import com.example.demo.repo.UserRepo;
@Component
public class UserServiceImplementaion implements UserDetailsService{
	
	 @Autowired
	   private UserRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<UsersEntity> userInfo = repository.findByName(username);
	        return userInfo.map(UserDetailsDao::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
	}

}
