package com.FoodBox.service;

import com.FoodBox.model.Cuisines;
import java.util.List;

public interface CuisinesService {

	// for invoking DAO class methods for Cuisines

	List<Cuisines> getCuisines(); // list of all cuisines

	Cuisines getCuisine(Integer id); // get by menuID

	void saveCuisine(Cuisines cuisine); // save a cuisine
	
	void deleteCuisine(Integer id); //delete cuisine by menuID
	
	

}
