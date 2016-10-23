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
		//获取连接
		conn = JDBCUtil.getConnection();
		//创建DBUtils核心工具类对象
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, 1);
		JDBCUtil.close(conn, null, null);
	}
	
	//批处理
	@Test
	public void testBatch() throws Exception{
		String sql = "insert into user(id,userName, pwd) values (?,?,?)";
		//获取链接
		conn = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		//批量插入
		qr.batch(conn, sql, new Object[][]{ {"1","jlran","123"},{"2","joran","456"}  });
		//关闭
		conn.close();
	}
}
