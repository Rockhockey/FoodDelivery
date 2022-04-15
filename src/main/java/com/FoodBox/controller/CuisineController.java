package com.FoodBox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.model.Cuisines;
import com.FoodBox.service.CuisinesService;

@RestController
@RequestMapping("/menu")
public class CuisineController {
	@Autowired
	CuisinesService cuisineService;

	// methods specific to HTTP methods below
	@GetMapping("") // map with get requests
	List<Cuisines> getCuisines() {
		return cuisineService.getCuisines();
	}
	
	
	//RESTful API for Retrieval operations..... one of them is above for retrieval
	
	//RESTful API for Create operations
	
	//RESTful API for Update operation
	
	//RESTful API for Delete operation
}
