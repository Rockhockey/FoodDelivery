package com.FoodBox.service;

import java.util.List;

import javax.websocket.Session;

import com.FoodBox.model.Cart;
import com.FoodBox.model.Orders;

public interface OrdersService {

	List<Orders> getOrders();

	Orders getOrderById(Integer orderNumber);

	void deleteOrders(Integer orderNumber);

	Orders saveOrders(Orders order);

	Orders updateOrders(Orders order, Integer orderNumber);
}
