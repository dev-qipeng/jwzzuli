<%@page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<body>
	<s:form action="updateStudent" method="post">
		<table width="80%" border="0">
			<%
				Student student = (Student) session.getAttribute("a_studentObj_for_update");
					if (student == null) {
						response.sendRedirect("error.jsp");
					} else {
			%>
			<tr>
				<td>学号</td>
				<td><input type="text" readonly="readonly"
					value="<%=student.getSno()%>" /></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" readonly="readonly"
					value="<%=student.getUsername()%>" /></td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td><input type="text" readonly="readonly"
					value="<%=student.getJiguan()%>" /></td>
			</tr>
			<tr>
				<td>电话*</td>
				<td><input type="text" name="tel" value="<%=student.getTel()%>" /></td>
			</tr>
			<tr>
				<td>电子邮件*</td>
				<td><input type="text" name="email"
					value="<%=student.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>学分</td>
				<td><input type="text" readonly="readonly"
					value="<%=student.getMark()%>" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" readonly="readonly"
					value="<%=student.getSex()%>" /></td>
			</tr>
			<tr>
				<td>院系</td>
				<td><input type="text" readonly="readonly"
					value="<%=student.getDepartment()%>" /></td>
			</tr>
			<%
				}
			%>

			<tr>
				<td align="right"><input type="submit" value="提交" /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>