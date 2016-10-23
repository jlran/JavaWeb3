package com.github.jlran.demo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo01  implements Filter{
	
	public Demo01(){
		System.out.println("创建过滤器....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init....");
		
		//获取过滤器在web.xml中配置的初始化的名称
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		while(enums.hasMoreElements()){
			//获取参数的名称
			String name = enums.nextElement();
			//获取名称对应的值
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + " " + value);
		}
	}
	
	// 过滤器业务处理方法： 在请求到达servlet之前先进入此方法处理公用的业务逻辑操作
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter....");
		// 如果有下一个过滤器，进入下一个过滤器，否则就执行访问servlet
		chain.doFilter(request, response);
		
		System.out.println("servlet处理完成，又回到过滤器...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy....");
	}
}
