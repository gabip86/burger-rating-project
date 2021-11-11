package com.burger.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.springbootbackend.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	// get all 
}
