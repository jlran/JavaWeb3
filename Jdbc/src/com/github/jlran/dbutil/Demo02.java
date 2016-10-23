package com.github.jlran.dbutil;

import com.github.jlran.beans.User;

public class Demo02<T>{
	public Demo02(Class clazz){
		
	}
	
	public static void main(String[] args) {
		Demo02<User> demo02 = new Demo02<User>(User.class);
	}
}
