package org.andy.service.impl;

import java.util.List;

import org.andy.dao.UserInfoDao;
import org.andy.entity.UserInfo;
import org.andy.service.UserInfoService;
import org.andy.service.utils.ResultComm;
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

	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userInfoDao.delete(id);
	}

	public int[] batchSave(List<UserInfo> users) {
		// TODO Auto-generated method stub
		return userInfoDao.batchSave(users);
	}

	public int[] batchDelete(List<Integer> id) {
		// TODO Auto-generated method stub
		return userInfoDao.batchDelete(id);
	}

	public ResultComm updateById(UserInfo userInfo) {
		/*String str = null;
		if(userInfo != null){
			if(userInfo.getName() == null ){
				//return new Exception().fillInStackTrace();
				
			}else if(userInfo.getPassword()== null){
				return "传入密码为空";
			}else if(userInfo.getId()== null){*/
		ResultComm rc = new ResultComm();
		
				int result = userInfoDao.updateById(userInfo);
				String str = String.valueOf(result);
				rc.setCount(result);
				rc.setStr(str);
				rc.setSuccess(true);
			//}
		//}
		
		// TODO Auto-generated method stub
		return rc;
	}

	
}
