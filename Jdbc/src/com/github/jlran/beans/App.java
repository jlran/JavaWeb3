package com.github.jlran.beans;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

/**
 * Javabean的基本操作
 * @author jlran
 *
 */

public class App {
	//对Javabean的基本操作
	@Test
	public void test01() throws Exception{
		//基本操作
		User user = new User();
//		user.setUserName("jlran");
//		user.setPwd("123456");
//		System.out.println(user);
		
		//beanUtils组件实现对象属性的拷贝 对于基本数据类型，会自动进行类型转换
		BeanUtils.copyProperty(user, "userName", "joran");
		BeanUtils.setProperty(user, "pwd", "456789");
		System.out.println(user);
		
		//对象的拷贝
		User newUser = new User();
		//执行到这里 会出错  因为data  先要注册日期类型的转换器  然后再使用
		//使用提供的日期类型转换器工具类
		// 注册日期类型转换器： 使用组件提供的转换器工具类
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		BeanUtils.copyProperties(newUser,user);
		System.out.println(newUser);
		
		
	}
}
