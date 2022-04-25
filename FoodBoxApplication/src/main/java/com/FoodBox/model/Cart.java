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
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "cart_index")
	private Integer cartIndex;
	
	
	
	@NotNull
	@Column(name = "item")
	private Integer item; //references id in Cuisines class (menu table)
	
	@NotNull
	@Column(name = "quantity")
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
