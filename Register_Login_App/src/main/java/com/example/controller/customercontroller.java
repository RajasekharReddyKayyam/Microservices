package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.customer;
import com.example.repo.CustomerRepo;

@RestController
public class customercontroller {
	@Autowired
	private CustomerRepo repo;
	@Autowired
	private PasswordEncoder pwdEncoder;
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> logincheck(@RequestBody customer c) {
	    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());
	    try {
	        Authentication authenticate = authManager.authenticate(token);
	        if (authenticate.isAuthenticated()) {
	            // Login success
	            return new ResponseEntity<String>("Welcome to my Page", HttpStatus.OK);
	        }
	    
	    } catch (Exception e) {
	        // General exception handling
	        e.printStackTrace();
	        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody customer c)
	{
		String encodedpwd= pwdEncoder.encode(c.getPwd());
		c.setPwd(encodedpwd);
		repo.save(c);
		return new ResponseEntity<String>("User Registered",HttpStatus.CREATED);
	}

	
}
