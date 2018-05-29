package com.zjy.entity;

import java.io.Serializable;

public class TestEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1240238596135376423L;
	
	private Room room;
	private Customer customer;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
