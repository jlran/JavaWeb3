package com.github.jlran.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.UCDecoder;

import com.github.jlran.entity.User;
import com.github.jlran.service.IUserService;
import com.github.jlran.service.impl.UserDaoService;
import com.github.jlran.util.PageBean;

/**
 * 控制层开发
 * @author jlran
 *
 */
public class IndexServlet extends HttpServlet {

	//创建service实例
	IUserService userService = new UserDaoService();
	//跳转资源
	private String uri;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currPage = request.getParameter("currentPage");
		if(currPage == null || "".equals(currPage.trim())){
			currPage = "1";
		}
		//类型转换
		int currentPage = Integer.parseInt(currPage);
		//创建PageBean对象，设置当前页参数 传入service方法参数
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrentPage(currentPage);
		
		//调用service
		userService.getAll(pageBean);
		
		//保存pagebean对象到request域中
		request.setAttribute("pageBean", pageBean);
		
		//跳转
		uri = "/WEB-INF/list.jsp";
		
		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
