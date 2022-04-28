package com.FoodBox.service;

import java.util.List;

import javax.websocket.Session;

import com.FoodBox.model.Cart;
import com.FoodBox.model.OrderHistory;
import com.FoodBox.model.Orders;

public interface OrderHistoryService {

	List<OrderHistory> getAllOrderHistory();

	OrderHistory getOrderHistoryById(Integer OHkey);
	
	List<OrderHistory> getOrderHistoryByOrderNumber(Integer OrderNumber);

	void deleteOrderHistory(Integer OHkey);

	OrderHistory saveOrderHistory(OrderHistory orderHistory);
	
	OrderHistory updateOrderHistory (OrderHistory orderHistory, Integer OHkey);
}
