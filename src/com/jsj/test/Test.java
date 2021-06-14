package com.jsj.test;

import com.jsj.dao.IUserDao;
import com.jsj.dao.impl.UserDaoImpl;
import com.jsj.model.User;

public class Test {

	public static void main(String[] args) {
		
	}
	
	
	@org.junit.Test
	public void testAdd() {
		IUserDao userDao=new UserDaoImpl();
		User user=new User();
		user.setUsername("wangwu");
		user.setPassword("1234");
		int ret=userDao.add(user);
		System.out.println(ret==1?"ok":"no ok");
	}
	@org.junit.Test
	public void testDel() {
		IUserDao userDao=new UserDaoImpl();		
		int ret=userDao.delete(2);
		System.out.println(ret==1?"ok":"no ok");
	}

}
