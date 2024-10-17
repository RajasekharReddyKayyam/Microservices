package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
	@GetMapping("/hello")
	public String my() {
		return" iam from Rest Controlller my";
		
	}
	@GetMapping("/Welcome")
	public String greet() {
		return" iam from Rest Controlller welcome";
		
	}

}
