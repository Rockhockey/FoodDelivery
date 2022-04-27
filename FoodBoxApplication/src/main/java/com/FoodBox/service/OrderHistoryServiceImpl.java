package com.FoodBox.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FoodBox.DAO.CartRepository;
import com.FoodBox.DAO.OrderHistoryRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;
import com.FoodBox.model.Orders;
import com.FoodBox.model.OrderHistory;


@Service
@Transactional
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	private OrderHistoryRepository orderHistoryRepository;
	
	
	
	//@Override
	public List<OrderHistory> getAllOrderHistory() {
		List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
		orderHistoryRepository.findAll().forEach(orderHistory::add);
		return orderHistory;
	}
	
	@Override
	public OrderHistory getOrderHistoryById(Integer OHkey) {
		return orderHistoryRepository.findById(OHkey).orElseThrow(() -> new ResourceNotFoundException("OrderHistory", "Order History Key", OHkey));
	}
	
	@Override
	public List<OrderHistory> getOrderHistorybyOrderNumber(Integer OrderNumber) {
		List<OrderHistory> OrderHistory = new ArrayList<OrderHistory>();
		OrderHistory = orderHistoryRepository.findByOrderNumber(OrderNumber);
		return OrderHistory;
	}
	
	@Override
	public void deleteOrderHistory(Integer OHkey) {
		orderHistoryRepository.deleteById(OHkey);
	}
	
	@Override
	public OrderHistory saveOrderHistory(OrderHistory orderHistory) {
		return orderHistoryRepository.save(orderHistory);
	}
	
	@Override
	public OrderHistory updateOrderHistory (OrderHistory orderHistory, Integer OHkey) {
		OrderHistory existingOH = orderHistoryRepository.findById(OHkey).orElseThrow(() -> new ResourceNotFoundException("OrderHistory", "Order History Key", OHkey));
		existingOH.setOrderHistoryId(orderHistory.getOrderHistoryId());
		existingOH.setOrderNumber(orderHistory.getOrderNumber());
		existingOH.setItem(orderHistory.getItem());
		existingOH.setQuantity(orderHistory.getQuantity());
		existingOH.setCost(orderHistory.getCost());
		
		orderHistoryRepository.save(existingOH);
		return existingOH;
	}
}
