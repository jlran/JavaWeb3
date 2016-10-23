package com.github.jlran.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库的链接 与关闭
 * @author jlran
 *
 */
public class JDBCUtil {
	
	private static ComboPooledDataSource dataSource = null;
	//初始化C3P0连接池
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
	
	//创建DbUtils核心工具类对象
	// 创建QueryRunner对象，传入连接池对象
	// 在创建QueryRunner对象的时候，如果传入了数据源对象；
	// 那么在使用QueryRunner对象方法的时候，就不需要传入连接对象；
	// 会自动从数据源中获取连接(不用关闭连接)
	public static QueryRunner  getQueryRunner(){
		QueryRunner qr = new QueryRunner(dataSource);
		return qr;
	}
}
