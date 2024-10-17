package com.example.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Entity.customer;
import com.example.repo.CustomerRepo;

@Service
public class customerService implements UserDetailsService {
    @Autowired
    private CustomerRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        customer cust = repo.findByemail(email);
        if (cust == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(cust.getEmail(), cust.getPwd(), Collections.emptyList());
    }
}
