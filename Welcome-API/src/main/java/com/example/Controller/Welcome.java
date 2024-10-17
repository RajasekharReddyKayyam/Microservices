package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
	@Autowired
	private Environment env ;
	@GetMapping("/welcome")
	public String welcomeAPI() {
		String port =env.getProperty("server.port");
		String mes="Hello , from Welcome API("+port+")";
		return mes;
	}

}