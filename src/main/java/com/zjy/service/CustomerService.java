package com.zjy.service;

import java.util.List;

import com.zjy.dao.CustomerDao;
import com.zjy.entity.Customer;

public class CustomerService {
	
	public List<Customer> getAll(){
		CustomerDao cd = new CustomerDao();
		return cd.getAll();
	}
	
	public Customer getCustomer(String cid){
		CustomerDao cd = new CustomerDao();
		return (Customer) cd.get(cid);
	}
}
