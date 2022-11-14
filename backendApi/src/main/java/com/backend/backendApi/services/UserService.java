package com.backend.backendApi.services;

import java.util.List;

import com.backend.backendApi.entities.User;
import com.backend.backendApi.payloads.UserDto;


public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUsers();
	void deleteUser(Integer userId);
	
}
