package com.zjy.dao;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zjy.entity.Admin;

public class AdminDao extends BaseDao {
	private static Log log = LogFactory.getLog(AdminDao.class);
	/**
	 * 验证登陆
	 * @param user
	 * @return
	 */
	public boolean hasAdmin(Admin user){
		Admin a = (Admin) super.get(Admin.class, user.getUserName());
		log.debug(a);
		return user.equals(a);
	}
}
