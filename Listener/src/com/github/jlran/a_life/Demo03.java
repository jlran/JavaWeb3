package com.github.jlran.a_life;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Demo03 implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated");
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
		String o = (String) se.getSession().getAttribute("jlran");
		System.out.println(o);
	}

}
