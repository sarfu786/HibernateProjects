package com.ty.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Iid;
	private String name;
	private double cost;
	private double Quantity;
	@ManyToOne
	@JoinColumn
	private Medorder order;
	public int getIid() {
		return Iid;
	}
	public void setIid(int iid) {
		Iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	public Medorder getOrder() {
		return order;
	}
	public void setOrder(Medorder order) {
		this.order = order;
	}
	
	

}
