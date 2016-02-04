package com.lj.service;

import com.lj.beans.Result;
import com.lj.beans.TbUser;

public interface UserService {

	/** 用户注册 */
	Result regUser(TbUser tbUser) throws Exception;

	/** 用户登录验证 */
	Result loginCheck(String username, String passwd) throws Exception;

}
