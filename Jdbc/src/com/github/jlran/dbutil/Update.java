package com.github.jlran.dbutil;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.github.jlran.meatadata.JDBCUtil;

public class Update {
	private Connection conn;
	@Test
	public void testUpdate() throws Exception{
		String sql = "delete from user where id=?";
		//��ȡ����
		conn = JDBCUtil.getConnection();
		//����DBUtils���Ĺ��������
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, 1);
		JDBCUtil.close(conn, null, null);
	}
	
	//������
	@Test
	public void testBatch() throws Exception{
		String sql = "insert into user(id,userName, pwd) values (?,?,?)";
		//��ȡ����
		conn = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		//��������
		qr.batch(conn, sql, new Object[][]{ {"1","jlran","123"},{"2","joran","456"}  });
		//�ر�
		conn.close();
	}
}
