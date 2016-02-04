package com.lj.dao;

import com.lj.beans.TbUser;


/**
 * 用户操作类
 * 
 * @author James
 * 
 */
public interface UserDao {

	/** 查询用户信息 */
	TbUser selectTbUserByUserName(String username);
	
	/** 插入用户 */
	void insertTbUser(TbUser tbUser) throws Exception;

}
