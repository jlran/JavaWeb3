package com.github.jlran.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class Dbcp {
	//Ӳ���뷽ʽʵ�����ӳ�
	@Test
	public void testDbcp() throws Exception{
		//DBCP���ӳغ�����
		BasicDataSource dataSource = new BasicDataSource();
		//���ӳز������ã���ʼ�������� ���������/ �����ַ��� ���� �û� ����
		dataSource.setUrl("jdbc:mysql:///user");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");	//�û�
		dataSource.setPassword("root");	//����
		dataSource.setInitialSize(3);	//��ʼ�����ӳ�
		dataSource.setMaxActive(6);		//�������
		dataSource.setMinIdle(3000);	//������ʱ��
		//�������
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from user");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("userName"));
		}
		conn.close();
	}
	
	//���Ƽ������÷�ʽʵ�����ӳ�  ,  ����ά��
	@Test
	public void testProp() throws Exception{
		//�������õ�prop�����ļ�
		Properties prop = new Properties();
		//��ȡ�ļ���
		InputStream in = Dbcp.class.getResourceAsStream("db.properties");
		//�������������ļ�
		prop.load(in);
		//����prop���ã�ֱ�Ӵ�������Դ����
		DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
		//��ȡ����
		Connection conn = dataSource.getConnection();
		ResultSet rs = conn.prepareStatement("select * from user").executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("id"));
		}
		conn.close();
		
	}
}
