package com.FoodBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;

import com.FoodBox.CustomAnnotations.UniqueUsername;




@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "user_id")
	private Integer user_id;// PK
	
	//@UniqueUsername
	@Size(min=3, max=50)
	@Column(name = "username")
	private String username;
	
	@Column(name = "hash")
	private String hash;
	
	@Email(message="Please enter a valid e-mail address")
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Column(name = "address")
	private String address;

	@Column(name = "is_admin")
	private boolean is_admin;
	
	@Size(min=8, max=15)
	@Transient
	private String password;
	
	
	public Users() {
		super();
	}
	
	

	public Users(Integer user_id, String username, String Hash, String email, String address, boolean is_admin) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.hash = Hash;
		this.email = email;
		this.address = address;
		this.is_admin = is_admin;
	}

	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
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
	
	public boolean getIsAdmin() {
		return is_admin;
	}

	public void setIsAdmin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	@Override
	public String toString() {
		return "users [userid=" + user_id + ", username=" + username + ", hash=" + hash + ", email=" + email + ", address=" + address + ", IsAdmin=" + is_admin + "]";
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}





	
	
}
