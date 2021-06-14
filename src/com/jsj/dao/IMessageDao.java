package com.jsj.dao;

import java.util.List;

import com.jsj.model.Message;

public interface IMessageDao {

	//如果操作成功的话，返回的是被影响的数据库的行数
	//返回值为0，说明失败
	/**
	 * 新增记录
	 * @param message
	 * @return
	 */
	public abstract int add(Message message);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public abstract int delete(int id);
	
	/**
	 * 修改
	 * @param message
	 * @return
	 */
	public abstract int edit(Message message);
	
	/**
	 * 查询一个对象
	 * @param id
	 * @return
	 */
	public abstract Message get(int id);
	
	/**
	 * 查询所有对象
	 * @return
	 */
	public abstract List<Message> getAll();
	
	
}
