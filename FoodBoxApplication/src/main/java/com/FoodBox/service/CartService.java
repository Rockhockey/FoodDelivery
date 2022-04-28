package com.FoodBox.service;

import java.util.List;

import com.FoodBox.model.Cart;

public interface CartService {

	List<Cart> getCarts(); // list of all carts
	
	Cart getCart(Integer cartIndex); // cart by index(its PK)
	
	void deleteCart(Integer cartIndex); //delete a cart by the index
	
	Cart saveCart(Cart cart); //save a cart
	
	void emptyCart(); // empty the entire cart
	
	Cart updateCart(Cart cart, Integer cartId); //update quantity of an item

	double totalCartPrice();
	
	int cartToPast(List<Cart> cart, Integer UserId); //moves information from current cart to orders and order_history

	int totalQuantity();
	
	//delete cart
	//delete item from cart ?? not sure if this should be implemented here or not
	
}
