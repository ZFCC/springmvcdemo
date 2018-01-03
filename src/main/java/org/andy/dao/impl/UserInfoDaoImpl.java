package org.andy.dao.impl;

import java.util.List;

import org.andy.dao.UserInfoDao;
import org.andy.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	//@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public UserInfo getById(Integer id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		UserInfo userInfo = jdbcTemplate.queryForObject(sql, new UserInfo(), new Object[] { id });

		return userInfo;
	}

	public List<UserInfo> findAll() {
		String sql = "SELECT * FROM user";
		List<UserInfo> userInfos = jdbcTemplate.query(sql, new UserInfo());
		return userInfos;
	}


	
	public Integer save(UserInfo entity) {
		String sql = "INSERT INTO user(name, password, create_time) VALUES(:name, :password, :create_time)";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", entity.getName());
		paramSource.addValue("password", entity.getPassword());
		paramSource.addValue("create_time", entity.getCreate_time());
		int result = namedParameterJdbcTemplate.update(sql, paramSource);
		return result;
	}

}
