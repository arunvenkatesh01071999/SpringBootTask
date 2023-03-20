package com.example.model;

import java.time.LocalDate;

public class MyUsers {
			
	private int id;
	private String name;
	private LocalDate birthday;
	
	public MyUsers(int id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MyUsers [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
