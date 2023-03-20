package com.example.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.MyUsers;
import com.example.service.UserDaoService;

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
}
