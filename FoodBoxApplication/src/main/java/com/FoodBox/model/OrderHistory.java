package com.FoodBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_history")
public class OrderHistory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "order_history_id")
	private Integer ohKey;
	
	@NotNull
	@NotBlank
	@Column(name = "order_number")
	private Integer orderNumber;
	
	@NotNull
	@NotBlank
	@Column(name = "item")
	private Integer item; // menu id references "id" in cuisine class (menu table). 
	
	@NotNull
	@NotBlank
	@Column(name = "quantity")
	private Integer quantity;
	
	@NotNull
	@NotBlank
	@Column(name= "cost")
	private Float cost;
	
	
	
	public OrderHistory() {
		super();
	}



	public OrderHistory(Integer ohKey, Integer orderNumber, Integer item, Integer quantity, Float cost) {
		super();
		this.ohKey = ohKey;
		this.orderNumber = orderNumber;
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PK
	public Integer getOrderHistoryId() {
		return ohKey;
	}



	public void setOrderHistoryId(Integer ohKey) {
		this.ohKey = ohKey;
	}



	public Integer getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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
	
	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	
}
