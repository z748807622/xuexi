package com.zjy.dao;

public interface EntityDao<o> {
	public void add(o entity);
	public void delete(o entity);
	public o load(Object id);
	public void update(o entity);
}
