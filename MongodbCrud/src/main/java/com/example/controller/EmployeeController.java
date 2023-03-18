package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
  
@RestController
public class EmployeeController {
      
    @Autowired 
    private EmployeeRepository userRepo;
      
    @PostMapping("/addUser")
    public Employee addUser(@RequestBody Employee employee)
    {
        return userRepo.save(employee);
    }
      
    @GetMapping("/getUser")
    public List<Employee> getAllUser()
    {
        return userRepo.findAll(); 
    }
    
    @GetMapping("/getUser/{id}") 
    public Optional<Employee> getOneUser(@PathVariable int id)
    {
    	Optional<Employee>myUser= userRepo.findById(id);
    	if(myUser.isEmpty())
    		throw new UserRuntimeException("invalid data = "+id);
        return myUser;
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
    	userRepo.deleteById(id);
        
        return "Deleted Successfully";
    }
    
}
