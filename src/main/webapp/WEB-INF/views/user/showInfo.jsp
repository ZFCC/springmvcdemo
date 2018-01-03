<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>  
<title>user_demo</title>
</head>
<body>
 姓名： ${userInfo.name} 
 密码： ${userInfo.password} 
 创建时间： ${userInfo.create_time} 
    <br/>  
    ajax显示全部用户信息：  
    <div id="show_all_user"></div> 
    
    <script type="text/javascript">  
    $.ajax({  
        type : "get",  
        url : "user/showInfos.htmls",  
        dataType : "json",  
        success : function(data) {  
            $(data).each(  
                    function(i, user) {  
                        var p = "<p>username:" + user.name + "    password:"  
                                + user.password + "    create_time:"  
                                + user.create_time + "</p>";  
                        $("#show_all_user").append(p);  
                    });  
        },  
        async : true  
    });  
</script> 
    
</body>
 
</html>