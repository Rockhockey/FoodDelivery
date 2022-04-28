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
	private Integer order_history_id;
	
	@Column(name = "order_number")
	private Integer order_number;
	
	@Column(name = "item")
	private Integer item; // menu id references "id" in cuisine class (menu table). 
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name= "cost")
	private double cost;
	
	
	
	public OrderHistory() {
		super();
	}



	public OrderHistory(Integer order_history_id, Integer order_number, Integer item, Integer quantity, double cost) {
		super();
		this.order_history_id = order_history_id;
		this.order_number = order_number;
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PK
	public Integer getOrderHistoryId() {
		return order_history_id;
	}



	public void setOrderHistoryId(Integer order_history_id) {
		this.order_history_id = order_history_id;
	}



	public Integer getOrderNumber() {
		return order_number;
	}



	public void setOrderNumber(Integer order_number) {
		this.order_number = order_number;
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
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
