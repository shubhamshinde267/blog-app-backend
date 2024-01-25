package com.codewithdurgesh.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.entities.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> 
{
	Optional<User>findByEmail(String email);

}
