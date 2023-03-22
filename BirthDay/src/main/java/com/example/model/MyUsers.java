package com.example.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class MyUsers {
		  
	
	private Integer id;
	
	@Size(min=2,message="Name should have 2 character")
	@JsonProperty("user_name") 
	private String name;
	@Past(message="Birthdate sholud be past date only")
	@JsonProperty("user_birthdate") 
	private LocalDate birthday;
	
	public MyUsers(Integer id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MyUsers [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
}
