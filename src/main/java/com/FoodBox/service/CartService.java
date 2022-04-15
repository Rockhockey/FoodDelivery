package com.FoodBox.service;

import java.util.List;

import com.FoodBox.model.Cart;

public interface CartService {

	List<Cart> getCarts(); // list of all carts
	
	Cart getCart(Integer cartIndex); // cart by index(its PK)
	
	void deleteCart(Integer cartIndex); //delete a cart by the index
	
	//delete cart
	//delete item from cart ?? not sure if this should be implemented here or not
	
}
