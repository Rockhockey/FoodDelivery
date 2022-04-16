package com.FoodBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderHistory")
public class OrderHistory {

	@Column(name = "OHKey")
	private Integer ohKey;
	
	@Column(name = "OrderNumber")
	private Integer orderNumber;
	
	@Column(name = "Item")
	private Integer menuId; // menu id references "id" in cuisine class (menu table). 
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	
	
	public OrderHistory() {
		super();
	}



	public OrderHistory(Integer ohKey, Integer orderNumber, Integer menuId, Integer quantity) {
		super();
		this.ohKey = ohKey;
		this.orderNumber = orderNumber;
		this.menuId = menuId;
		this.quantity = quantity;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PK
	public Integer getOhKey() {
		return ohKey;
	}



	public void setOhKey(Integer ohKey) {
		this.ohKey = ohKey;
	}



	public Integer getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}



	public Integer getMenuId() {
		return menuId;
	}



	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
