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
import com.FoodBox.controller.UserWebController;
import com.FoodBox.controller.UserController;

@Controller
public class WebController {
	
	@Autowired
	UserController userController;
	
	@RequestMapping("/")
	public String homePage(Model model) {
		if(UserWebController.username!=null) {
			Users user = userController.getUser(UserWebController.username);
			if(user.getIsAdmin())
				return "admin_log_index";
			return "log_index";
		}
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