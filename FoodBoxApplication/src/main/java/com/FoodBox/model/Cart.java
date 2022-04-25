package com.FoodBox.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CartIndex")
	private Integer cartIndex;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	private Cuisines cuisine;
	
	
	@Column(name = "Item")
	private Integer item; //references id in Cuisines class (menu table)
	
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
