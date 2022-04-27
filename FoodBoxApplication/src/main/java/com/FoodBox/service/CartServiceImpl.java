package com.FoodBox.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodBox.DAO.CartRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;
import com.FoodBox.model.OrderHistory;
import com.FoodBox.model.Orders;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired    
	CuisinesService cuisineService;
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	OrderHistoryService orderhistoryService;
	
	@Override
	public List<Cart> getCarts() {
		
		List<Cart> carts = new ArrayList<Cart>();
		
		cartRepository.findAll().forEach(carts::add);
		
		return carts;
	}

	@Override
	public Cart getCart(Integer cartIndex) {
		return cartRepository.findById(cartIndex).orElseThrow(() -> new ResourceNotFoundException("Cart", "cartIndex", cartIndex));
	}

	@Override
	public void deleteCart(Integer cartIndex) {
		cartRepository.deleteById(cartIndex);
		
	}
	
	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	@Override
	public void emptyCart() {
		cartRepository.deleteAllInBatch();
	}
	
	@Override
	public Cart updateCart(Cart cart, Integer cartId) {
		Cart existingCart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart", "cartId", cartId));
		existingCart.setCartIndex(cart.getCartIndex());
		existingCart.setQuantity(cart.getQuantity());
		existingCart.setCartIndex(cart.getItem());
		
		cartRepository.save(existingCart);
		return existingCart;
		
	}
	
	@Override 
	public double totalCartPrice() {
		double finalPrice = 0;
		Cuisines cuisine;
		
		List<Cart> cart = getCarts();
		
		for(int i = 0; i < cart.size(); i++) {
    		cuisine = cuisineService.getCuisineById(cart.get(i).getItem());
    		finalPrice += (cuisine.getPrice()*cuisine.getOffer()*(cart.get(i).getQuantity()));
    	}
		
		BigDecimal bd = new BigDecimal(Double.toString(finalPrice));
    	bd = bd.setScale(2, RoundingMode.HALF_UP);
    	
    	return bd.doubleValue();
	}
	
	public void cartToPast(List<Cart> cart, Integer UserId) {
		Orders order = new Orders();
		order.setUserId(UserId);
		order.setOrderTime(null);
		order.setCost(this.totalCartPrice());
		for (int i=0; i<cart.size();i++) {
			OrderHistory oh = new OrderHistory();
			oh.setOrderNumber(order.getOrderNumber());
			oh.setCost(cuisineService.getCuisineById(cart.get(i).getItem()).getCurrentPrice());
			oh.setItem(cart.get(i).getItem());
			oh.setQuantity(cart.get(i).getQuantity());
			orderhistoryService.saveOrderHistory(oh);
		}
		ordersService.saveOrders(order);
	}

}
