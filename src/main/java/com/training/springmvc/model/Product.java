package com.training.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERPRODUCT")
public class Product {

	@Id
	@Column(name="PROD_ID")
	private int prodId;
	
	@Column(name="PROD_NAME")
	private String prodName;
	
	@Column(name="Image")
	private String image;
	
	@Column(name="PROD_DESC")
	private String prodDesc;
	
	@Column(name="PRICE")
	private double price;
	
	public Product() {

	}

	public Product(int prodId, String prodName, String image, String prodDesc, double price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.image = image;
		this.prodDesc = prodDesc;
		this.price = price;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
