package com.zjy.entity;

import java.io.Serializable;
import java.sql.Date;

public class ZhuRoom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7717958516667508776L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Room room;
	private Customer customer;
	private Date ldate;
	private int paymoney;

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
	public Date getLdate() {
		return ldate;
	}
	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}
	public int getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}
	@Override
	public String toString() {
		return "ZhuRoom [id=" + id + ", room=" + room + ", customer="
				+ customer + ", ldate=" + ldate + ", paymoney=" + paymoney
				+ "]";
	}

	
}
