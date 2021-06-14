package com.jsj.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsj.dao.IMessageDao;
import com.jsj.model.Message;

/**
 * ctrl shift o
 * @author Administrator
 *
 */

public class MessageDaoImpl extends BaseDao implements IMessageDao {
	
	private BaseDao dao=new BaseDao();

	@Override
	public int add(Message message) {
		String sql="insert into message(title,content,createdatetime,userid,pid)values(?,?,?,?,?)";
		Object[] params=new Object[] {message.getTitle(),message.getContent(),message.getCreateDateTime(),message.getUserId(),message.getPid()};
		return dao.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql="delete from message where id=?";
		Object[] params=new Object[] {id};
		return dao.updateBySql(sql, params);
	}

	@Override
	public int edit(Message message) {
		String sql="update message set title=?,content=?,createdatetime=?,userid=?,pid=? where id=?";
		Object[] params=new Object[] {message.getTitle(),message.getContent(),message.getCreateDateTime(),message.getUserId(),message.getPid(),message.getId()};
		return dao.updateBySql(sql, params);
	}

	@Override
	public Message get(int id) {
		Message m=new Message();
		String sql="select * from message where id=?";
		Object[] params=new Object[] {id};
		dao.queryBySql(sql, params);
		try {
			while(rs.next()) {
				m.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCreateDateTime(rs.getDate("createdatetime"));
				m.setUserId(rs.getInt("userid"));
				m.setPid(rs.getInt("pid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return m;
	}

	@Override
	public List<Message> getAll() {
		List<Message> list=new ArrayList<>();
		String sql="select * from tmessage";
		Object[] params=new Object[] {};
		dao.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Message m=new Message();
				m.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCreateDateTime(rs.getDate("createdatetime"));
				m.setUserId(rs.getInt("userid"));
				m.setPid(rs.getInt("pid"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
