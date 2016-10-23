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
	//硬编码方式实现连接池
	@Test
	public void testDbcp() throws Exception{
		//DBCP连接池核心类
		BasicDataSource dataSource = new BasicDataSource();
		//连接池参数配置：初始化连接数 最大连接数/ 链接字符串 驱动 用户 密码
		dataSource.setUrl("jdbc:mysql:///user");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");	//用户
		dataSource.setPassword("root");	//密码
		dataSource.setInitialSize(3);	//初始化连接池
		dataSource.setMaxActive(6);		//最大连接
		dataSource.setMinIdle(3000);	//最大空闲时间
		//获得链接
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from user");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("userName"));
		}
		conn.close();
	}
	
	//【推荐】配置方式实现连接池  ,  便于维护
	@Test
	public void testProp() throws Exception{
		//加载配置的prop配置文件
		Properties prop = new Properties();
		//获取文件流
		InputStream in = Dbcp.class.getResourceAsStream("db.properties");
		//加载属性配置文件
		prop.load(in);
		//根据prop配置，直接创建数据源对象
		DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
		//获取链接
		Connection conn = dataSource.getConnection();
		ResultSet rs = conn.prepareStatement("select * from user").executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("id"));
		}
		conn.close();
		
	}
}
