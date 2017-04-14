<%@page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
	<s:form action="updatePwd" method="post">
		<table width="80%" border="1">
			<tr>
				<td>学号</td>
				<td><s:property value="#session.sno" /></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><s:property value="#session.username" /></td>
			</tr>
			<tr>
				<td>输入当前密码</td>
				<td><input type="text" name="oldPwd" /></td>
			</tr>
			<tr>
				<td>输入要修改的密码</td>
				<td><input type="text" name="newPwd1" /></td>
			</tr>
			<tr>
				<td>再次输入密码</td>
				<td><input type="text" name="newPwd2" /></td>
			</tr>

			<tr>
				<td align="right"><input type="submit" value="提交" /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>