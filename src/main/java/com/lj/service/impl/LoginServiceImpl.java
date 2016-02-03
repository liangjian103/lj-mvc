package com.lj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.beans.UserBean;
import com.lj.dao.UserDao;
import com.lj.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean lonin(String loginName, String password) throws Exception {
		UserBean userBean = userDao.queryUserByUserNamePassword(loginName, password);
		if(userBean==null){
			return false;
		}else{
			return true;
		}
	}

}
