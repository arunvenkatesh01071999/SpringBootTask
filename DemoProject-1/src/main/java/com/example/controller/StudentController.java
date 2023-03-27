package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentModel;

@RestController
@RequestMapping("students")
public class StudentController {

	@GetMapping("student")
	public ResponseEntity<StudentModel> createData()
	{
		StudentModel studentModelObject = new StudentModel(2, "arun","pandian");

		return ResponseEntity.ok().header("custom_header","ramesh")
				.body(studentModelObject);
				
	}
	
	@GetMapping
	public List<StudentModel> createAllData()
	{
		List<StudentModel> myList = new  ArrayList<>();
		myList.add(new StudentModel(2,"arun","kumar"));
		myList.add(new StudentModel(3,"arunkumar","v"));
		return myList;
	}
	@GetMapping("{id}")
	public StudentModel getUser(@PathVariable("id")int studentId)
	{
	
		return new StudentModel(studentId,"arun","kumar");
	}
	//http://localhost:8080/getUsers/query?id=2
	@GetMapping("query")
	public StudentModel getUsers(@RequestParam int id)
	{
		return new StudentModel(id,"arun","vijay");
	}
	
	@PostMapping("create")
	@ResponseStatus(HttpStatus.CREATED)
	public StudentModel postUsers(@RequestBody StudentModel studentModel)
	{
		System.out.println(studentModel.getId());
		System.out.println(studentModel.getFirstname());
		System.out.println(studentModel.getLastname());
		return studentModel;
	}
	
	    @PutMapping("{id}/update")
	    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel studentModel, @PathVariable("id") int studentId)
	 	{
	        System.out.println(studentModel.getFirstname());
	        System.out.println(studentModel.getLastname());
	        return ResponseEntity.ok(studentModel);
	    }

	    @DeleteMapping("{id}/delete")
	    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
	        System.out.println(studentId);
	        return ResponseEntity.ok("Student deleted successfully!");
	    }
	
} 
