package com.backend.backendApi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import com.backend.backendApi.exceptions.*;
import com.backend.backendApi.entities.User;
import com.backend.backendApi.payloads.UserDto;
import com.backend.backendApi.repositories.UserRepo;
import com.backend.backendApi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override 
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException (" User "," id ",userId));
		
user.setName(userDto.getName());
user.setEmail(userDto.getEmail());
user.setAbout(userDto.getAbout());
user.setPassword(userDto.getPassword());

User updateUser = this.userRepo.save(user);
UserDto userDto1 = this.userToDto(updateUser);
return userDto1;

	}

	@Override
	public UserDto getUserById(Integer userId) {	
User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException (" User "," id ",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
	List<User> users = this.userRepo.findAll();
	List<UserDto> userDtos =   users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
	return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException (" User "," id ",userId));
		this.userRepo.delete(user);
	}
	
	
	private User dtoToUser(UserDto userDto) {
		
		//modelmapper automatically convert which obj want to convert to which class obj
		User user = this.modelMapper.map(userDto, User.class);
		//mapping of one model into other model
		
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
		
	}
	
	private UserDto userToDto(User user) {

		UserDto userDto = this.modelMapper.map(user,UserDto.class);
		
		return userDto;
		
	}
	
	
	

}
