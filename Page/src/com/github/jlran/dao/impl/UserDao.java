package com.github.jlran.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.github.jlran.dao.IUserDao;
import com.github.jlran.entity.User;
import com.github.jlran.util.JDBCUtil;
import com.github.jlran.util.PageBean;
import com.mysql.jdbc.JDBC4CallableStatement;

/**
 * ���ݷ��ʲ�ʵ��
 * @author jlran
 *
 */

public class UserDao implements IUserDao {

	public void getAll(PageBean<User> pb) {
		//��ѯ�ܼ�¼�������õ�pb������
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if(pb.getCurrentPage() <= 0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		//��ȡ��ǰҳ
		int currentPage = pb.getCurrentPage();
		int index = (currentPage - 1) * pb.getPageCount();
		int count = pb.getPageCount();
		
		//��ҳ��ѯ���ݣ��Ѳ�ѯ�������ݴ����pb������
		String sql = "select * from user limit ?,?";
		
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			List<User> list = qr.query(sql, new BeanListHandler<User>(User.class), index, count);
			pb.setPageDate(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int getTotalCount() {
		String sql = "select count(*) from user";
		QueryRunner qr = JDBCUtil.getQueryRunner();
		try {
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
