package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.HelloWorldBean;

@RestController
public class HelloWorldController {

	
	@GetMapping(path = "/helloworld")
	public String  helloworld()
	{
		return "hello worlds";
	}
	
	@GetMapping(path = "/helloworld/useEntity")
	public HelloWorldBean  helloworldEntity()
	{
		return new HelloWorldBean("hello worlds");
	}
	
	@GetMapping(path = "/helloworld/useEntity/{name}")
	public HelloWorldBean  helloworldEntityy(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("hello worlds,%s",name));
	}
}
