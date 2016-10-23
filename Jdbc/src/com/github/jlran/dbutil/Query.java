package com.github.jlran.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import com.github.jlran.beans.User;
import com.github.jlran.meatadata.JDBCUtil;

public class Query {
	//查询， 自定义结果集封装数据
	Connection conn = null;
	@Test
	public void testQuery() throws Exception{
		//获取链接
		conn = JDBCUtil.getConnection();
		String sql = "select * from user where id=?";
		//创建DBUtils核心工具类
		QueryRunner runner = new QueryRunner();
		//查询
		User u = runner.query(conn, sql, new ResultSetHandler<User>(){
			
			//如何封装一个User对象
			@Override
			public User handle(ResultSet rs) throws SQLException {
				if(rs.next()){
					User user = new User();
					user.setId(rs.getString("id"));
					user.setUserName(rs.getString("userName"));
					user.setPwd(rs.getString("pwd"));
					return user;
				}
				return null;
			}
		},1);
		
		//测试
		System.out.println(u);
		conn.close();
	}
	
	
	//查询， 使用组件提供的结果集对象封装数据
	//1）BeanHandler: 查询返回单个对象
	@Test
	public void testQueryOne() throws Exception{
		String sql = "select * from user where id=?";
		//获取链接
		conn = JDBCUtil.getConnection();
		//创建DBUtils核心工具类对象
		QueryRunner runner = new QueryRunner();
		//查询返回单个对象
		User user= runner.query(conn, sql, new BeanHandler<User>(User.class), 1);
		System.out.println(user);
		conn.close();
	}
	
	// 2）BeanListHandler: 查询返回list集合，集合元素是指定的对象
	@Test
	public void testQueryList() throws Exception{
		String sql = "select * from user";
		conn = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		//查询全部数据
		List<User> list = qr.query(conn, sql, new BeanListHandler<User>(User.class));
		System.out.println(list);
		conn.close();
	}
	
	@Test
//	3) ArrayHandler, 查询返回结果记录的第一行，封装对对象数组, 即返回：Object[]
//	4) ArrayListHandler, 把查询的每一行都封装为对象数组，再添加到list集合中
//	5) ScalarHandler 查询返回结果记录的第一行的第一列  (在聚合函数统计的时候用)
//	6) MapHandler  查询返回结果的第一条记录封装为map
	public void testArray() throws Exception{
		String sql = "select * from user";
		conn  = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		//查询
		Map<String, Object> map = qr.query(conn, sql, new MapHandler());
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			 Map.Entry entry = (Map.Entry)it.next();           
		     String key=entry.getKey().toString();           
		     String value=entry.getValue().toString();           
		     System.out.println(key+"===="+value);   
		}
		conn.close();
	}
}
