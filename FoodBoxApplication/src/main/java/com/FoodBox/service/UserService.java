package com.FoodBox.service;

import java.util.List;
import java.util.Optional;

import com.FoodBox.model.Users;

public interface UserService {
	
	List<Users> getAllUsers(); //get a list of all users
	Users getUserById(Integer userId); // get user by id
	Users getUserByUsername(String username);
	Users saveUser(Users user); //save a user
	void deleteUser(Integer userId);//delete user by userId
	Users updateUser( Users user ,Integer userId); //update user
	void setPassword(Integer userId, String password);
	

}
