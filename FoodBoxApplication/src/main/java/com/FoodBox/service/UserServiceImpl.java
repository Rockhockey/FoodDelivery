package com.FoodBox.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FoodBox.DAO.UserRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Users;

@Service
public class UserServiceImpl implements UserService {
	
	UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	//get all users
	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll(); //find all method has returning a list built in
		return null;
	}

	//get a user by their id
	@Override
	public Users getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	//save a user (as an object)
	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	//delete User by their userId
	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	
	//update user by their id

	@Override
	public Users updateUser(Users user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//setting password for user in initial sign up and for log in
	@Override
	public void setPassword(Integer userId, String password) {
		Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "password", password));
		user.setPassword(user.getPassword());
		userRepository.save(user);
		
	}

}
