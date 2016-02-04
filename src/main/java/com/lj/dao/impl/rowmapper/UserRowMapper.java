package com.lj.dao.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lj.beans.TbUser;

public class UserRowMapper implements RowMapper {

	public TbUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		TbUser tbUser = new TbUser();
		ResultSetMetaData metaData = rs.getMetaData();
		int colNum = metaData.getColumnCount();
		for (int i = 1; i <= colNum; i++) {
			String colName = metaData.getColumnName(i).toUpperCase();
			if ("UID".equals(colName)) {
				tbUser.setUid(rs.getInt("UID"));
			} else if ("USERNAME".equals(colName)) {
				tbUser.setUsername(rs.getString("USERNAME"));
			} else if ("PASSWD".equals(colName)) {
				tbUser.setPasswd(rs.getString("PASSWD"));
			} else if ("EMAIL".equals(colName)) {
				tbUser.setEmail(rs.getString("EMAIL"));
			} else if ("CREATETIME".equals(colName)) {
				tbUser.setCreatetime(rs.getLong("CREATETIME"));
			}
		}
		return tbUser;
	}

}
