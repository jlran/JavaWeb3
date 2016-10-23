package com.github.jlran.beans;

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
	private Date birth;
	
	
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd
				+ ", birth=" + birth + "]";
	}
	public User(String id, String userName, String pwd, Date birth) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.birth = birth;
	}
	public User() {
		super();
	}
	
}
