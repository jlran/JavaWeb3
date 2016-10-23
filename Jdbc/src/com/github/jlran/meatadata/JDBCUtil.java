package com.github.jlran.meatadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	private static String URL = "jdbc:mysql://localhost:3306/user";
	private static String NAME = "root";
	private static String PASSWORD = "root";
	static Connection  conn = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public static void close(Connection con, Statement pstmt2, ResultSet resu){
		if(pstmt2 != null)
			try {
				pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		if(resu != null)
			try {
				resu.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}
}
