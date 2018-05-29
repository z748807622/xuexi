package com.zjy.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class BaseDao {
	
	/**
	 * 添加
	 * @param o
	 */
	protected void add(Object o){
		Transaction tran = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			tran = session.beginTransaction();
			session.save(o);
			tran.commit();
		}catch(Exception e){
			if(tran != null)
				tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	/**
	 * 获取
	 * @param cla
	 * @param id
	 * @return
	 */
	protected Object get(Class cla, Serializable id){
		Object o = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			o = session.get(cla, id);
		}catch(Exception e){
			session.close();
		}
		return o;
	}
	/**
	 * 删除
	 * @param o
	 */
	protected void delete(Object o){
		Transaction tran = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			tran = session.beginTransaction();
			session.delete(o);
			tran.commit();
		}catch(Exception e){
			if(tran != null)
				tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	/**
	 * 修改
	 * @param o
	 */
	protected void update(Object o){
		Transaction tran = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try{
			tran = session.beginTransaction();
			session.update(o);
			tran.commit();
		}catch(Exception e){
			if(tran != null)
				tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	/**
	 * hql查询
	 * @param hql
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	protected List<Object> excute(String hql, int start, int size){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(size);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List<Object> excuteAll(String hql){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	@SuppressWarnings({ "rawtypes", "deprecation" })
	protected Object excute(String hql){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		List list = null;
		try{
			Query query = session.createQuery(hql);
			//TODO
			list = query.list();
			return list.get(list.size()-1);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
