package com.github.jlran.local;



import java.util.Locale;

import org.junit.Test;

public class Demo01 {
	@Test
	public void testLocal(){
		//���ػ�����Local ��װ���ԡ�������Ϣ�Ķ�����java.util�ṩ
		Locale locale = Locale.getDefault();
		System.out.println(locale.getCountry());
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		System.out.println("************************");
		//ģ����������
		Locale us = Locale.US;
		System.out.println(us.getCountry());
		System.out.println(us.getDisplayCountry());
		System.out.println(us.getLanguage());
	}
}
