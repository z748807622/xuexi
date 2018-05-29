package com.zjy.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zjy.entity.ZhuHistory;

public class ZhuHistoryDao extends BaseDao {
	private static Log log = LogFactory.getLog(ZhuHistoryDao.class);


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ZhuHistory> getAll(String hql){
		
		List list = new ArrayList();
		list = super.excuteAll(hql);
		log.info("查到所有住房记录条数为：" + list.size());
		System.out.println("一条住房信息为："+((ZhuHistory)(list.get(1))));
		return list;
	}
	
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		super.add(o);
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		super.delete(o);
	}

}
