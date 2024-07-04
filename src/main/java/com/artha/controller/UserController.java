package com.artha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artha.entity.Users;
import com.artha.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/get")
	private List<Users> getUsers(){
		return userService.findAll();
	}
	
	@PostMapping("/add")
	private Users addUser(@RequestBody Users users) {
		return userService.addUser(users);
	}

}

