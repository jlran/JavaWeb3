package com.github.jlran.meatadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

/**
 * 元数据
 * @author jlran
 *
 */
public class App {
	//数据库元数据
	@Test
	public void test01() throws Exception {
		//获取链接
		Connection conn = JDBCUtil.getConnection();
		//获取数据库元数据
		DatabaseMetaData metaData = conn.getMetaData();
		
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getURL());
		System.out.println(metaData.getDatabaseProductVersion());
		System.out.println(metaData.getDatabaseProductName());
		JDBCUtil.close(conn, null, null);
	}	
	
	//参数元数据
	@Test
	public void testParams() throws Exception {
		//获取链接
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from user where id=? and userName=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//获取元数据
		ParameterMetaData metaData = pstmt.getParameterMetaData();
		//获取参数的个数
		int count = metaData.getParameterCount();
		System.out.println(count);
		JDBCUtil.close(conn, null, null);
	}
	
	//结果集元数据
	@Test
	public void testRs() throws Exception{
		//获取链接
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//得到结果集元数据（目标：通过结果集元数据，得到列的名称）
		ResultSetMetaData metaData = rs.getMetaData();
		//迭代出每一行的结果
		while(rs.next()){
			//获取列的个数
			int count = metaData.getColumnCount();
			//遍历，获取每一列的名称
			for(int i = 0; i < count; i++){
				//得到列的名称
				String name = metaData.getColumnName(i + 1);
				//获取每一行的每一列的值
				Object value = rs.getObject(name);
				System.out.print(name + " -> " + value + " ");
			}
			System.out.println();
		}
	}
}
