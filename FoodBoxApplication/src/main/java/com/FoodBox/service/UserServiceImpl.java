package com.FoodBox.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FoodBox.DAO.UserRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Users;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	/*public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}*/

	//get all users
	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll(); //find all method has returning a list built in
	}

	//get a user by their id
	@Override
	public Users getUserById(Integer userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Users", "userId", userId));
	}

	//save a user (as an object)
	@Override
	public Users saveUser(Users user) {
		return userRepository.save(user);
	}

	//delete User by their userId
	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);

	}
	
	//update user by their id

	@Override
	public Users updateUser(Users user, Integer userId) {
		Users existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Users", "userId", userId));
		
		existingUser.setUserId(user.getUserId());
		existingUser.setUserName(user.getUserName());
		existingUser.setEmail(user.getEmail());
		//existingUser.setPassword(user.getPassword());
		existingUser.setAddress(user.getAddress());
		
		userRepository.save(existingUser);
		return existingUser;
	}
	
	//setting password for user in initial sign up and for log in
	@Override
	public void setPassword(Integer userId, String password) {
		Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Users", "password", password));
		//user.setPassword(user.getPassword());
		userRepository.save(user);
	}
	
	@Override
	public Users getUserByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}

}
