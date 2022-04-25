package com.FoodBox.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.DAO.CartRepository;
import com.FoodBox.DAO.CuisineRepository;
import com.FoodBox.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {

	CartRepository cartRepo;
	CuisineRepository cuisineRepo;
	
	@Autowired
	private CartService cartService;
	
		//RESTful API for Retrieval operations
	
		//RESTful API for Create operations
		
		//RESTful API for Update operation
		
		//RESTful API for Delete operation
	
	
}
