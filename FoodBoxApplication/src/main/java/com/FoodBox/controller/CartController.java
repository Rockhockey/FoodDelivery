package com.FoodBox.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.DAO.CartRepository;
import com.FoodBox.DAO.CuisineRepository;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;
import com.FoodBox.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CuisineRepository cuisineRepo;
	
	@Autowired
	private CartService cartService;

	public CartController(CartRepository cartRepo, CuisineRepository cuisineRepo, CartService cartService) {
		super();
		this.cartRepo = cartRepo;
		this.cuisineRepo = cuisineRepo;
		this.cartService = cartService;
	}
	
	
	
		//RESTful API for Retrieval operations
	
		//RESTful API for Create operations
	
	@PostMapping("/new_cart")
	public ResponseEntity<Cart> saveCart(@RequestBody Cart cart){
		return new ResponseEntity<Cart>(cartService.saveCart(cart), HttpStatus.CREATED);
	}
	
		//RESTful API for Update operation
		
		//RESTful API for Delete operation
	
	
}
