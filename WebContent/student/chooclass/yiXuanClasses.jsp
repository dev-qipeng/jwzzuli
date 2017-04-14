<%@page import="entity.Score"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已选课程</title>
</head>
<body>
	<h3 align="center">
		学号：
		<s:property value="#session.username" />
	</h3>
	<table width="50%" border="1" align="center">
		<tr>
			<td>课程名</td>
			<td>课程学分</td>
			<td>操作</td>
		</tr>

		<%
			ArrayList score = (ArrayList) session.getAttribute("lookYiXuan");
			if (score == null || score.size() == 0) {
				response.sendRedirect("error.jsp");
			} else {
				for (int i = score.size() - 1; i >= 0; i--) {
					Score s = (Score) score.get(i);
		%>


		<tr>
			<td><%=s.getClasses().getCname()%></td>
			<td><%=s.getClasses().getCmark()%></td>
			<td><a href="deleteCourse.action?scoreId=<%=s.getScoreId()%>">取消此课程</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>