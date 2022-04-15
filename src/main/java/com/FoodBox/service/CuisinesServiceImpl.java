package com.FoodBox.service;

import com.FoodBox.DAO.CuisineRepository;
import com.FoodBox.model.Cuisines;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service // makes auto discoverable, spring configures bean by itself
@Transactional
public class CuisinesServiceImpl implements CuisinesService {

	private CuisineRepository cuisineRepository; // getting our database info here

	List<Cuisines> cuisines = new ArrayList<Cuisines>(); // new list of cuisines created at the class level
															// instead of method level here

	@Override
	public List<Cuisines> getCuisines() {
		// create list of cuisines(from class level above), and then return that list
		cuisines.add(new Cuisines());

		return cuisines;
	}

	@Override
	public Cuisines getCuisine(Integer id) {

		Iterator<Cuisines> iterator = cuisines.iterator(); // iterator is our menuID ( a number 1, a number 2, ...etc)
		while (iterator.hasNext()) {
			Cuisines cuisine = iterator.next();
			if (cuisine.getId().equals(id)) {
				return cuisine;
			}

		}
		return null;
	}

	@Override
	public void saveCuisine(Cuisines cuisine) {
		cuisineRepository.save(cuisine); // save method comes from jpa repository

	}

	@Override
	public void deleteCuisine(Integer id) {
		cuisineRepository.deleteById(id); // delete by id comes from jpa repository.delete by menuid

	}

}
