package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Entity.customer;

public interface CustomerRepo  extends MongoRepository<customer, String>{
	public customer findByemail(String email);

}
