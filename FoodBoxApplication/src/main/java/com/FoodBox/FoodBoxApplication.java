package com.FoodBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.FoodBox.DAO.CuisineRepository;

@SpringBootApplication
public class FoodBoxApplication {

	@Autowired
	private CuisineRepository cuisineRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FoodBoxApplication.class, args);
	}

}
