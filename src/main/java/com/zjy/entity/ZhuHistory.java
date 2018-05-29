package com.zjy.entity;

import java.io.Serializable;
import java.sql.Date;

public class ZhuHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1735301333337054040L;
	private int id;
	private Room room;
	private Customer customer;
	private Date zdate;
	private Date ldate;
	
	public Date getZdate() {
		return zdate;
	}
	public void setZdate(Date zdate) {
		this.zdate = zdate;
	}
	public Date getLdate() {
		return ldate;
	}
	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}
	private int paymoney;
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

	public int getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}
	@Override
	public String toString() {
		return "ZhuHistory [room=" + room + ", customer=" + customer + "]";
	}
	
}
