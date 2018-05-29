package com.zjy.dao;

import java.io.Serializable;
import java.util.Set;

import com.zjy.entity.Room;
import com.zjy.entity.ZhuRoom;

public class ZhuRoomDao extends BaseDao{
	
	
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		super.update(o);
	}

	/**
	 * 通过rid获取房间信息
	 * @param rid
	 * @return
	 */
	public Set<ZhuRoom> getZhuRoomByRid(String rid){
		Room room = (Room)super.get(Room.class, rid);
		Set<ZhuRoom> zr = room.getZhuRoom();
		return zr;
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		super.add(o);
	}

	@Override
	public Object get(Class cla, Serializable id) {
		// TODO Auto-generated method stub
		return super.get(cla, id);
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		super.delete(o);
	}
	
	
	
}
