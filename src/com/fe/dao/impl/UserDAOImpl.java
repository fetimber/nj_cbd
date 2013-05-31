package com.fe.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fe.base.BaseDAO;
import com.fe.bean.UserInfo;
import com.fe.dao.IUserDAO;

@Component("userDao")
public class UserDAOImpl extends BaseDAO implements IUserDAO {

	public void addUser(UserInfo user) {
	    try 
		{
		  getSqlMapClient().insert("insertInfo", user);
		} 
		catch (SQLException e) 
		{
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub

	}

	public UserInfo findUser(UserInfo user) {
		List<UserInfo> rs = (List<UserInfo>) getSqlMapClientTemplate()
				.queryForList("selectUserInfoByName", user);
		if (rs.size() > 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public UserInfo findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
