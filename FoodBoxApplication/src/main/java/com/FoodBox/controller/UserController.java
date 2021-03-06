package com.FoodBox.controller;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.FoodBox.model.Users;
import com.FoodBox.service.UserService;

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
	ResponseEntity<List<Users>> getAllUsers() {
		return new ResponseEntity<List<Users>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<Users>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("{username}")
	public ResponseEntity<Users> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<Users>(userService.getUserByUsername(username), HttpStatus.OK);
	}
	
	//------------------------------ RESTful API for CREATE user ---------------------------------------- //
	
	//build create API for USER
	@PostMapping("/createUser")
	public ResponseEntity<Users> saveUser(@RequestBody Users user) throws NoSuchAlgorithmException{
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setHash(passwordEncoder.encode(user.getPassword()));
		
		user.setIsAdmin(false);
		
		return new ResponseEntity<Users>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	public Users getUser(String username) {
		return userService.getUserByUsername(username);
	}
	
	
}