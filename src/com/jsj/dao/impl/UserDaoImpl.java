package com.jsj.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsj.dao.IUserDao;
import com.jsj.model.User;

/**
 * ctrl shift o
 * @author Administrator
 *
 */

public class UserDaoImpl extends BaseDao implements IUserDao {
	
	//private BaseDao dao=new BaseDao();

	@Override
	public int add(User user) {
		String sql="insert into tuser(username,password,roleId)values(?,?,?)";
		Object[] params=new Object[] {user.getUsername(),user.getPassword(),user.getRoleId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql="delete from tuser where id=?";
		Object[] params=new Object[] {id};
		return this.updateBySql(sql, params);
	}

	@Override
	public int edit(User user) {
		String sql="update tuser set username=?,password=?,roleid=? where id=?";
		Object[] params=new Object[] {user.getUsername(),user.getPassword(),user.getRoleId(),user.getId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public User get(int id) {
		User u=new User();
		String sql="select * from tuser where id=?";
		Object[] params=new Object[] {id};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRoleId(rs.getInt("roleid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return u;
	}

	@Override
	public List<User> getAll() {
		List<User> list=new ArrayList<>();
		String sql="select * from tuser";
		Object[] params=new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRoleId(rs.getInt("roleid"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return list;
	}

	@Override
	public boolean login(String username, String password) {
		User u=null;
		String sql="select * from tuser where username=? and password=?";
		Object[] params=new Object[] {username,password};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRoleId(rs.getInt("roleid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return u==null?false:true;
	}

}
