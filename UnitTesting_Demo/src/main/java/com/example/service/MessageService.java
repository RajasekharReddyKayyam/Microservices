package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	public String getWElcomeMessage() {
		return "Hello welcome to my place ";
		
	}
	public String getGreetMessage() {
		return "Hello GoodMorning! ";
		
	}

}
