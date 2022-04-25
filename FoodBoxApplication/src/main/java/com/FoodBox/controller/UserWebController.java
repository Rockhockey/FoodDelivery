package com.FoodBox.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.FoodBox.model.Users;
import com.FoodBox.service.UserService;
import com.FoodBox.model.Login;
import com.FoodBox.FoodBoxApplication;

@Controller
public class UserWebController {
	
	@Autowired
	UserService userService;
	
	public static String username;
	
	@GetMapping("/new_user")
	public String addUser(Model model) {
		
		Users user = new Users();
		
		model.addAttribute("users", user);
		
		return "new_user";
	}
	
	@PostMapping(value = "/save_user")
	public String saveNewUser(@Valid @ModelAttribute("users") Users user, BindingResult bindingResult) throws NoSuchAlgorithmException {
		
		if(bindingResult.hasErrors()) {
			return "new_user";
		}
	
		userService.saveUser(user);
		
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
		
		Users user = userService.getUserByUsername(login.getUsername());
		if(user!=null) {
			if(passwordEncoder.matches(login.getPassword(), user.getHash())) {
				username = login.getUsername();
				return "redirect:/";
			}
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String aboutPage(Model model) {
		username = null;
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}