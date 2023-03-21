package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.MyUsers;
import com.example.service.UserDaoService;

import jakarta.validation.Valid;

@RestController
public class MyController {

	private UserDaoService service;

	public MyController(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/getUsers")
	List<MyUsers> findAllUser() {
		return service.findAll();
	}
	
	@GetMapping("/getUsers/{id}")
	public MyUsers retrieveUser(@PathVariable int id)
	{
		MyUsers myusers= service.findOne(id);
		
		if(myusers==null)
		{
			throw new UserNotFoundException("id: "+id);
		}
		
		return myusers;
	}
	
	@DeleteMapping("/getUsers/{id}")
	public void deleteUser(@PathVariable int id)
	{
		service.deletebyUser(id);
	}
	
	
	@PostMapping("/createUsers")
	public ResponseEntity<MyUsers> createUsers(@Valid @RequestBody MyUsers myusers)
	{
		
		MyUsers savedUser = service.save(myusers);
		 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	
}
