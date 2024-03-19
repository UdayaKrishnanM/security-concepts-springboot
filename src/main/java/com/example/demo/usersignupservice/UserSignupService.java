package com.example.demo.usersignupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UsersEntity;
import com.example.demo.repo.UserRepo;

@Service
public class UserSignupService {
	
	@Autowired
    private UserRepo repository;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	 public String addUser(UsersEntity userentity) {
		 userentity.setPassword(passwordEncoder.encode(userentity.getPassword()));
	        repository.save(userentity);
	        return "user added to system ";
	    }
}
