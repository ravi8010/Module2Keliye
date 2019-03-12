package com.capgemini.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Product1")  //This annotation will create table of Product1 in Database
public class Product {
	@Id  //This will make id as primery key
	
	private String id;
	@Column(length=20) 
	private String name;
	@Column(length=20)
	private String model;
	public Product() {
		super();
		
	}
	public Product(String id, String name, String model, int price) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
	}
	private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
