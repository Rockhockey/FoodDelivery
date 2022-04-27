package com.FoodBox.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FoodBox.model.Cuisines;
import com.FoodBox.model.Users;
import com.FoodBox.service.UserService;
import com.FoodBox.controller.UserWebController;
import com.FoodBox.controller.UserController;

@Controller
public class WebController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String homePage(Model model) {
		
		Boolean admin = null;
		
		if(UserWebController.username!=null) {
			Users user = userService.getUserByUsername(UserWebController.username);
			admin = user.getIsAdmin();
		}
		model.addAttribute("admin", admin);
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String aboutPage(Model model) {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contactPage(Model model) {
		return "contact";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}