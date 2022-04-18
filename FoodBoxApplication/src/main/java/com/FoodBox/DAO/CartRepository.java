package com.FoodBox.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FoodBox.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {	
	// i believe some other methods go here.. need to figure out

}
