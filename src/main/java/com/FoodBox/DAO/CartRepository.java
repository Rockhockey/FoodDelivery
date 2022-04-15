package com.FoodBox.DAO;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.FoodBox.model.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {
	
	public List<Cart> findByCartIndex(Integer cartIndex);
		
	// i believe some other methods go here.. need to figure out

}
