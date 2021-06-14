package com.jsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet的数据处理
 * @author Administrator
 *
 */
@WebServlet("/dataRecieve")
public class DataRecieveServlet extends HttpServlet {

	/**
	 * 获取来自于页面的数据
	 * 将获取到的数据通过流输出到浏览器中
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//1 设置数据的编码方式，方向：由客户端到服务端
		request.setCharacterEncoding("utf-8");
		//2 设置响应的文本类型，方向：服务端到客户端
		response.setContentType("text/html;charset=utf-8");
		//3 获取数据
		String name=request.getParameter("name");
		String score=request.getParameter("score");
		int score2=Integer.parseInt(score)+1;
		
		System.out.println("name="+name+"\tscore===="+score);
		
		PrintWriter out=response.getWriter();
		out.println("姓名："+name);
		out.println("成绩："+ score2);
		
		out.flush();
		out.close();*/
		
		//1 设置数据的编码方式，方向：由客户端到服务端
		request.setCharacterEncoding("utf-8");
		//2 设置响应的文本类型，方向：服务端到客户端
		response.setContentType("text/html;charset=utf-8");
		//3 获取数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String[] channel=request.getParameterValues("channel");
		
		System.out.println("name="+username+"\tscore===="+password);
		
		PrintWriter out=response.getWriter();
		out.println("用户名："+username);
		out.println("密码："+ password);
		
		for(String s:channel) {
			out.println(s);
		}
		
		out.flush();
		out.close();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
