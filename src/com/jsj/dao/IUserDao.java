package com.jsj.dao;

import java.util.List;

import com.jsj.model.User;

public interface IUserDao {

	//如果操作成功的话，返回的是被影响的数据库的行数
	//返回值为0，说明失败
	/**
	 * 新增记录
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract int add(User user);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public abstract int delete(int id);
	
	/**
	 * 修改
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract int edit(User user);
	
	/**
	 * 查询一个对象
	 * @param id
	 * @return
	 */
	public abstract User get(int id);
	
	/**
	 * 查询所有对象
	 * @return
	 */
	public abstract List<User> getAll();
	
	/**
	 * 用户登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	boolean login(String username,String password);
	
	
}
