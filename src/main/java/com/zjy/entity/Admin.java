package com.zjy.entity;

import java.io.Serializable;


public class Admin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7933484952307616908L;
	private String userName;
	
	public Admin(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public Admin(){}
	private String passWord;
	public String getUserName() {
		return userName;
	}
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", passWord=" + passWord + "]";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
