package com.FoodBox.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodBox.model.Orders;
import com.FoodBox.model.Users;
import com.FoodBox.service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	OrdersService orderService;

	public OrdersController(OrdersService orderService) {
		super();
		this.orderService = orderService;
	}
	
	List<Orders> orders = new ArrayList<Orders>();
	
	// --------------------------------------- RESTful API for Retrieval ------------------------------------------ //
	
	@GetMapping("/allOrders")
	ResponseEntity<List<Orders>> getAllOrders() {
		return new ResponseEntity<List<Orders>>(orderService.getOrders(), HttpStatus.OK); // return all orders with status 200
	}
	
	@GetMapping("{orderNumber}")
	public ResponseEntity<Orders> getOrderByNum(@PathVariable("orderNumber") Integer orderNumber) {
		return new ResponseEntity<Orders>(orderService.getOrderById(orderNumber), HttpStatus.OK); // return status 200 for good order number
	}
	
	// ------------------------------------ RESTful API for Creation ----------------------------------------------- //
	
	@PostMapping("/newOrder")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) throws NoSuchAlgorithmException{
		return new ResponseEntity<Orders>(orderService.saveOrders(order), HttpStatus.CREATED); // created new order
	}
	
	// ---------------------------------------- RESTful API for delete --------------------------------------------- //
	
	@DeleteMapping("{orderNumber}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("orderNumber") Integer orderNumber){
		orderService.deleteOrders(orderNumber);
		return new ResponseEntity<Void>(HttpStatus.OK); //deleted order returned status ok
	}
	
	// don't think we need for updating order, since we update the cart instead
	
}
