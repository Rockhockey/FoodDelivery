package com.FoodBox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.FoodBox.model.Cuisines;
import com.FoodBox.model.OrderHistory;
import com.FoodBox.model.Orders;
import com.FoodBox.model.Users;
import com.FoodBox.service.CuisinesService;
import com.FoodBox.service.OrderHistoryService;
import com.FoodBox.service.OrdersService;
import com.FoodBox.service.UserService;

@Controller
public class OrdersWebController {

	@Autowired
	private CuisinesService cuisineService;
	
	@Autowired
	private OrdersService orderService;
	
	@Autowired
	private OrderHistoryService orderHistoryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/order_summary/{order}")
	public String showOrderSummary(@PathVariable(name="order") int orderNumber, Model model) {
		
		List<OrderHistory> orderHistory = orderHistoryService.getOrderHistoryByOrderNumber(orderNumber);
		
		List<Cuisines> cuisines = cuisineService.getAllCuisines();
		
		Orders order = orderService.getOrderById(orderNumber);
		
		model.addAttribute("orderHistory", orderHistory);
		model.addAttribute("cuisines", cuisines);
		model.addAttribute("order", order);
		
		return "order_summary";
	}
	
	@GetMapping("/order_history")
	public String showOrderHistory(Model model) {
		
		List<Orders> orders = orderService.getOrdersbyUserID(userService.getUserByUsername(UserWebController.username).getUserId());
		
		model.addAttribute("user", UserWebController.username);
		
		model.addAttribute("orders", orders);
		
		
		
		return "order_history";
	}
}
