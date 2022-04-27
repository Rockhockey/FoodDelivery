package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FoodBox.model.Cuisines;
import com.FoodBox.model.Orders;
import com.FoodBox.model.Users;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Query(value="SELECT * FROM orders WHERE user_id=:userID;", nativeQuery= true)
	List<Orders> findByUserId(
		@Param("userID") Integer userID);
}
