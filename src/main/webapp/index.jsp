<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.6.4.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	<title>Index2</title>
    <script type="text/JavaScript" src="http://apps.bdimg.com/libs/jQuery/1.6.4/jquery.min.js"></script>
    <link href="http://libs.baidu.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<form action="<%=basePath%>upload2.htm" method="post" enctype="multipart/form-data">
    <input class="filePrew"  tabIndex="3" type="file" size="3" name="graphTheories" multiple/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
