package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FoodBox.model.Cuisines;
import com.FoodBox.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	// pull orders by userId
	
	
	//pull orders by Cuisine name
	
	
	//pull ord
	//View Order History based on User ID
	@Query(value="Select O.order_number, O.order_time, OH.item, OH.quantity, OH.cost FROM orders AS O INNER JOIN Order_History AS OH ON O.order_number=OH.order_number WHERE user_id = ?1;", nativeQuery= true)
	List<Orders> ReadOrderHistory(Integer ID);

}
