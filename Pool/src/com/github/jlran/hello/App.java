package com.github.jlran.hello;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class App {
	@Test
	public void testUpdate() throws Exception{
		String sql = "delete from user where id=1";
		//获取链接
		Connection conn = JdbcUtil.getConnection();
		//创建核心工具类
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql);
		conn.close();
	}
	
	@Test
	public void testQuery() throws Exception{
		String sql = "select * from user";
		//获取链接
		Connection conn = JdbcUtil.getConnection();
		//创建核心工具类
		QueryRunner qr = new QueryRunner();
		List<User> list = qr.query(conn, sql, new BeanListHandler<User>(User.class));
		System.out.println(list);
		conn.close();
	}
}
