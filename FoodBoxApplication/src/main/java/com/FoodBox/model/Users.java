package com.FoodBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Users")
public class Users {


	@Column(name = "UserId")
	private Integer userId;// PK
	
	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "Salt")
	private String salt;
	
	@Column(name = "Hash")
	private String hash;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Address")
	private String address;

	protected Users() {
		super();
	}
	
	

	public Users(Integer userId, String userName, String salt, String Hash, String email, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.salt = salt;
		this.hash = Hash;
		this.email = email;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", email=" + email + ", address=" + address + "]";
	}

	
	
}
