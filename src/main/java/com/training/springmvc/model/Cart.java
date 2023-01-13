package com.training.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CART")
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cart_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="prod_id")
	private int prod_id;
	
	@Column(name="prod_name")
	private String prod_name;
	
	@Column(name="prod_desc")
	private String prod_desc;
	
	@Column(name="price")
	private double price;

	public Cart(int user_id, int prod_id, String prod_name, String prod_desc, double price) {
		super();
		this.user_id = user_id;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_desc = prod_desc;
		this.price = price;
	}

	public Cart() {
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
