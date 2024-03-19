package com.example.demo.ControllerApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UsersEntity;
import com.example.demo.usersignupservice.UserSignupService;

@RestController
//@RequestMapping("/security")
public class SecurityController {
	
	 @Autowired
	    private UserSignupService service;
	
	@GetMapping(value ="/security-login", produces = "application/json")
	public String apiAccess() {
		return "logined successful";
		
	}
	
	@GetMapping("/udate")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String apiAccessprocess() {
		return "load data";
		
	}
	
	@PostMapping("/signup")
    public String addNewUser(@RequestBody UsersEntity userentity){
        return service.addUser(userentity);
    }
	
	

}
