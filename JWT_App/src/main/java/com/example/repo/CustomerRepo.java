package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Entity.Customer;

public interface CustomerRepo extends MongoRepository<Customer,String> {
  public Customer findByUname (String Uname);
}
