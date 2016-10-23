package com.github.jlran.meatadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

/**
 * Ԫ����
 * @author jlran
 *
 */
public class App {
	//���ݿ�Ԫ����
	@Test
	public void test01() throws Exception {
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();
		//��ȡ���ݿ�Ԫ����
		DatabaseMetaData metaData = conn.getMetaData();
		
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getURL());
		System.out.println(metaData.getDatabaseProductVersion());
		System.out.println(metaData.getDatabaseProductName());
		JDBCUtil.close(conn, null, null);
	}	
	
	//����Ԫ����
	@Test
	public void testParams() throws Exception {
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from user where id=? and userName=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//��ȡԪ����
		ParameterMetaData metaData = pstmt.getParameterMetaData();
		//��ȡ�����ĸ���
		int count = metaData.getParameterCount();
		System.out.println(count);
		JDBCUtil.close(conn, null, null);
	}
	
	//�����Ԫ����
	@Test
	public void testRs() throws Exception{
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//�õ������Ԫ���ݣ�Ŀ�꣺ͨ�������Ԫ���ݣ��õ��е����ƣ�
		ResultSetMetaData metaData = rs.getMetaData();
		//������ÿһ�еĽ��
		while(rs.next()){
			//��ȡ�еĸ���
			int count = metaData.getColumnCount();
			//��������ȡÿһ�е�����
			for(int i = 0; i < count; i++){
				//�õ��е�����
				String name = metaData.getColumnName(i + 1);
				//��ȡÿһ�е�ÿһ�е�ֵ
				Object value = rs.getObject(name);
				System.out.print(name + " -> " + value + " ");
			}
			System.out.println();
		}
	}
}
