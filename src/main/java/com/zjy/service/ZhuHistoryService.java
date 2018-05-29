package com.zjy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zjy.dao.CustomerDao;
import com.zjy.dao.ZhuHistoryDao;
import com.zjy.entity.Customer;
import com.zjy.entity.ZhuHistory;

public class ZhuHistoryService {
	
	/**
	 * 
	 * @return
	 */
	public List<ZhuHistory> getAll(){
		List<ZhuHistory> zhuHistorys = new ArrayList<ZhuHistory>();
		ZhuHistoryDao zh = new ZhuHistoryDao();
		zhuHistorys = zh.getAll("from ZhuHistory");
		return zhuHistorys;
	}

	public Set<ZhuHistory> getBycid(String cid) {
		Set<ZhuHistory> zhuHistorys = new HashSet<ZhuHistory>();
		CustomerDao cd = new CustomerDao();
		Customer customer = (Customer) cd.get(cid);
		zhuHistorys = customer.getZhuHistory();
		return zhuHistorys;
	}
	
}
