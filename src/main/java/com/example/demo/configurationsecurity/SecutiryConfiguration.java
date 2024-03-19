package com.example.demo.configurationsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecutiryConfiguration {
	@Bean
	public UserDetailsService userdetailService() {
		//UserDetails admin = User.withUsername("Malathi").password(encoder.encode("Alti@123")).roles("ADMIN").build();
		//UserDetails user = User.withUsername("nandhu").password(encoder.encode("Test@123")).roles("USER").build();
		return new UserServiceImplementaion();
		
	}
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
		
		 return http.csrf().disable()
            .authorizeRequests()
                .requestMatchers("/udate").permitAll()
                .requestMatchers("/security-login").authenticated()
            .and()
            .formLogin()
            .and()
            .build();
        
	}
	
	 @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userdetailService());
	        authenticationProvider.setPasswordEncoder(passwordencoder());
	        return authenticationProvider;
	    }


}
