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
	private Integer orderNumber; // PK
	
	@NotNull
	@NotBlank
	@Column(name = "user_id")
	private Integer userId; // references userId in Users class (users table)
	
	@NotNull
	@NotBlank
	@Column(name = "order_time")
	private Date date;
	
	@NotNull
	@NotBlank
	@Column(name = "cost")
	private Float cost;

	public Orders() {
		super();
	}

	public Orders(Integer orderNumber, Integer userId, Date date, Float cost) {
		super();
		this.orderNumber = orderNumber;
		this.userId = userId;
		this.date = date;
		this.cost = cost;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getOrderTime() {
		return date;
	}

	public void setOrderTime(Date orderTime) {
		this.date = date;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	

}
