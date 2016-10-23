package com.github.jlran.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0 {
	
	//Ӳ���뷽ʽ��ʹ��C3P0���ӳع�������
	@Test
	public void testCode() throws Exception{
		//�������ӳغ��Ĺ�����
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// �������Ӳ�����url���������û����롢��ʼ�����������������
		dataSource.setJdbcUrl("jdbc:mysql:///user");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		dataSource.setMaxIdleTime(1000);
		
		//��ȡ���Ӷ���
		Connection conn = dataSource.getConnection();
		conn.prepareStatement("select * from user").executeQuery();
		conn.close();
	}
	
	//XML���÷�ʽ��ʹ��C3P0���ӳع�������
	@Test
	public void testXML() throws Exception{
		//�Զ�����src��c3p0�������ļ���c3p0-config.xml�� ʹ��Ĭ�ϵ�����
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		ResultSet rs = conn.prepareStatement("select * from user").executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("id"));
		}
		conn.close();
	}

}
