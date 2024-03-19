package com.example.demo.configurationsecurity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.UsersEntity;

public class UserDetailsDao implements UserDetails{
	
	    private String name;
	    private String password;
	    private List<GrantedAuthority> authorities;
	    
	    
	    

		public String getName() {
				return name;
			}

		public void setName(String name) {
			this.name = name;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setAuthorities(List<GrantedAuthority> authorities) {
			this.authorities = authorities;
		}
		
		

	public UserDetailsDao(UsersEntity user) {
			this.name = user.getName();
			this.password = user.getPassword();
			 authorities= Arrays.stream(user.getRoles().split(","))
		                .map(SimpleGrantedAuthority::new)
		                .collect(Collectors.toList());
		}

	
	public UserDetailsDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "UserDetailsDao [name=" + name + ", password=" + password + ", authorities=" + authorities + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
