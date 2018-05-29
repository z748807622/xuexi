package com.zjy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjy.service.AdminLoginService;

@Controller
@RequestMapping(value = "/login")
public class AdminLogin {
	@RequestMapping
	public String loginIndex(HttpServletRequest req) {
		if(req.getSession().getAttribute("username") != null)
			return "redirect:/room/info";
		Object username = req.getParameter("username");
		Object password = req.getParameter("password");
		AdminLoginService als = new AdminLoginService();
		String result = "";
		result = als.loginVerify(username, password);
		if(!result.equals("login"))
			req.getSession().setAttribute("username", username);
		return result;
	}
}
