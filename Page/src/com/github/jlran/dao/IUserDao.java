package com.github.jlran.dao;

import com.github.jlran.entity.User;
import com.github.jlran.util.PageBean;

/**
 * ���ݷ��ʲ㣬�ӿ����
 * @author jlran
 *
 */

public interface IUserDao {
	/**
	 * ��ҳ��ѯ����
	 */
	public void getAll(PageBean<User> pb);
	/**
	 * ��ѯ�ܼ�¼��
	 */
	public int getTotalCount();
}
