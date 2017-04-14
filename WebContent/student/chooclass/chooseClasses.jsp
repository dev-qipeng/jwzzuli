<%@page import="entity.Classes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课</title>
</head>
<body>
	<h3 align="center">选课</h3>
	<table width="50%" border="2" align="center">
		<tr>
			<td>课程名称</td>
			<td>已选/名额上限</td>
		</tr>
		<%
			ArrayList allClasses = (ArrayList) session.getAttribute("allClasses");
			if (allClasses == null || allClasses.size() == 0) {
				response.sendRedirect("error.jsp");
			} else {
				for (int i = allClasses.size() - 1; i >= 0; i--) {
					Classes c = (Classes) allClasses.get(i);
		%>
		<tr>
			<td><a href="<%=request.getContextPath()%>/student/chooclass/classDetail.jsp?id=<%=c.getCsId()%>"><%=c.getCname()%></a></td>
			<td><%=c.getChooseCurNum()%>/<%=c.getChooseMax()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>