package com.lj.statement;

import com.lj.utils.PropertiesUtil;

public class LoadSql {

	static String sqlFile = "sql.properties";
	
	//插入用户表
	public static String insertTbUser = PropertiesUtil.PROPERTIES.readResource(sqlFile, "insertTbUser");
	//按用户名查询
	public static String selectTbUserByUserName = PropertiesUtil.PROPERTIES.readResource(sqlFile, "selectTbUserByUserName"); 
	
	//#保存留言
	public static String saveMessage = PropertiesUtil.PROPERTIES.readResource(sqlFile, "saveMessage"); 
	//#查询所有留言
	public static String queryMessageAll = PropertiesUtil.PROPERTIES.readResource(sqlFile, "queryMessageAll"); 
	//#查询某用户发布的留言
	public static String queryMessageByUserId = PropertiesUtil.PROPERTIES.readResource(sqlFile, "queryMessageByUserId"); 
	//#删除某用户留言
	public static String deleteMessageByUserId = PropertiesUtil.PROPERTIES.readResource(sqlFile, "deleteMessageByUserId");
	
}
