package com.FoodBox.model;




import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "Menu")
public class Cuisines {

	@Column(name = "MenuId")
	private Integer id;
	
	@Column(name = "Name", nullable = false)
	private String plateName;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Cuisine")
	private String cuisine;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Offer")
	private float offer;
	
	@Column(name = "Visible")
	private boolean visible;

	
	//default constructor
	public Cuisines() {
		super();
	}
	

	//constructor with fields
	public Cuisines(Integer id, String plateName, double price, String cuisine, String description, float offer, boolean visible) 
	{
		
		super();
		this.id = id;
		this.plateName = plateName;
		this.price = price;
		this.cuisine = cuisine;
		this.description = description;
		this.offer = offer;
		this.visible = visible;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
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
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
	

}
