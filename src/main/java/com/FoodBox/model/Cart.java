package com.FoodBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

	@Column(name = "CartIndex")
	private Integer cartIndex;
	
	@Column(name = "Item")
	private Integer item; // references id in Cuisines class (menu table)
	
	@Column(name = "Quantity")
	private Integer quantity;

	public Cart() {
		super();
	}

	public Cart(Integer cartIndex, Integer item, Integer quantity) {
		super();
		this.cartIndex = cartIndex;
		this.item = item;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getCartIndex() {
		return cartIndex;
	}

	public void setCartIndex(Integer cartIndex) {
		this.cartIndex = cartIndex;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartIndex=" + cartIndex + ", item=" + item + ", quantity=" + quantity + "]";
	}
	
	

}
