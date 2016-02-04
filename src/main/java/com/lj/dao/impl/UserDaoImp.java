package com.lj.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lj.beans.TbUser;
import com.lj.dao.UserDao;
import com.lj.dao.impl.rowmapper.UserRowMapper;
import com.lj.statement.LoadSql;

@Repository
public class UserDaoImp implements UserDao {

	protected static Logger logger = Logger.getLogger(UserDaoImp.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertTbUser(TbUser tbUser) throws Exception {
		String sql = LoadSql.insertTbUser;
		try {
			Object[] obj = new Object[] { tbUser.getUsername(), tbUser.getPasswd(), tbUser.getEmail(), tbUser.getCreatetime() };
			jdbcTemplate.update(sql, obj);
		} catch (Exception e) {
			logger.error("insertTbUser() sql:" + sql, e);
			throw new Exception(e);
		}
	}

	@Override
	public TbUser selectTbUserByUserName(String userName) {
		String sql = LoadSql.selectTbUserByUserName;
		try {
			List<TbUser> list = jdbcTemplate.query(sql, new Object[] { userName }, new UserRowMapper());
			if (list != null && list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("queryUserByUserNamePassword() sql:" + sql, e);
			return null;
		}
	}

}
