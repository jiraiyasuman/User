package com.springboot_restful_webservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@OpenAPIDefinition(
		info = @Info(title ="SpringBoot REST API Documentation",
		description =" SpringBoot Rest API Documentation ",
		version="v1.0",
		contact=@Contact(
		name="Suman Talukdar",
		email="suman.talukdar53@gmail.com",
		url=""),
		license=@License(
				name="Apache 2.0",
				url="https://<website-name>"
				
				)
		
		
		
		),
		externalDocs = @ExternalDocumentation(
				description="Spring Boot User Management Documentation",
				url="https://<>"
				)
		)

@SpringBootApplication
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

	
}
