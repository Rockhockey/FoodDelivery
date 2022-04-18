package com.FoodBox.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FoodBox.model.Cuisines;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisines, Integer>{

	
	/*for CRUD
	CREATE --- POST
	READ --- GET
	UPDATE --- PUT
	DELETE --- DELETE
	
	implements methods from CRUD repository as well
	built in methods like findAll(), count(), delete()
	
	-- OUR CUSTOM finder methods go here (filter)
	*/
	
	
	
	
	
}
