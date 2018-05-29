package com.zjy.controller;


import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjy.dao.CustomerDao;
import com.zjy.entity.Customer;
import com.zjy.entity.ZhuRoom;
import com.zjy.service.CustomerService;
import com.zjy.service.ZhuRoomService;


@Controller
@RequestMapping(value="zhuroom")
public class ZhuRoomController {
	private static Log log = LogFactory.getLog(RoomController.class);
	
	/**
	 * 输出对应房间入住信息
	 * @param req
	 * @return
	 */
	@RequestMapping(value="info")
	public String info(HttpServletRequest req){
		String rid = req.getParameter("rid");
		ZhuRoomService zrs = new ZhuRoomService();
		ZhuRoom zhuroom = new ZhuRoom();
		zhuroom = zrs.getZhuRoomByRid(rid);
		req.setAttribute("zhuroom", zhuroom);
		return "zhuroominfo";
	}
	/**
	 * 退房
	 * @param req
	 * @return
	 */
	@RequestMapping(value="del")
	public String tuifang(HttpServletRequest req){
		ZhuRoomService zrs = new ZhuRoomService();
		Object id = req.getParameter("id");
		zrs.del(id);
		return "redirect:/room/info";
	}
	
	/**
	 * 入住页面
	 * @param req
	 * @return
	 */
	@RequestMapping(value="zhupage")
	public ModelAndView showRuZhuPage(HttpServletRequest req){
		CustomerService cs = new CustomerService();
		List<Customer> customers = cs.getAll();
		req.setAttribute("customers", customers);
		Object o = req.getParameter("rid");
		

			
		Integer num = null;
		if(o!=null)
			num = Integer.valueOf(o.toString());
		log.info("客房rid为："+num);
		return new ModelAndView("addcus","rid",num);
	}
	
	/**
	 * 入住
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="zhu")
	public String ruzhu(Customer customer,HttpServletRequest req){
		ZhuRoomService zrs = new ZhuRoomService();
		Object oflag = req.getParameter("rrid");
		String result = "";
		if(oflag != null && !"false".equals(oflag)){
			result = zrs.add(oflag.toString(), req);
		}
		result = zrs.add(customer, req);
		req.setAttribute("result", result);
		return "redirect:/room/info";
	}
}
