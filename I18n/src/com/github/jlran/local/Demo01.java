package com.github.jlran.local;



import java.util.Locale;

import org.junit.Test;

public class Demo01 {
	@Test
	public void testLocal(){
		//本地化对象：Local 封装语言、国家信息的对象，由java.util提供
		Locale locale = Locale.getDefault();
		System.out.println(locale.getCountry());
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		System.out.println("************************");
		//模拟美国国家
		Locale us = Locale.US;
		System.out.println(us.getCountry());
		System.out.println(us.getDisplayCountry());
		System.out.println(us.getLanguage());
	}
}
