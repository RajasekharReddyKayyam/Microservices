package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.WelcomeAPI_FeignClients;

@RestController
public class Greet {
	@Autowired
	private WelcomeAPI_FeignClients welcome;
	@GetMapping("/greet")
	public String Greet() {
		String welcomeresponse=welcome.invokewelcomeapi();
		
		
		String Greetresponse="Greetings from Greet API ";
		return welcomeresponse+Greetresponse;
	}

}
