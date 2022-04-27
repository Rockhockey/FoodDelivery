package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FoodBox.model.Cuisines;
import com.FoodBox.model.Orders;
import com.FoodBox.model.Users;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	public Orders findByUserID(Integer userID);
}
