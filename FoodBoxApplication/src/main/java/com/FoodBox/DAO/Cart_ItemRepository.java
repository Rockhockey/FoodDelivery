package com.FoodBox.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FoodBox.model.Cart;

public interface Cart_ItemRepository extends JpaRepository<Cart, Integer>{
	

}
