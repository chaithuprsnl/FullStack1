package com.home.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("Spring Boot Hello World", HttpStatus.OK);
	}
}
