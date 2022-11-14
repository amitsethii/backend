package com.backend.backendApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backendApi.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	
	//POST - create user
	//PUT - update user
	//DELETE - delete user
	//GET - user get
	
	
	
	
}
