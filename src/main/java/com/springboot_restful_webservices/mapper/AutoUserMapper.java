package com.springboot_restful_webservices.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.springboot_restful_webservices.dto.UserDto;
import com.springboot_restful_webservices.entity.User;

@Mapper
public interface AutoUserMapper {

	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	UserDto mapToUser(User user);
	User mapToUser(UserDto userDto);
}
