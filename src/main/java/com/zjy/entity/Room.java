package com.zjy.entity;

import java.io.Serializable;
import java.util.Set;

public class Room implements Serializable {
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getBednum() {
		return bednum;
	}
	public void setBednum(String bednum) {
		this.bednum = bednum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public Set<ZhuRoom> getZhuRoom() {
		return zhuRoom;
	}
	public void setZhuRoom(Set<ZhuRoom> zhuRoom) {
		this.zhuRoom = zhuRoom;
	}
	public Set<ZhuHistory> getZhuHistory() {
		return zhuHistory;
	}
	public void setZhuHistory(Set<ZhuHistory> zhuHistory) {
		this.zhuHistory = zhuHistory;
	}
	private String rid;
	private String bednum;
	private int price;
	private String rstate;
	private Set<ZhuRoom> zhuRoom;
	private Set<ZhuHistory> zhuHistory;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
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
		Room other = (Room) obj;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		return true;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3535904105620701123L;
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Room [rid=" + rid + ", bednum=" + bednum + ", price=" + price
				+ ", rstate=" + rstate + "]";
	}

	
}
