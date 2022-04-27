package com.FoodBox.model;

import java.sql.Date;

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
@Table(name = "orders")
public class Orders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "order_number")
	private Integer order_number; // PK
	
	@NotNull
	@NotBlank
	@Column(name = "user_id")
	private Integer user_id; // references userId in Users class (users table)
	
	@NotNull
	@NotBlank
	@Column(name = "order_time")
	private Date order_time;
	
	@NotNull
	@NotBlank
	@Column(name = "cost")
	private Float cost;

	public Orders() {
		super();
	}

	public Orders(Integer order_number, Integer user_id, Date order_time, Float cost) {
		super();
		this.order_number = order_number;
		this.user_id = user_id;
		this.order_time = order_time;
		this.cost = cost;
	}

	public Integer getOrderNumber() {
		return order_number;
	}

	public void setOrderNumber(Integer order_number) {
		this.order_number = order_number;
	}

	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getOrderTime() {
		return order_time;
	}

	public void setOrderTime(Date order_time) {
		this.order_time = order_time;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	

}
