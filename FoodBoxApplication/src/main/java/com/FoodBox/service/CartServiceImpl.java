package com.FoodBox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodBox.DAO.CartRepository;
import com.FoodBox.exception.ResourceNotFoundException;
import com.FoodBox.model.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
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

}
