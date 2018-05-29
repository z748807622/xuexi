package com.zjy.service;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zjy.dao.CustomerDao;
import com.zjy.dao.RoomDao;
import com.zjy.dao.ZhuHistoryDao;
import com.zjy.dao.ZhuRoomDao;
import com.zjy.entity.Customer;
import com.zjy.entity.Room;
import com.zjy.entity.ZhuHistory;
import com.zjy.entity.ZhuRoom;

public class ZhuRoomService {
	private static Log log = LogFactory.getLog(ZhuRoomService.class);
	
	/**
	 *获得住房信息byrid
	 * @param rid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ZhuRoom getZhuRoomByRid(String rid){
		
		ZhuRoomDao zrd = new ZhuRoomDao();
		Object o = zrd.getZhuRoomByRid(rid);
		Set<ZhuRoom> zr = null;
		if(o != null)
			zr = (Set<ZhuRoom>) o;
		Iterator<ZhuRoom> i = zr.iterator();
		if(i.hasNext())
			return i.next();
		return null;
		
	}
	
	/**
	 * 退房
	 * @param ids
	 */
	@SuppressWarnings("deprecation")
	public void del(Object ids){
		
		if(ids == null || "".equals(ids))
			return;
		int id = Integer.parseInt(ids.toString());
		
		
		ZhuRoomDao zrd = new ZhuRoomDao();
		
		ZhuHistory zh = new ZhuHistory();
		ZhuRoom zr = (ZhuRoom)zrd.get(ZhuRoom.class,id);
		Room room = zr.getRoom();
		room.setRstate("0");
		
		zh.setCustomer(zr.getCustomer());
		zh.setLdate(zr.getLdate());
		Date now = new Date(new java.util.Date().getTime());
		int day = (int)((now.getTime() - zr.getLdate().getTime())/(24*60*60*1000));
		int price = zr.getRoom().getPrice() * day;
		zh.setPaymoney(price);
		zh.setZdate(new Date(new java.util.Date().getTime()));
		zh.setRoom(zr.getRoom());
		System.out.println(zr.getRoom());
		System.out.println(zr.getCustomer());
		System.out.println(zh);
		Transaction tran = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			tran = session.beginTransaction();
			session.merge(zh);
			zrd.delete(zr);
			session.merge(room);
			tran.commit();
		}catch(Exception e){
			if(tran != null)
				tran.rollback();
			log.info("回滚");
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public String add(String cid,HttpServletRequest req){
		String rid = req.getParameter("rid");
		if(rid == null || "".equals(0))
			return "不存在改用户";
		Room room;
		RoomDao rd = new RoomDao();
		CustomerDao cd = new CustomerDao();
		room = rd.get(Room.class, rid);
		Customer customer = (Customer) cd.get(cid);
		ZhuRoom zhuRoom = new ZhuRoom();
		Date ldate = Date.valueOf(req.getParameter("ldate"));
		int paymoney = Integer.valueOf(req.getParameter("paymoney"));
		zhuRoom.setLdate(ldate);
		zhuRoom.setPaymoney(paymoney);
		room.setRstate("1");
		zhuRoom.setRoom(room);
		try {
			customer.setCname(new String(customer.getCname().getBytes("iso8859-1"),"utf-8"));
			customer.setCsex(new String(customer.getCsex().getBytes("iso8859-1"),"utf-8"));
			log.info("添加顾客："+customer);
			log.info("入住房间为：" + room);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zhuRoom.setCustomer(customer);
		
		
		Transaction tran = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			tran = session.beginTransaction();
			session.merge(room);
			session.merge(zhuRoom);
			tran.commit();
		}catch(Exception e){
			if(tran != null)
				tran.rollback();
			log.info("回滚");
			e.printStackTrace();
			return "入住失败";
		}finally{
			session.close();
		}
		return "入住成功";
	}
	
	/**
	 * 入住
	 * @param customer
	 * @param req
	 */
	public String add(Customer customer,HttpServletRequest req){
		
		String rid = req.getParameter("rid");
		if(rid == null || "".equals(0))
			return "不存在改用户";
		
		Room room;
		RoomDao rd = new RoomDao();
		room = rd.get(Room.class, rid);
		
		ZhuRoom zhuRoom = new ZhuRoom();
		Date ldate = Date.valueOf(req.getParameter("ldate"));
		int paymoney = Integer.valueOf(req.getParameter("paymoney"));
		zhuRoom.setLdate(ldate);
		zhuRoom.setPaymoney(paymoney);
		room.setRstate("1");
		zhuRoom.setRoom(room);
		try {
			customer.setCname(new String(customer.getCname().getBytes("iso8859-1"),"utf-8"));
			customer.setCsex(new String(customer.getCsex().getBytes("iso8859-1"),"utf-8"));
			log.info("添加顾客："+customer);
			log.info("入住房间为：" + room);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zhuRoom.setCustomer(customer);
		
		
		Transaction tran = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			tran = session.beginTransaction();
			session.merge(customer);
			session.merge(room);
			session.merge(zhuRoom);
			tran.commit();
		}catch(Exception e){
			if(tran != null)
				tran.rollback();
			log.info("回滚");
			e.printStackTrace();
			return "入住失败";
		}finally{
			session.close();
		}
		return "入住成功";
	}
}
