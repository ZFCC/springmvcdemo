package springmvc_demo;

import java.util.Date;
import java.util.List;

import org.andy.entity.UserInfo;
import org.andy.service.UserInfoService;
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
        //测试查询对应的用户  
        UserInfo userInfo = userInfoService.getById(2);  
        LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                "yyyy-MM-dd HH:mm:ss"));  
    }  
  
    @Test  
    public void testFindAll() {  
        //测试查询全部用户  
        List<UserInfo> userInfos = userInfoService.findAll();  
        for (UserInfo userInfo : userInfos) {  
            LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                    "yyyy-MM-dd HH:mm:ss"));  
            System.out.println(JSON.toJSONStringWithDateFormat(userInfo, "yyyy-MM-dd"));
        }  
    }  
  
    @Test  
    public void testSave() {  
        //测试保存用户数据  
        UserInfo userInfo = new UserInfo();  
        userInfo.setName("zhaofuchao");  
        userInfo.setPassword("123");  
        userInfo.setCreate_time(new Date());  
        int result = userInfoService.save(userInfo);  
        LOGGER.info("result = " + result);  
    }  
}
