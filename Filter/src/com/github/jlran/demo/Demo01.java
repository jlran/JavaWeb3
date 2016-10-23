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
		System.out.println("����������....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init....");
		
		//��ȡ��������web.xml�����õĳ�ʼ��������
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		while(enums.hasMoreElements()){
			//��ȡ����������
			String name = enums.nextElement();
			//��ȡ���ƶ�Ӧ��ֵ
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + " " + value);
		}
	}
	
	// ������ҵ�������� �����󵽴�servlet֮ǰ�Ƚ���˷��������õ�ҵ���߼�����
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter....");
		// �������һ����������������һ���������������ִ�з���servlet
		chain.doFilter(request, response);
		
		System.out.println("servlet������ɣ��ֻص�������...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy....");
	}
}
