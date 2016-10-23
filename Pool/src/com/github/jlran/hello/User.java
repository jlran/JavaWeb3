package com.github.jlran.hello;

import java.util.Date;

/**
 * 实体类设计
 * @author jlran
 *
 */
public class User {
	private String id;
	private String userName;
	private String pwd;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd
				+ "]";
	}
	public User(String id, String userName, String pwd, Date birth) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
	}
	public User() {
		super();
	}
	
}
