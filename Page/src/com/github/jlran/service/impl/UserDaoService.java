package com.github.jlran.service.impl;

import com.github.jlran.dao.IUserDao;
import com.github.jlran.dao.impl.UserDao;
import com.github.jlran.entity.User;
import com.github.jlran.service.IUserService;
import com.github.jlran.util.PageBean;

/**
 * 业务逻辑层的实现
 * @author jlran
 *
 */

public class UserDaoService implements IUserService{
	private IUserDao iUserDao = new UserDao();

	public void getAll(PageBean<User> pb) {
		iUserDao.getAll(pb);
	}
}
