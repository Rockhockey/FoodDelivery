package com.FoodBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name = "userid")
	private Integer userId;// PK
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "salt")
	private String salt;
	
	@Column(name = "hash")
	private String hash;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;

	@Column(name = "isadmin")
	private boolean isAdmin;
	
	@Transient
	private String password;
	
	
	public Users() {
		super();
	}
	
	

	public Users(Integer userId, String userName, String salt, String Hash, String email, String address, boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.salt = salt;
		this.hash = Hash;
		this.email = email;
		this.address = address;
		this.isAdmin = isAdmin;
	}

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
	
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "users [userid=" + userId + ", username=" + userName + ", salt=" + salt + ", hash=" + hash + ", email=" + email + ", address=" + address + ", isadmin=" + isAdmin + "]";
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}





	
	
}
