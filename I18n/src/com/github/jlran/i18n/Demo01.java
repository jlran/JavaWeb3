package com.github.jlran.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class Demo01 {
	//静态
	@Test
	public void testDemo01(){
		//模拟环境
		Locale locale = Locale.CHINA;
		// 创建工具类对象ResourceBundle
		ResourceBundle bundle = ResourceBundle.getBundle("com.github.jlran.i18n.msg", locale);
		System.out.println(bundle.getString("hello"));
		System.out.println(bundle.getString("userName"));
		System.out.println(bundle.getString("pwd"));
	}
	
	//动态
	@Test
	public void testDemo02() throws Exception{
		// 国际化 - 动态文本 - 0. 概述
		// 国际化货币
		NumberFormat.getCurrencyInstance();
		// 国际化数字
		NumberFormat.getNumberInstance();
		// 国际化百分比
		NumberFormat.getPercentInstance();  
		// 国际化日期
		//DateFormat.getDateTimeInstance(dateStyle, timeStyle, aLocale)
		
		//模拟坏境
		Locale locale = Locale.US;
		//国际化货币
		double number = 100;
		//工具类
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		//国际化货币
		String format = nf.format(number);
		System.out.println(format);
		
		
		//  代码计算：  $100 * 10  
		String str = "$100";
		int num = 10;
		Number parse = nf.parse(str);
		System.out.println(parse.intValue() * num);
		
		
		//国际化 - 动态文本 - 2. 国际化数值
		str = nf.format(100000000);
		System.out.println(str);
		
		// 国际化 - 动态文本 - 3. 国际化日期
		/*
		 * 日期
		 * 	  FULL   2015年3月4日 星期三
		 * 	  LONG   2015年3月4日
		 * 	  FULL   2015年3月4日 星期三
		 *    MEDIUM 2015-3-4
		 *    SHORT  15-3-4
		 *    
		 * 时间
		 * 	  FULL   下午04时31分59秒 CST
		 * 	  LONG   下午04时32分37秒
		 *    MEDIUM 16:33:00
		 *    SHORT  下午4:33
		 */
		
		//日期格式
		int dateStyle = DateFormat.SHORT;
		//时间格式
		int timeStyle = DateFormat.SHORT;
		//工具类
		DateFormat df = DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
		String date = df.format(new Date());
		System.out.println(date);
		
	}
}
