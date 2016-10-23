package com.github.jlran.a_life;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Demo02 implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}

}
