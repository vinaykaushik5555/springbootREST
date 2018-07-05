package com.restapi.springbootREST.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springbootREST.model.User;
import com.restapi.springbootREST.repository.UserRepository;

@RestController

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/students")
	public List<User> welcomeApi(){
		
		return userRepository.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUser(@PathVariable Long id){
	
	 Optional<User> user=userRepository.findById(id);
		
	 if(!user.isPresent())
		try {
			throw new Exception("User not exists id :"+ id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		return user.get();
	}
	

}