package com.github.jlran.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class Demo01 {
	//��̬
	@Test
	public void testDemo01(){
		//ģ�⻷��
		Locale locale = Locale.CHINA;
		// �������������ResourceBundle
		ResourceBundle bundle = ResourceBundle.getBundle("com.github.jlran.i18n.msg", locale);
		System.out.println(bundle.getString("hello"));
		System.out.println(bundle.getString("userName"));
		System.out.println(bundle.getString("pwd"));
	}
	
	//��̬
	@Test
	public void testDemo02() throws Exception{
		// ���ʻ� - ��̬�ı� - 0. ����
		// ���ʻ�����
		NumberFormat.getCurrencyInstance();
		// ���ʻ�����
		NumberFormat.getNumberInstance();
		// ���ʻ��ٷֱ�
		NumberFormat.getPercentInstance();  
		// ���ʻ�����
		//DateFormat.getDateTimeInstance(dateStyle, timeStyle, aLocale)
		
		//ģ�⻵��
		Locale locale = Locale.US;
		//���ʻ�����
		double number = 100;
		//������
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		//���ʻ�����
		String format = nf.format(number);
		System.out.println(format);
		
		
		//  ������㣺  $100 * 10  
		String str = "$100";
		int num = 10;
		Number parse = nf.parse(str);
		System.out.println(parse.intValue() * num);
		
		
		//���ʻ� - ��̬�ı� - 2. ���ʻ���ֵ
		str = nf.format(100000000);
		System.out.println(str);
		
		// ���ʻ� - ��̬�ı� - 3. ���ʻ�����
		/*
		 * ����
		 * 	  FULL   2015��3��4�� ������
		 * 	  LONG   2015��3��4��
		 * 	  FULL   2015��3��4�� ������
		 *    MEDIUM 2015-3-4
		 *    SHORT  15-3-4
		 *    
		 * ʱ��
		 * 	  FULL   ����04ʱ31��59�� CST
		 * 	  LONG   ����04ʱ32��37��
		 *    MEDIUM 16:33:00
		 *    SHORT  ����4:33
		 */
		
		//���ڸ�ʽ
		int dateStyle = DateFormat.SHORT;
		//ʱ���ʽ
		int timeStyle = DateFormat.SHORT;
		//������
		DateFormat df = DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
		String date = df.format(new Date());
		System.out.println(date);
		
	}
}
