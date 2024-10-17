package com.example.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Entity.Customer;
import com.example.repo.CustomerRepo;

public class CustomerDetailsService  implements UserDetailsService{
	@Autowired
	private CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer=repo.findByUname(username);
		return new User(customer.getUname(),customer.getPwd(),Collections.EMPTY_LIST);
	}

}
