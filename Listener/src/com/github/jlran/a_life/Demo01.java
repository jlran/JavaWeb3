package com.github.jlran.a_life;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听request对象的创建或销毁
 * @author jlran
 *
 */
public class Demo01 implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(" requestDestroyed ....");
		String name = (String) sre.getServletRequest().getAttribute("jlran");
		System.out.println(name);
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(" requestInitialized ....");
	}
}
