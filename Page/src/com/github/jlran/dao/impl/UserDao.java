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
 * 数据访问层实现
 * @author jlran
 *
 */

public class UserDao implements IUserDao {

	public void getAll(PageBean<User> pb) {
		//查询总记录数；设置到pb对象中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		/*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
		// 判断
		if(pb.getCurrentPage() <= 0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		//获取当前页
		int currentPage = pb.getCurrentPage();
		int index = (currentPage - 1) * pb.getPageCount();
		int count = pb.getPageCount();
		
		//分页查询数据，把查询到的数据存放在pb对象中
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
