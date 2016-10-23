package com.github.jlran;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if(method != null){
			if("down".equals(method)){
				try {
					downfile(request,response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else{
			//获取下载列表
			request.setCharacterEncoding("utf-8");
			downList(request,response);
		}
	}

	public void downfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = request.getParameter("file");
		fileName = new String(fileName.getBytes("ISO8859-1"),"utf-8");
		String path = this.getServletContext().getRealPath("/upload");
		File file = new File(path, fileName);
		InputStream in = new FileInputStream(file);
		
		// 如果文件名是中文，需要进行url编码
		fileName = URLEncoder.encode(fileName, "utf-8");
		//设置下载的响应头
		response.setHeader("content-disposition", "attachment;fileName=" + fileName);
		
		//获取response字节流
		ServletOutputStream out = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while((len = in.read(b)) != -1){
			out.write(b, 0, len);
		}
		
		//关闭
		out.close();
		in.close();
		
	}

	public void downList(HttpServletRequest request,HttpServletResponse response) {
		List<String> list = new ArrayList<String>();
		String path = this.getServletContext().getRealPath("/upload");
		File file = new File(path);
		String[] files = file.list();
		
		for (String str : files) {
			list.add(str);
		}
		request.setAttribute("file", list);
		try {
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
