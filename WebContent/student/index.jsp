<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统--学生</title>
<style>
body {
	scrollbar-base-color:#c0d586;
	scrollbar-arrow-color:#FFFFFF;
	scrollbar-shadow-color:#deefc6;
}
</style>
</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="student/top.jsp" name="topFrame" scrolling="no"/>
	<frameset cols="180,*" name="btFrame" frameborder="no" border="0" framespacing="0">
		<frame src="student/menu.jsp" noresize name="menu" scrolling="yes">
		<frame src="student/main.jsp" noresize name="main" scrolling="yes">
	</frameset>
</frameset>
<noframes>
	<body>您的浏览器不支持框架</body>
</noframes>
</html>