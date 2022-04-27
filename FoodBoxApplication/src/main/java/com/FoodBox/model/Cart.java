package com.FoodBox.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "cart_index")
	private Integer cart_index;
	
	
	
	@NotNull
	@Column(name = "item")
	private Integer item; //references id in Cuisines class (menu table)
	
	@NotNull
	@Column(name = "quantity")
	private Integer quantity;

	public Cart() {
		super();
	}

	public Cart(Integer cart_index, Integer item, Integer quantity) {
		super();
		this.cart_index = cart_index;
		this.item = item;
		this.quantity = quantity;
	}

	
	public Integer getCartIndex() {
		return cart_index;
	}

	
	public void setCartIndex(Integer cart_index) {
		this.cart_index = cart_index;
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
		return "Cart [cart_index=" + cart_index + ", item=" + item + ", quantity=" + quantity + "]";
	}
	
	

}
