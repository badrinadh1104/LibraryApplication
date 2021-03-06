package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String phone;
	private String Email;
	private String Usertype;
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "User_id")
	private List<WishList> wishList;
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "User_id")
	private List<completedList> completedList;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String phone, String email, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		Email = email;
		Usertype = usertype;
		this.wishList = new ArrayList<WishList>();  
		this.completedList = new ArrayList<completedList>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsertype() {
		return Usertype;
	}
	public void setUsertype(String usertype) {
		Usertype = usertype;
	}
	public List<WishList> getWishList() {
		return wishList;
	}
	public void setWishList(List<WishList> wishList) {
		this.wishList = wishList;
	}
	public List<completedList> getCompletedList() {
		return completedList;
	}
	public void setCompletedList(List<completedList> completedList) {
		this.completedList = completedList;
	}
	public void AddtoWishList(WishList w) {
		if(this.wishList==null) {
			wishList= new ArrayList<WishList>();
		}
		wishList.add(w);
	}
	public void AddtoCompletedList(completedList c) {
		if(this.completedList==null) {
			completedList = new ArrayList<completedList>();		
		}
		completedList.add(c);
	}
	

}



/*
 id:number;
    userName:String;
    Password:String;
    Phone:String;
    Email:String;
    Usertype:String;
    WishList:number[];
    Completed:number[];
  */
 