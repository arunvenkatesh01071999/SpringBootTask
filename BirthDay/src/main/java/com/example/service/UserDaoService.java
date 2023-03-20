package com.example.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.model.MyUsers;

@Component
public class UserDaoService {
	
	
	private static List<MyUsers> users = new LinkedList<>();
	
	static {
		users.add(new MyUsers(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new MyUsers(2,"Eve",LocalDate.now().minusYears(25)));
		users.add(new MyUsers(3,"Jim",LocalDate.now().minusYears(20)));
	}
	
	public List<MyUsers> findAll() {
		return users;
	}
	
	//public User save(User user) {

	/*public MyUsers findOne(int id) {
		Predicate<? super MyUsers> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().get();
	}*/

}
