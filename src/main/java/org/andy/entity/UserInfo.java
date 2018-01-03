package org.andy.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class UserInfo implements RowMapper<UserInfo>, Serializable {

	private static final long serialVersionUID = -8823504831198719837L;  
	  
    private Integer id;  
  
    private String name;  
  
    private String password;  
  
    private Date create_time;
	
	
    
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Date getCreate_time() {
		return create_time;
	}



	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public UserInfo mapRow(ResultSet rs, int roeNum) throws SQLException {
		 UserInfo userInfo = new UserInfo();  
	        userInfo.setId(rs.getInt("id"));  
	        userInfo.setName(rs.getString("name"));  
	        userInfo.setPassword(rs.getString("password"));  
	        userInfo.setCreate_time(rs.getDate("create_time"));  
	        return userInfo;  
	}

}
