package com.FoodBox.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.FoodBox.model.Cuisines;

@Controller
public class CuisineWebController {
	
	@Autowired
	CuisineController cuisineController;
	
	@GetMapping("/admin")
	public String getAllCuisines(Model model) {
		
		List<Cuisines> cuisinesList = cuisineController.getAllCuisines();
		
		model.addAttribute("cuisines", cuisinesList);
		
		return "list_cuisines";
	}
	
	@GetMapping("/new_item")
	public String addItem(Model model) {
		
		Cuisines cuisine = new Cuisines();
		
		model.addAttribute("cuisineForm", cuisine);
		
		return "new_item";
		
	}
	
	@PostMapping(value = "/save_new")
	public String saveNewItem(@ModelAttribute("cuisineForm") Cuisines cuisine) {
		
		cuisineController.saveCuisines(cuisine);
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/update_item/{cId}")
	public String editMenu(@PathVariable(name = "cId") int Id, Model model) {
		
		model.addAttribute("cuisines", cuisineController.getCuisineById(Id));
		
		return "update_item";
		
	}
	
	@PostMapping(value = "/save_update")
	public String saveUpdateItem(@ModelAttribute("cuisines") Cuisines cuisine) {
		
		cuisineController.updateCuisine(cuisine.getId(), cuisine);
		
		return "redirect:/admin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}