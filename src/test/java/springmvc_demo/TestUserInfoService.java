package springmvc_demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.andy.entity.UserInfo;
import org.andy.service.UserInfoService;
import org.andy.service.utils.ResultComm;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:springmvc-applicationContext.xml" })  
public class TestUserInfoService {
	private static final Logger LOGGER = Logger  
            .getLogger(TestUserInfoService.class);  
    @Autowired  
    private UserInfoService userInfoService;  
  
    @Test  
    public void testGetById() {  
        //���Բ�ѯ��Ӧ���û�  
        UserInfo userInfo = userInfoService.getById(2);  
        LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                "yyyy-MM-dd HH:mm:ss"));  //年后怎么回事啊啊啊啊
    }  
  
    @Test  
    public void testFindAll() {  
        //���Բ�ѯȫ���û�  
        List<UserInfo> userInfos = userInfoService.findAll();  
        for (UserInfo userInfo : userInfos) {  
            LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                    "yyyy-MM-dd HH:mm:ss"));  
            System.out.println(JSON.toJSONStringWithDateFormat(userInfo, "yyyy-MM-dd"));
        }  
    }  
  
    @Test  
    public void testSave() {  
        //���Ա����û�����  
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3);
        userInfo.setName("zhaofuchao");  
        userInfo.setPassword("123");  
        userInfo.setCreate_time(new Date());  
        int result = userInfoService.save(userInfo);  
        LOGGER.info("result = " + result);  
    }  
    
    @Test
    public void testDelete(){
    	Integer ter = userInfoService.delete(5);
    	System.out.println(ter);
    	LOGGER.info("result = " + ter);  
    }
    
    @Test
    public void testBeachSave(){
    	
    	List<UserInfo> list = new ArrayList<UserInfo>();
    	for(int i=0; i<50 ; i++){
	    	UserInfo user = new UserInfo();
	    	user.setName("小明"+i);
	    	user.setPassword("123123"+i);
	    	user.setCreate_time(new Date());
	    	list.add(user);
	    	System.out.println(list);
    	}
    	
    	int[] result = userInfoService.batchSave(list);
    	LOGGER.info("result = " + result);  
    }
    
    @Test
    public void testBeachDelete(){
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i = 8; i < 13; i++) {
			int id = i;
			
			list.add(id);
		}
    	int[] result = userInfoService.batchDelete(list);
    	LOGGER.info("result = " + result.toString());  
    }
    @Test
    public void testupdatebyid(){
    	UserInfo userInfo = new UserInfo();
    	userInfo.setName("赵大小");
    	userInfo.setPassword("654321");
    	userInfo.setId(6);
    	ResultComm rc= userInfoService.updateById(userInfo);
    	System.out.println(rc.isSuccess());
    }
}
