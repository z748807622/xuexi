package com.zjy.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zjy.dao.RoomDao;
import com.zjy.entity.Room;

/**
 * 获得所有房间
 * @author �ž���
 *
 */
public class RoomService {
	
	
	@SuppressWarnings("rawtypes")
	public List<Room> getAllRoom(int start, int size){
		RoomDao rd = new RoomDao();
		List list = rd.getAllRoom(start, size);
		List<Room> roomList = new ArrayList<Room>();
		if(list != null){
			Iterator iterable = list.iterator();
			while(iterable.hasNext()){
				roomList.add((Room)iterable.next());
			}
		}
		return roomList;
	}
	
	public void addRoom(Room room){
		RoomDao rd = new RoomDao();
		rd.add(room);
	}
}
