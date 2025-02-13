package com.springboot_restful_webservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class UserDto {

	
	private Long id;
	// Should not be null/empty
	@NotEmpty
	private String firstName;
	// Should not be null/empty
	@NotEmpty
	private String lastName;
	// Should not be null/empty and should be a valid email
	@NotEmpty@Email
	private String email;
	
	
}
