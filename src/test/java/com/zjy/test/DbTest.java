package com.zjy.test;

import com.zjy.dao.RoomDao;
import com.zjy.entity.Room;

import junit.framework.TestCase;

public class DbTest extends TestCase {
	//SessionFactory sf = new Configuration().configure().buildSessionFactory();
	//Session session = sf.openSession();
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAdmin() {
		RoomDao rd = new RoomDao();
		Room r = rd.get(Room.class, "2");
		System.out.println(r);
	}

}
