package com.FoodBox.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;


@Entity
@Table(name = "menu")
public class Cuisines {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "menu_id")
	private Integer menu_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "cuisine_type")
	private String cuisine_type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "offer")
	private float offer;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "visible")
	private boolean visible;

	
	@Transient
	private float CurrentPrice;
	
	//default constructor
	public Cuisines() {
		super();
	}
	

	//constructor with fields
	public Cuisines(Integer menu_id, String name, float price, String cuisine_type, String description, float offer, String picture, boolean visible) 
	{
		
		super();
		this.menu_id = menu_id;
		this.name = name;
		this.price = price;
		this.cuisine_type = cuisine_type;
		this.description = description;
		this.offer = offer;
		this.picture = picture;
		this.visible = visible;
	}

	
	public Integer getId() {
		return menu_id;
	}

	public void setId(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getCurrentPrice() {
		return price;
	}

	public void setCurrentPrice(float currentPrice) {
		this.CurrentPrice = currentPrice;
	}

	public String getCuisineType() {
		return cuisine_type;
	}

	public void setCuisineType(String cuisine_type) {
		this.cuisine_type = cuisine_type;
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
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	@Override
	public int hashCode() {
		return Objects.hash(menu_id);
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
		return Objects.equals(menu_id, other.menu_id);
	}
	
	

}
