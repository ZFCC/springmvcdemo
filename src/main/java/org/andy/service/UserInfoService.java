package org.andy.service;

import java.util.List;

import org.andy.entity.UserInfo;
import org.andy.service.utils.ResultComm;

public interface UserInfoService {
	// ͨ��Id��ѯUserInfo  
    UserInfo getById(Integer id);  
  
    // ��ѯȫ����UserInfo  
    List<UserInfo> findAll();  
  
    // ���UserInfo  
    Integer save(UserInfo userInfo); 
    
    Integer delete(Integer id);
    
    int[] batchSave(List<UserInfo> users);
    
    int[] batchDelete(List<Integer> id);
    
    ResultComm updateById(UserInfo userInfo);
}
