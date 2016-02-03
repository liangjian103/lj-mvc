package com.lj.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lj.beans.UserBean;
import com.lj.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplateOracle;

	@Override
	public UserBean queryUserByUserNamePassword(String userName, String password) throws Exception {
		String sql = "SELECT U.USERID,U.USERNAME,U.PASSWORD FROM TB_API_AUTH_USER U WHERE U.USERNAME = ? AND U.PASSWORD = ? ";
		List<UserBean> userList = jdbcTemplateOracle.query(sql, new Object[] { userName, password }, new RowMapper<UserBean>() {
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean userBean = new UserBean();
				ResultSetMetaData metaData = rs.getMetaData();
				int colNum = metaData.getColumnCount();
				for (int i = 1; i <= colNum; i++) {
					String colName = metaData.getColumnName(i).toUpperCase();
					if ("USERID".equals(colName)) {
						userBean.setId(rs.getString("USERID"));
					} else if ("USERNAME".equals(colName)) {
						userBean.setUserName(rs.getString("USERNAME"));
					} else if ("PASSWORD".equals(colName)) {
						userBean.setPassword(rs.getString("PASSWORD"));
					}
				}
				return userBean;
			}
		});
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
	}

}
