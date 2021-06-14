package com.jsj.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsj.dao.IRoleDao;
import com.jsj.model.Role;

/**
 * ctrl shift o
 * @author Administrator
 *
 */

public class RoleDaoImpl extends BaseDao implements IRoleDao {
	
	private BaseDao dao=new BaseDao();

	@Override
	public int add(Role role) {
		String sql="insert into trole(rolename)values(?)";
		Object[] params=new Object[] {role.getRoleName()};
		return dao.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql="delete from trole where id=?";
		Object[] params=new Object[] {id};
		return dao.updateBySql(sql, params);
	}

	@Override
	public int edit(Role role) {
		String sql="update trole set rolename=? where id=?";
		Object[] params=new Object[] {role.getRoleName(),role.getId()};
		return dao.updateBySql(sql, params);
	}

	@Override
	public Role get(int id) {
		Role r=new Role();
		String sql="select * from trole where id=?";
		Object[] params=new Object[] {id};
		dao.queryBySql(sql, params);
		try {
			while(rs.next()) {
				r.setId(rs.getInt("id"));
				r.setRoleName(rs.getString("rolename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return r;
	}

	@Override
	public List<Role> getAll() {
		List<Role> list=new ArrayList<>();
		String sql="select * from trole";
		Object[] params=new Object[] {};
		dao.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Role r=new Role();
				r.setId(rs.getInt("id"));
				r.setRoleName(rs.getString("rolename"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
