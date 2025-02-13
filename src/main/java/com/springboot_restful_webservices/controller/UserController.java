/**
 * 
 * 
 * 
 * 
 */
package com.springboot_restful_webservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_restful_webservices.dto.UserDto;
import com.springboot_restful_webservices.entity.User;
import com.springboot_restful_webservices.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@Tag(
		name ="CRUD Rest API for User Resource",
		description = "Create user, Update User, Get User By Id, Get All Users, Delete User by id"
		)

@RestController
@RequestMapping("user")
public class UserController {

	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService; 
	}
	// save the users
	// http://localhost:8080/user/create
	@PostMapping("create")
	@Operation(
			summary ="Create User REST API",
			description = "Create User REST API is used to save user in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto user){
		userService.createUser(user);
		return ResponseEntity.ok(user);
	}
	// Get all user Rest API
	// http://localhost:8080/user/findAll
	@Operation(
			summary ="Get All Users REST API",
			description = "get All Users REST API is used to save user in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	@GetMapping("findAll")
	ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = new ArrayList<>();
		users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	// get user by id
	// http://localhost:8080/user/find/{id}
	@Operation(
			summary ="Get Users by id REST API",
			description = "Get Users by id REST API is used to save user in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	@GetMapping("find/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
		UserDto user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	// update user REST API 
	// http://localhost:8080/user/update/1
	@Operation(
			summary ="Update User REST API",
			description = "Update User REST API is used to save user in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	@PutMapping("update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDto user){
		UserDto updatedUser = userService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
	}
	// delete user REST API
	// http://localhost:8080/user/delete/1
	@Operation(
			summary ="delete User REST API",
			description = "Delete User REST API is used to save user in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		userService.deleteUserById(id);
		return  ResponseEntity.ok("User deleted successfully");
	}
	
	
}
