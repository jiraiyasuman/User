package com.springboot_restful_webservices.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_restful_webservices.dto.UserDto;
import com.springboot_restful_webservices.entity.User;
import com.springboot_restful_webservices.mapper.AutoUserMapper;
import com.springboot_restful_webservices.repository.UserRepository;
import com.springboot_restful_webservices.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	private ModelMapper modelMapper;
	
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
		super();
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		// convert UserDto into User JPA entity
		//User savedUser = modelMapper.map(user, User.class);
		User savedUser = AutoUserMapper.MAPPER.mapToUser(user);
		userRepository.save(savedUser);
		// convert JPA entity into UserDto
		//UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUser(savedUser);
		return savedUserDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		
		//List<UserDto> users = new ArrayList();
		List<User> users = userRepository.findAll();
		//return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		//return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUser(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Long id) {
          User user = userRepository.findById(id).get();
		if(user==null) {
			throw new RuntimeException("User id is not found"+id);
		}
		//return modelMapper.map(user1, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUser(user);
	}

	@Transactional
	@Override
	public UserDto updateUser(UserDto user) {
		User getUser = userRepository.findById(user.getId()).get();
		if(getUser==null) {
			throw new RuntimeException("User id is not found"+getUser.getId());
		}
		getUser.setFirstName(user.getFirstName());
		getUser.setLastName(user.getLastName());
		getUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(getUser);
		//UserDto userDto = modelMapper.map(updatedUser, UserDto.class);
		UserDto userDto = AutoUserMapper.MAPPER.mapToUser(updatedUser);
		return userDto; 
	}

	@Transactional
	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	
	
	
}
