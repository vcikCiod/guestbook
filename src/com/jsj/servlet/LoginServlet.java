package com.jsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsj.dao.IUserDao;
import com.jsj.dao.impl.UserDaoImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private IUserDao userDao=new UserDaoImpl();
	
	/**
	 * 在数据库中验证用户的合法性
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 设置数据的编码方式，方向：由客户端到服务端
		request.setCharacterEncoding("utf-8");
		//2 设置响应的文本类型，方向：服务端到客户端
		response.setContentType("text/html;charset=utf-8");
		//3 获取数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		PrintWriter out=response.getWriter();
		
		boolean flag=userDao.login(username, password);
		if(flag) {
		   //response.sendRedirect(request.getContextPath()+"/index.jsp");
		   request.setAttribute("book", "java web");
		   RequestDispatcher dispatcher=request.getRequestDispatcher("/Index");
		   dispatcher.forward(request, response);
		   
		 
		}else {
			out.println("非法用户，请检查！");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
