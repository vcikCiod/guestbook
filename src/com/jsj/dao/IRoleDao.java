package com.jsj.dao;

import java.util.List;

import com.jsj.model.Role;

public interface IRoleDao {

	//如果操作成功的话，返回的是被影响的数据库的行数
	//返回值为0，说明失败
	/**
	 * 新增记录
	 * @param role
	 * @return
	 */
	public abstract int add(Role role);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public abstract int delete(int id);
	
	/**
	 * 修改
	 * @param role
	 * @return
	 */
	public abstract int edit(Role role);
	
	/**
	 * 查询一个对象
	 * @param id
	 * @return
	 */
	public abstract Role get(int id);
	
	/**
	 * 查询所有对象
	 * @return
	 */
	public abstract List<Role> getAll();
	
	
}
