package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.example.demo.entity.UsersEntity;

public interface UserRepo extends JpaRepository<UsersEntity, Integer>{
	 Optional<UsersEntity> findByName(String username);
}
