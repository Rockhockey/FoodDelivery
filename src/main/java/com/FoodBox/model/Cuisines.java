package com.FoodBox.model;




import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "menu")
public class Cuisines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menuId")
	private Integer menuId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "cuisine_type")
	private String cuisineType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "offer")
	private float offer;
	
	@Column(name = "visible")
	private boolean visible;

	
	//default constructor
	public Cuisines() {
		super();
	}
	

	//constructor with fields
	public Cuisines(Integer menuId, String name, double price, String cuisineType, String description, float offer, boolean visible) 
	{
		
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.cuisineType = cuisineType;
		this.description = description;
		this.offer = offer;
		this.visible = visible;
	}

	
	public Integer getId() {
		return menuId;
	}

	public void setId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getOffer() {
		return offer;
	}

	public void setOffer(float offer) {
		this.offer = offer;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	@Override
	public int hashCode() {
		return Objects.hash(menuId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuisines other = (Cuisines) obj;
		return Objects.equals(menuId, other.menuId);
	}
	
	

}
