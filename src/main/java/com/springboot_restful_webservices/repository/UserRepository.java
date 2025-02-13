package com.springboot_restful_webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot_restful_webservices.entity.User;
public interface UserRepository extends JpaRepository<User, Long>{

}
