package com.springboot_restful_webservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_restful_webservices.dto.UserDto;
import com.springboot_restful_webservices.entity.User;


public interface UserService {

	UserDto createUser(UserDto user);   // creates user
	
	List<UserDto> getAllUser();   // displays all users
	
	UserDto getUserById(Long id);   // gets user by id
	
	UserDto updateUser(UserDto user);  // updates user
	
	void deleteUserById(Long id); // delete user
}
