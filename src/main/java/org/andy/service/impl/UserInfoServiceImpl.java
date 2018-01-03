package org.andy.service.impl;

import java.util.List;

import org.andy.dao.UserInfoDao;
import org.andy.entity.UserInfo;
import org.andy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userInfoService")  
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;  
	
	public UserInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return userInfoDao.getById(id);  
	}

	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userInfoDao.findAll();
	}

	public Integer save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.save(userInfo);
	}

}
