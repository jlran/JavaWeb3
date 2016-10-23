package com.github.jlran.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ������ ��ر�
 * @author jlran
 *
 */
public class JDBCUtil {
	
	private static ComboPooledDataSource dataSource = null;
	//��ʼ��C3P0���ӳ�
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static Connection getConnection(){
		
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//����DbUtils���Ĺ��������
	// ����QueryRunner���󣬴������ӳض���
	// �ڴ���QueryRunner�����ʱ���������������Դ����
	// ��ô��ʹ��QueryRunner���󷽷���ʱ�򣬾Ͳ���Ҫ�������Ӷ���
	// ���Զ�������Դ�л�ȡ����(���ùر�����)
	public static QueryRunner  getQueryRunner(){
		QueryRunner qr = new QueryRunner(dataSource);
		return qr;
	}
}
