package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MessageService;

@RestController
public class MessageController {
	@Autowired
	private MessageService msgservice;
	@GetMapping("/welcome")
	public String Welcome() {
	String wel=	msgservice.getWElcomeMessage();
	return wel.toUpperCase();
	}
	@GetMapping("/greet")
	public String Greet() {
	String gre=	msgservice.getGreetMessage();
	return gre.toUpperCase();
	}

}
