package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FoodBox.model.Cuisines;
import com.FoodBox.model.OrderHistory;
import com.FoodBox.model.Orders;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {

	@Query(value="SELECT * FROM order_history WHERE order_number=:order_number;", nativeQuery= true)
	List<OrderHistory> findByOrderNumber(
		@Param("order_number") Integer order_number);
}
