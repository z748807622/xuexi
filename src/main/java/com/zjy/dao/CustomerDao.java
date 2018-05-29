package com.zjy.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zjy.entity.Customer;

public class CustomerDao extends BaseDao {

	public Object get(Serializable cid) {
		// TODO Auto-generated method stub
		return super.get(Customer.class, cid);
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		super.add(o);
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		super.update(o);
	}
	
	@SuppressWarnings("rawtypes")
	public List getAll(){
		List customers = new ArrayList();
		customers =  super.excuteAll("from Customer");
		return customers;
	}
}
