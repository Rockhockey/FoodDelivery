package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;

public interface CartRepository extends JpaRepository<Cart, Integer> {	
	
	// i believe some other methods go here.. need to figure out
	//View current Cart
	@Query(value="SELECT Menu.Name, Menu.Price*Menu.Offer as CurrentPrice, Cart.Quantity FROM Cart INNER JOIN Menu ON Cart.Item=Menu.MenuID;", nativeQuery= true)
	List<Cuisines> ReadCart();

	//View Total Cost of current Cart
	@Query(value="SELECT SUM(Menu.Price*Menu.Offer*Cart.Quantity) FROM Cart INNER JOIN Menu ON Cart.Item=Menu.MenuID;", nativeQuery= true)
	List<Cuisines> CartCost();
}
