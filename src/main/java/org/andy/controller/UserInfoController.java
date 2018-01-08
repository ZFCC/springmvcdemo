package org.andy.controller;

import java.util.Date;
import java.util.List;

import org.andy.entity.UserInfo;
import org.andy.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("/user")  
public class UserInfoController {

	    private static final Logger LOGGER = Logger.getLogger(UserInfoController.class);  
	   
	    @Autowired  
	    private UserInfoService userInfoService;  
	  
	    @RequestMapping("/showInfo/{userId}")  
	    public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {  
	        LOGGER.info("�鿴�û���" + userId);  
	        UserInfo userInfo = userInfoService.getById(userId);
	        modelMap.addAttribute("userInfo", userInfo);  
	        return "/user/showInfo";  
	    }  
	  
	    @RequestMapping("/showInfos")  
	    public @ResponseBody List<UserInfo> showUserInfos() {  
	        LOGGER.info("json����ȫ���û�����Ϣ");  
	        List<UserInfo> userInfos = userInfoService.findAll();  
	        return userInfos;  
	    }
	    
	    @RequestMapping("/showInfo/save")
	    public String save(@ModelAttribute("form") UserInfo user, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
	    	user.setCreate_time(new Date());
	    	LOGGER.info("json:user"+user);  
	    	Integer num = userInfoService.save(user);
	    	
	    	model.addAttribute("user", num);
	        return "detail";
	    }
	    
}
