package org.andy.service;

import java.util.List;

import org.andy.entity.UserInfo;

public interface UserInfoService {
	// 通过Id查询UserInfo  
    UserInfo getById(Integer id);  
  
    // 查询全部的UserInfo  
    List<UserInfo> findAll();  
  
    // 添加UserInfo  
    Integer save(UserInfo userInfo);  
}
