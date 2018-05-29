package com.zjy.entity;

import java.io.Serializable;
import java.util.Set;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9142472377931381816L;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
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
	private String cid;
	private String cname;
	private String csex;
	private String ctel;
	private Set<ZhuRoom> zhuRoom;
	private Set<ZhuHistory> zhuHistory;
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", csex =" +csex + ", cname=" + cname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
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
		Customer other = (Customer) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		return true;
	}
	
}
