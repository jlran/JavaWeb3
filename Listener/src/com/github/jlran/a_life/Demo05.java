package com.github.jlran.a_life;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * 监听此对象绑定到session上的过程，需要实现session特定接口
 * @author jlran
 *
 */
public class Demo05 implements HttpSessionBindingListener{

	private String name;
	private String pwd;
	
	public Demo05(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Demo05() {
		super();
	}

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Demo05对象已经放入session！");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Demo05对象从session中移除！");
	}

}
