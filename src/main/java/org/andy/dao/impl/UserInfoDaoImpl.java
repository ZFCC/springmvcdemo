package org.andy.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.andy.dao.UserInfoDao;
import org.andy.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
	
	public Integer delete(Integer id){
		String sql = "delete from user where id = ?";
		int result = jdbcTemplate.update(sql, new Object[]{id});
		return result;
		
	}
//批量增加
	public int[] batchSave(List<UserInfo> users) {
		final List<UserInfo> user = users;
		try{
			String sql = "INSERT INTO user(name, password, create_time) VALUES(?, ?, ?)";
			
			BatchPreparedStatementSetter pssInsert = new BatchPreparedStatementSetter() { 
				public int getBatchSize() {
					return user.size();
				}
				public void setValues(PreparedStatement ps, int i) throws SQLException {  
					String name = user.get(i).getName();
					String password = user.get(i).getPassword();
					Date date = user.get(i).getCreate_time();
					
					ps.setString(1, name);
					ps.setString(2, password);
					ps.setDate(3, new java.sql.Date(date.getTime()));//日期转换
				}
			};
			int[] result = jdbcTemplate.batchUpdate(sql, pssInsert);
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
//根据id批量删除
	public int[] batchDelete(List<Integer> id) {
		final List<Integer> ids = id;
		String sql = "delete from user where id = ?";
		BatchPreparedStatementSetter pssDelete = new BatchPreparedStatementSetter() { 
			public int getBatchSize() {
				return ids.size();
			}

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				int s = ids.get(i).intValue();
				ps.setInt(1, s);
			}
		};
		int[] result = jdbcTemplate.batchUpdate(sql, pssDelete);
		return result;
	}

	public int updateById(UserInfo entity){
		String sql = "update  user set name=?, password=? where id = ?";
		//带参数的更新
		int result = jdbcTemplate.update(sql, new Object[]{entity.getName(),entity.getPassword(),entity.getId()});
		return result;
	}

}
