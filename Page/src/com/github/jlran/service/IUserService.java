package com.github.jlran.service;

import com.github.jlran.entity.User;
import com.github.jlran.util.PageBean;

/**
 * ҵ���߼���ӿ����
 * @author jlran
 *
 */

public interface IUserService {
	/**
	 * ��ҳ��ѯ����
	 */
	public void getAll(PageBean<User> pb);
}
