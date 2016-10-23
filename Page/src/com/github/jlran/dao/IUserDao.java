package com.github.jlran.dao;

import com.github.jlran.entity.User;
import com.github.jlran.util.PageBean;

/**
 * 数据访问层，接口设计
 * @author jlran
 *
 */

public interface IUserDao {
	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<User> pb);
	/**
	 * 查询总记录数
	 */
	public int getTotalCount();
}
