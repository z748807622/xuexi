package com.zjy.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zjy.entity.Room;


public class RoomDao extends BaseDao {
	

	@Override
	public Room get(Class cla, Serializable id) {
		// TODO Auto-generated method stub
		return (Room)super.get(cla, id);
	}

	private static Log log = LogFactory.getLog(RoomDao.class);
	
	/**
	 * ��ӿͷ�
	 * @param room
	 */
	public void add(Room room){
		super.add(room);
	}
	
	/**
	 * �޸Ŀͷ���Ϣ
	 * @param room
	 */
	public void update(Room room){
		super.update(room);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Room> getAllRoom(int start, int size){
		List list = super.excute("from Room", start, size);
		log.info("房间长度:" + list.size());
		return list;
	}
}
