package com.FoodBox.service;

//libraries used
import com.FoodBox.DAO.CuisineRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Cuisines;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // makes auto discoverable, spring configures bean by itself
public class CuisinesServiceImpl implements CuisinesService {

	@Autowired
	private CuisineRepository cuisineRepository; // getting our database info here (injection)
	
	
	public CuisinesServiceImpl(CuisineRepository cuisineRepository) {
		super();
		this.cuisineRepository = cuisineRepository;
	}

	List<Cuisines> cuisines = new ArrayList<Cuisines>(); // new list of cuisines created at the class level
															// instead of method level here

	//get all cuisines
	@Override
	public List<Cuisines> getAllCuisines() {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>(); //didn't need this code. 
		cuisineRepository.findAll().forEach(cuisines::add); //didn't need this code. 
		
		return cuisines; //returned from global level
	}

	
	//get 1 cuisine by id
	@Override
	public Cuisines getCuisineById(Integer id) {
		return cuisineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuisine", "menuId", id)); 
	}
	

	//delete a cuisine by id
	@Override
	public void deleteCuisine(Integer id) {
		cuisineRepository.deleteById(id); // delete by id comes from jpa repository.delete by menuid

	}
	

	//save cuisine as an object
	@Override
	public Cuisines saveCuisine(Cuisines cuisine) {
		return cuisineRepository.save(cuisine);
	}


	
	//update cuisine 
	@Override
	public Cuisines updateCuisine(Cuisines cuisine, Integer menuId) {
		//check if a cuisine with the given id is even in the database first
		Cuisines existingCuisine = cuisineRepository.findById(menuId).orElseThrow(() -> new ResourceNotFoundException("Cuisine", "menuId", menuId));
		
		//update is done here for every attribute
		existingCuisine.setId(cuisine.getId());
		existingCuisine.setName(cuisine.getName());
		existingCuisine.setPrice(cuisine.getPrice());
		existingCuisine.setCuisineType(cuisine.getCuisineType());
		existingCuisine.setDescription(cuisine.getDescription());
		existingCuisine.setOffer(cuisine.getOffer());
		existingCuisine.setVisible(cuisine.isVisible());
		
		//now we save the existing employee to DB
		cuisineRepository.save(existingCuisine);
		return existingCuisine;
		
	}
	
	@Override
	public List<Cuisines> GetAllCuisinesVisible() {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuOrderCuisine();
		
		return cuisines;
		
	}
	
	@Override
	public List<Cuisines> GetAllCuisinesVisibleDesc() {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuOrderPriceDesc();
		
		return cuisines;
		
	}
	
	@Override
	public List<Cuisines> GetAllCuisinesVisibleAsc() {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuOrderPriceAsc();
		
		return cuisines;
		
	}
	
	
	@Override
	public List<Cuisines> CuisinePriceDesc(String cuisineType) {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuCuisinePriceDesc(cuisineType);
		
		return cuisines;
		
	}
	
	@Override
	public List<Cuisines> CuisinePriceAsc(String cuisineType) {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuCuisinePriceAsc(cuisineType);
		
		return cuisines;
		
	}
	
	@Override
	public List<Cuisines> SearchCuisine(String search) {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuKeywordCuisine(search, search, search);
		
		return cuisines;
		
	}
	
	@Override
	public List<Cuisines> SearchCuisineAsc(String search) {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuKeywordPriceAsc(search, search, search);
		
		return cuisines;
		
	}
	
	@Override
	public List<Cuisines> SearchCuisineDesc(String search) {
		
		List<Cuisines> cuisines = new ArrayList<Cuisines>();
		
		cuisines = cuisineRepository.ReadMenuKeywordPriceDesc(search, search, search);
		
		return cuisines;
		
	}


}
