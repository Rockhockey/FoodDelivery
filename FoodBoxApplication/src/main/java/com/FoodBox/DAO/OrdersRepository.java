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
	@Query(value="Select O.OrderNumber, O.OrderTime, O.Cost, OH.Item, OH.Quantity FROM Orders AS O INNER JOIN OrderHistory AS OH ON O.OrderNumber=OH.OrderNumber WHERE UserID = ?1;", nativeQuery= true)
	List<Orsers> ReadOrderHistory(Integer ID);

}
