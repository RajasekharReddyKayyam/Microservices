package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DemoDAO {
	
	public String findbyName(Integer Uid) {
		return "Raj DAO";
	}

}
