package com.FoodBox.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FoodBox.DAO.CartRepository;
import com.FoodBox.DAO.OrdersRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Orders;


@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public List<Orders> getOrders() {
		
		List<Orders> orders = new ArrayList<Orders>();
		
		ordersRepository.findAll().forEach(orders::add);
		
		return orders;
	}

	@Override
	public Orders getOrderById(Integer orderNumber) {
		return ordersRepository.findById(orderNumber).orElseThrow(() -> new ResourceNotFoundException("Orders", "order_number", orderNumber));
	}

	@Override
	public void deleteOrders(Integer orderNumber) {
		ordersRepository.deleteById(orderNumber);
		
	}
	
	@Override
	public Orders saveOrders(Orders order) {
		return ordersRepository.save(order);
	}
	
	@Override
	public Orders updateOrders(Orders order, Integer orderNumber) {
		Orders existingOrder = ordersRepository.findById(orderNumber).orElseThrow(() -> new ResourceNotFoundException("Orders", "order_number", orderNumber));
		existingOrder.setOrderNumber(order.getOrderNumber());
		existingOrder.setUserId(order.getUserId());
		existingOrder.setOrderTime(order.getOrderTime());
		
		ordersRepository.save(existingOrder);
		return existingOrder;
		
	}

}
