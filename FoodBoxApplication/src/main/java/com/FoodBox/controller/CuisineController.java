package com.FoodBox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.model.Cuisines;
import com.FoodBox.service.CuisinesService;

@Controller
@RequestMapping("/foods")
public class CuisineController {
	
	@Autowired
	private CuisinesService cuisineService;
	
	

	//constructor is for constructor injection
	public CuisineController(CuisinesService cuisineService) {
		super();
		this.cuisineService = cuisineService;
	}



	//METHODS FOR HTTP BELOW
	
	
	//--------------------------- RESTful API for Retrieval operations ---------------------------------- //
	
	//build GET all CUISINES REST API
	@GetMapping("/allMenus") 
	List<Cuisines> getAllCuisines() {
		return cuisineService.getAllCuisines();
	}
	
	
	//build GET CUISINES by id(menuId) REST API
	// ------ example ------- //
	//http://localhost:8080/menus/1 -- any id can replace 1
	@GetMapping("{menuId}")
	public ResponseEntity<Cuisines> getCuisineById(@PathVariable("menuId") Integer menuId) {
		return new ResponseEntity<Cuisines>(cuisineService.getCuisineById(menuId), HttpStatus.OK);
	}
	
	
	
	
	//------------------------------- RESTful API for Create operations ---------------------------------- //
	
	//create CUISINES REST API
		@PostMapping("/createMenu")
		public ResponseEntity<Cuisines> saveCuisines(@RequestBody Cuisines cuisine){
			return new ResponseEntity<Cuisines>(cuisineService.saveCuisine(cuisine), HttpStatus.CREATED);
			
		}
		
	
	//---------------------------------- RESTful API for Update operation --------------------------------- //
		
		//build UPDATE CUISINE REST API
		//example below
		//http://localhost:8080/menus/1 --- updating whatever 1 was before to current
		@PutMapping("{menuId}")
		public ResponseEntity<Cuisines> updateCuisine(@PathVariable("menuId") Integer menuId,
														@RequestBody Cuisines cuisine) {
			return new ResponseEntity<Cuisines>(cuisineService.updateCuisine(cuisine, menuId), HttpStatus.OK);
			
		}
	
	//---------------------------------- RESTful API for Delete operation --------------------------------- //
}
