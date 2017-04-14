<%@page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生学籍</title>
</head>
<body>
	<h2 align="center">个人基本信息</h2>
	<table width="100%" height="100%" border="0">
		<tr>
			<td>
				<table width="80%" border="0">
					<%
						Student student = (Student) session.getAttribute("student");
						if (student == null) {
							response.sendRedirect("error.jsp");
						} else {
					%>

					<tr>
						<td>学号</td>
						<td><%=student.getSno()%></td>
						<td>姓名</td>
						<td><%=student.getUsername()%></td>
					</tr>
					<tr>
						<td>籍贯</td>
						<td><%=student.getJiguan()%></td>
						<td>电话</td>
						<td><%=student.getTel()%></td>
					</tr>
					<tr>
						<td>电子邮件</td>
						<td><%=student.getEmail()%></td>
						<td>学分</td>
						<td><%=student.getMark()%></td>
					</tr>
					<tr>
						<td>院系</td>
						<td><%=student.getDepartment()%></td>
						<td>性别</td>
						<td><%=student.getSex()%></td>
					</tr>

				</table>

			</td>
			<td>
				<table width="100%" height="100%" border="0">
					<tr>
						<td><img src="/jwzzuli/headimg/<%=student.getImage()%>"
							alt="照片" width="100" height="100"></td>
						<td><%=student.getImage()%></td>

					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><a
							href="<%=request.getContextPath()%>/student/stuinfo/FileUp.jsp">上传头像</a></td>
					</tr>
				</table> <%
 	}
 %>
			</td>
		</tr>
	</table>





</body>
</html>