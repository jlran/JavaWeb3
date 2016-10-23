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
	//��ѯ�� �Զ���������װ����
	Connection conn = null;
	@Test
	public void testQuery() throws Exception{
		//��ȡ����
		conn = JDBCUtil.getConnection();
		String sql = "select * from user where id=?";
		//����DBUtils���Ĺ�����
		QueryRunner runner = new QueryRunner();
		//��ѯ
		User u = runner.query(conn, sql, new ResultSetHandler<User>(){
			
			//��η�װһ��User����
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
		
		//����
		System.out.println(u);
		conn.close();
	}
	
	
	//��ѯ�� ʹ������ṩ�Ľ���������װ����
	//1��BeanHandler: ��ѯ���ص�������
	@Test
	public void testQueryOne() throws Exception{
		String sql = "select * from user where id=?";
		//��ȡ����
		conn = JDBCUtil.getConnection();
		//����DBUtils���Ĺ��������
		QueryRunner runner = new QueryRunner();
		//��ѯ���ص�������
		User user= runner.query(conn, sql, new BeanHandler<User>(User.class), 1);
		System.out.println(user);
		conn.close();
	}
	
	// 2��BeanListHandler: ��ѯ����list���ϣ�����Ԫ����ָ���Ķ���
	@Test
	public void testQueryList() throws Exception{
		String sql = "select * from user";
		conn = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		//��ѯȫ������
		List<User> list = qr.query(conn, sql, new BeanListHandler<User>(User.class));
		System.out.println(list);
		conn.close();
	}
	
	@Test
//	3) ArrayHandler, ��ѯ���ؽ����¼�ĵ�һ�У���װ�Զ�������, �����أ�Object[]
//	4) ArrayListHandler, �Ѳ�ѯ��ÿһ�ж���װΪ�������飬����ӵ�list������
//	5) ScalarHandler ��ѯ���ؽ����¼�ĵ�һ�еĵ�һ��  (�ھۺϺ���ͳ�Ƶ�ʱ����)
//	6) MapHandler  ��ѯ���ؽ���ĵ�һ����¼��װΪmap
	public void testArray() throws Exception{
		String sql = "select * from user";
		conn  = JDBCUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		//��ѯ
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
