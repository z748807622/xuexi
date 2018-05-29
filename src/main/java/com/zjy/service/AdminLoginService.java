package com.zjy.service;

import com.zjy.dao.AdminDao;
import com.zjy.entity.Admin;

public class AdminLoginService {
	
	public String loginVerify(Object username, Object password){
		if (username == null || password == null || username == "" || password == "")
			return "login";
		Admin a = new Admin(username.toString(), password.toString());
		AdminDao ad = new AdminDao();
		if (ad.hasAdmin(a)) {
			return "redirect:/room/info";
		}
		return "login";
		
	}
}
