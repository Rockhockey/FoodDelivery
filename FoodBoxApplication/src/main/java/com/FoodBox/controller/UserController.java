package com.FoodBox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.model.Users;
import com.FoodBox.service.UserService;
//add to gh
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	List<Users> users = new ArrayList<Users>();
	
	//--------------------------- RESTful API for Retrieval operations ---------------------------------- //
	@GetMapping("allUsers")
	List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<Users>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("{UserName}")
	public ResponseEntity<Users> getUserByUsername(@PathVariable("UserName") String userName){
		return new ResponseEntity<Users>(userService.getUserByUsername(userName), HttpStatus.OK);
	}
	
	// ------------------------------------------- create
	@PostMapping("/createUser")
	public ResponseEntity<Users> saveUserEntity(Users user){
		return new ResponseEntity<Users>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	// ---------------------------------------- delete
	
	@DeleteMapping("{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId")Integer userId){
		userService.deleteUser(userId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// ------------------------------------------ update
	@PutMapping("{userId}")
	public ResponseEntity<Users> updateUser(@PathVariable("userId")Integer userId,
											@RequestBody Users user) {
		return new ResponseEntity<Users>(userService.updateUser(user, userId), HttpStatus.OK);
	}
	
	
	
}