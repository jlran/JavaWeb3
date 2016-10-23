package com.github.jlran.a_life;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * �����˶���󶨵�session�ϵĹ��̣���Ҫʵ��session�ض��ӿ�
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
		System.out.println("Demo05�����Ѿ�����session��");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Demo05�����session���Ƴ���");
	}

}
