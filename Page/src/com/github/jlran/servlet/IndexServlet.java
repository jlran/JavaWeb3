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
 * ���Ʋ㿪��
 * @author jlran
 *
 */
public class IndexServlet extends HttpServlet {

	//����serviceʵ��
	IUserService userService = new UserDaoService();
	//��ת��Դ
	private String uri;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currPage = request.getParameter("currentPage");
		if(currPage == null || "".equals(currPage.trim())){
			currPage = "1";
		}
		//����ת��
		int currentPage = Integer.parseInt(currPage);
		//����PageBean�������õ�ǰҳ���� ����service��������
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrentPage(currentPage);
		
		//����service
		userService.getAll(pageBean);
		
		//����pagebean����request����
		request.setAttribute("pageBean", pageBean);
		
		//��ת
		uri = "/WEB-INF/list.jsp";
		
		request.getRequestDispatcher(uri).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
