package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@GetMapping("/")
	public String welcomemesssage() {
		return "Hello from security";
		
	}
	@GetMapping("/deposit")
	public String deposit() {
		return "Deposit succesful";
	}
	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw succesful";
	}
	@GetMapping("/contact")
	public String contactus() {
		return "please reach out raja.kayyam12gmail.com";
	}
	@GetMapping("/about")
	public String about () {
		return "Its been 3 years ";
	}
}
