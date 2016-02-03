package com.lj.dao;

import com.lj.beans.UserBean;


/**
 * 用户操作类
 * 
 * @author James
 * 
 */
public interface UserDao {

	/** 查询用户信息 */
	UserBean queryUserByUserNamePassword(String userName, String password) throws Exception;
}
