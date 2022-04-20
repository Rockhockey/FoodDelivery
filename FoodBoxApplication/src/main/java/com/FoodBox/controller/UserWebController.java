package com.FoodBox.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FoodBox.model.Users;
import com.FoodBox.Hash.MD5Salted;

@Controller
public class UserWebController {
	
	@Autowired
	UserController userController;
	
	@GetMapping("/new_user")
	public String addUser(Model model) {
		
		Users user = new Users();
		
		model.addAttribute("users", user);
		
		return "new_user";
	}
	
	@PostMapping(value = "/save_user")
	public String saveNewUser(@ModelAttribute("users") Users user) throws NoSuchAlgorithmException {
		
		userController.saveUser(user);
		
		return "redirect:/";
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}