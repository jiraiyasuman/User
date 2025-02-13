package com.springboot_restful_webservices.mapper;

import com.springboot_restful_webservices.dto.UserDto;
import com.springboot_restful_webservices.entity.User;

public class UserMapper {

	// convert User JPA Entity into UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto dto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
				return dto;
	}
	// convert UserDto into User JPA entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);
		return user;
	}
}
