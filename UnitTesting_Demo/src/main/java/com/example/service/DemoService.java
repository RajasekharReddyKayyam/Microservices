package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DemoDAO;

@Service
public class DemoService {
	@Autowired
	private DemoDAO dao;
  public String GetUserName(Integer Uid) {
	String  name= dao.findbyName(Uid);
	System.out.println(name);
	return name;
	  
  }
}
