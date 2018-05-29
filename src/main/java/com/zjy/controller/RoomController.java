package com.zjy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjy.entity.Room;
import com.zjy.service.RoomService;

@Controller
@RequestMapping(value="/room")
public class RoomController {
	
	private static Log log = LogFactory.getLog(RoomController.class);
	
	@RequestMapping(value="/info")
	public ModelAndView getAllRoom(HttpServletRequest req){
		RoomService rs = new RoomService();
		List<Room> list = rs.getAllRoom(0, 10);
		log.info("所有房间长度为："+list.size());
		req.getSession().setAttribute("allroom", list);
		return new ModelAndView("index","allroom",list);
	}
	
	@RequestMapping(value="/addroompage")
	public String showAddPage(){
		return "addroom";
	}
	@RequestMapping(value="addroom")
	public String add(HttpServletRequest req){
		RoomService rs = new RoomService();
		Room room = new Room();
		room.setRid(req.getParameter("rid"));
		room.setBednum(req.getParameter("bednum"));
		room.setPrice(Integer.parseInt(req.getParameter("price")));
		room.setRstate("0");
		log.info(room);
		rs.addRoom(room);
		return "redirect:/room/info";
	}
}
