package com.github.jlran.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0 {
	
	//硬编码方式，使用C3P0连接池管理连接
	@Test
	public void testCode() throws Exception{
		//创建连接池核心工具类
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// 设置连接参数：url、驱动、用户密码、初始连接数、最大连接数
		dataSource.setJdbcUrl("jdbc:mysql:///user");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		dataSource.setMaxIdleTime(1000);
		
		//获取链接对象
		Connection conn = dataSource.getConnection();
		conn.prepareStatement("select * from user").executeQuery();
		conn.close();
	}
	
	//XML配置方式，使用C3P0连接池管理连接
	@Test
	public void testXML() throws Exception{
		//自动加载src下c3p0的配置文件【c3p0-config.xml】 使用默认的配置
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		ResultSet rs = conn.prepareStatement("select * from user").executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("id"));
		}
		conn.close();
	}

}
