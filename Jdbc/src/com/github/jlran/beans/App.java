package com.github.jlran.beans;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

/**
 * Javabean�Ļ�������
 * @author jlran
 *
 */

public class App {
	//��Javabean�Ļ�������
	@Test
	public void test01() throws Exception{
		//��������
		User user = new User();
//		user.setUserName("jlran");
//		user.setPwd("123456");
//		System.out.println(user);
		
		//beanUtils���ʵ�ֶ������ԵĿ��� ���ڻ����������ͣ����Զ���������ת��
		BeanUtils.copyProperty(user, "userName", "joran");
		BeanUtils.setProperty(user, "pwd", "456789");
		System.out.println(user);
		
		//����Ŀ���
		User newUser = new User();
		//ִ�е����� �����  ��Ϊdata  ��Ҫע���������͵�ת����  Ȼ����ʹ��
		//ʹ���ṩ����������ת����������
		// ע����������ת������ ʹ������ṩ��ת����������
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		BeanUtils.copyProperties(newUser,user);
		System.out.println(newUser);
		
		
	}
}
