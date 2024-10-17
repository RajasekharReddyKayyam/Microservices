package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="WELCOME-API")
public interface WelcomeAPI_FeignClients {
	@GetMapping("/welcome")
	public String invokewelcomeapi(); 
	
	

}
