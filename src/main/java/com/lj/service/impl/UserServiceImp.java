package com.lj.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.beans.Result;
import com.lj.beans.TbUser;
import com.lj.dao.UserDao;
import com.lj.service.UserService;
import com.lj.utils.MD5;

@Service
public class UserServiceImp implements UserService {

	protected static Logger logger = Logger.getLogger(UserServiceImp.class);

	@Autowired
	UserDao userDao;

	@Override
	public Result regUser(TbUser tbUser) throws Exception {
		try {
			TbUser u = userDao.selectTbUserByUserName(tbUser.getUsername());
			if (null != u) {
				return new Result(1, "用户已被占用");
			} else {
				// MD5加密
				tbUser.setPasswd(MD5.getMD5(tbUser.getPasswd()));
				tbUser.setCreatetime(System.currentTimeMillis());
				userDao.insertTbUser(tbUser);
				return new Result(0, "注册成功");
			}
		} catch (Exception e) {
			logger.error("UserServiceImp.regUser ERROR!", e);
			throw new Exception(e);
		}
	}

	@Override
	public Result loginCheck(String username, String passwd) throws Exception {
		TbUser tbUser = null;
		try {
			tbUser = userDao.selectTbUserByUserName(username);
		} catch (Exception e) {
			throw new Exception("系统异常,用户名：" + username, e);
		}
		if (null == tbUser) {
			return new Result(1, "用户名或密码不正确");//该用户不存在
		} else if (MD5.getMD5(passwd).equals(tbUser.getPasswd())) {
			Result rs = new Result(0, "登录成功");
			rs.setObj(tbUser);
			return rs;
		} else {
			return new Result(1, "用户名或密码不正确");
		}
	}
}
