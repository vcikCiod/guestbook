package com.jsj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	//指定mysql数据库驱动类
	static String driver="com.mysql.jdbc.Driver";
	//指定连接数据库的数据库连接字符串
	static String url="jdbc:mysql://127.0.0.1:3306/guestbook?useUnicode=yes&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true";
	//指定用户名
	static String user="root";
	//指定用户名
	static String password="";
	
	//加载数据库驱动
	static {
		try {
			//加载数据库驱动到jvm
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库连接
	public static Connection getConnecton() {
		
		Connection conn=null;
		
		try {
			//通过DriverManager获取一个到数据库的连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//关闭数据库资源
	public static void close(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}finally {
				if(st!=null) {
					try {
						st.close();
					} catch (SQLException e) {					
						e.printStackTrace();
					}finally {
						if(conn!=null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	public static int updateBySql(String sql) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		int  ret=0;
		//alt+/
		conn=DBUtils.getConnecton();
		//通过conn拿到st，createStatement
		try {
			st=conn.createStatement();
			//statement中有两个方法
			//其中executeQuery方法用于查询
			//executeUpdate方法用于增、删、改				
			ret=st.executeUpdate(sql);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Connection conn=DBUtils.getConnecton();
		System.out.println(conn);
	}
	
	
}
