package com.FoodBox.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Column(name = "OrderNumber")
	private Integer orderNumber; // PK
	
	@Column(name = "UserId")
	private Integer userId; // references userId in Users class (users table)
	
	@Column(name = "OrderTime")
	private Date date;
	
	@Column(name = "Cost")
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //PK
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	

}
