package com.example.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.model.MyUsers;

@Component
public class UserDaoService {
	
	
	private static List<MyUsers> myList = new LinkedList<>();
	private static int count=0;
	static {
		myList.add(new MyUsers(++count,"Adam",LocalDate.now().minusYears(30)));
		myList.add(new MyUsers(++count,"Eve",LocalDate.now().minusYears(25)));
		myList.add(new MyUsers(++count,"Jim",LocalDate.now().minusYears(20)));
	}
	
	public List<MyUsers> findAll() {
		return myList;
	}
	
	
	public MyUsers findOne(int id)
	{
		Predicate<? super MyUsers> predicate = user -> user.getId().equals(id); 
		return myList.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deletebyUser(int id)
	{
		Predicate<? super MyUsers> predicate = user -> user.getId().equals(id); 
		myList.removeIf(predicate);
	}
	
	
	

	public MyUsers save(MyUsers myusers)
	{
		myusers.setId(++count);
		
		myList.add(myusers);
		
		return myusers;
	}
}
