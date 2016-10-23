package com.github.jlran.a_life;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class Demo04 implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("---------------------attributeAdded");
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("---------------------attributeRemoved");
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("---------------------attributeReplaced");
	}
}
