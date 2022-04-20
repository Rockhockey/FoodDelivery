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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.FoodBox.model.Users;
import com.FoodBox.model.Login;

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
	
	@GetMapping("/login")
	public String login(Model model) {
		
		Login login = new Login();
		
		model.addAttribute("logins", login);
		
		return "login";	
	}
	
	@PostMapping(value = "/login_attempt")
	public String loginAttempt(@ModelAttribute("logins") Login login) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		Users user = userController.getUser(login.getUsername());
		
		if(passwordEncoder.matches(login.getPassword(), user.getHash())) {
			return "redirect:/admin";
		}

		
		return "redirect:/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}