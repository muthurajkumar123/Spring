package com.Project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.entity.User;
import com.Project.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		//TODO: process POST request
		User u = userRepo.save(user);
		return u;
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser() {
		
		List<User> user = userRepo.findAll();
		return user;
	}
	
	@GetMapping("/getUser/{name}")
	
	public User getUserByName(@PathVariable String name)
	{
		
		return userRepo.getUserByName(name);
		
	}
	
	@GetMapping("/getUser/{id}")
	
	public User getUserById(@PathVariable int id)
	{
		
		return userRepo.findById(id).get();
		
	}
	
	
	@PostMapping("/update/{id}")
	
	public String updateUser(@RequestBody User user , @PathVariable int id)
	{
		
		User u = userRepo.findById(id).get();
		u.setEmail(user.getEmail());
		u.setAge(user.getAge());
		userRepo.save(u);
		return "update Successfully";
		
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id)
	{
		userRepo.deleteById(id);
		return "Delete Successfullyy";
	}
	

}