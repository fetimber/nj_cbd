package com.fe.dao.impl;

import com.fe.bean.xml.UserInfo;

public interface IUserDAO {
	/** * 通过ID查询 * @param id * @return */
	public UserInfo findUserById(int id);

	/** * 通过ID删除 * @param id */
	public void deleteUserById(int id);

	/** * 增加 * @param id */
	public void addUser(UserInfo user);

	/** * 查询指定的User对象 * @param userinfo * @return */
	public UserInfo findUser(UserInfo user);

	
}
