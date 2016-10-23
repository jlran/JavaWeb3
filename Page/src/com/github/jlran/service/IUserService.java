package com.github.jlran.service;

import com.github.jlran.entity.User;
import com.github.jlran.util.PageBean;

/**
 * 业务逻辑层接口设计
 * @author jlran
 *
 */

public interface IUserService {
	/**
	 * 分页查询数据
	 */
	public void getAll(PageBean<User> pb);
}
