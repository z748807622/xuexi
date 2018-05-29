package com.zjy.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjy.entity.Customer;
import com.zjy.entity.ZhuHistory;
import com.zjy.service.CustomerService;
import com.zjy.service.ZhuHistoryService;

@Controller
@RequestMapping(value="zhuhistory")
public class ZhuHistoryController {
	private static Log log = LogFactory.getLog(ZhuHistoryController.class);
	
	@RequestMapping
	public ModelAndView getAll(HttpServletRequest req){
		ZhuHistoryService zhs = new ZhuHistoryService();
		CustomerService cs = new CustomerService();
		List<ZhuHistory> zhuHistorys = zhs.getAll();
		List<Customer> customers = cs.getAll();
		log.info("查询到的客户数量为：" + customers.size());
		req.setAttribute("customers", customers);
		return new ModelAndView("zhuhistory","zhuhistorys",zhuHistorys);
	}
	
	@RequestMapping(value="bycid")
	public ModelAndView getInfoByRid(String cid,HttpServletRequest req){
		System.out.println("查询的客户cid为：" + cid);
		ZhuHistoryService zhs = new ZhuHistoryService();
		CustomerService cs = new CustomerService();
		Set<ZhuHistory> zhuHistorys = zhs.getBycid(cid);
		List<Customer> customers = cs.getAll();
		log.info("查询到的客户数量为：" + customers.size());
		req.setAttribute("customers", customers);
		return new ModelAndView("zhuhistory","zhuhistorys",zhuHistorys);
	}
}
