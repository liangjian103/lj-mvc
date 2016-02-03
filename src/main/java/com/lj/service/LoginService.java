package com.lj.service;

/**
 * 登录业务
 * 
 * @author james
 * 
 */
public interface LoginService {

	/** 用户验证 */
	boolean lonin(String loginName, String password) throws Exception;
}
