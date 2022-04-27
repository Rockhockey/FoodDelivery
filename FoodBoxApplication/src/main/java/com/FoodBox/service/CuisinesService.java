package com.FoodBox.service;

import com.FoodBox.model.Cuisines;
import java.util.List;

public interface CuisinesService {

	// for invoking DAO class methods for Cuisines

	List<Cuisines> getAllCuisines(); // get list of all cuisines
	Cuisines getCuisineById(Integer menuId); // get by menuID
	Cuisines saveCuisine(Cuisines cuisine); // save a cuisine
	void deleteCuisine(Integer menuId); //delete cuisine by menuID
	
	Cuisines updateCuisine(Cuisines cuisine, Integer menuId);
	List<Cuisines> CuisinePriceDesc(String cuisineType);
	List<Cuisines> GetAllCuisinesVisible();
	List<Cuisines> CuisinePriceAsc(String cuisineType);
	List<Cuisines> GetAllCuisinesVisibleDesc();
	List<Cuisines> GetAllCuisinesVisibleAsc();
	List<Cuisines> SearchCuisine(String search);
	List<Cuisines> SearchCuisineDesc(String search);
	List<Cuisines> SearchCuisineAsc(String search);
	
	

}
