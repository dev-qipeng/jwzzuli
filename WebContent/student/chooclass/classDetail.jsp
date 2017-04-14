<%@page import="entity.Classes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">课程详细内容</h3>
<br><br><br>
	<table width="80%" border="2" align="center">
		<%
			String id = request.getParameter("id");
			
			ArrayList allClasses = (ArrayList) session.getAttribute("allClasses");
			if (allClasses == null || allClasses.size() == 0) {
				response.sendRedirect("error.jsp");
			} else {
				for (int i = allClasses.size() - 1; i >= 0; i--) {
					Classes c = (Classes) allClasses.get(i);
					if (c.getCsId().toString().equals(id)) {
						System.out.print(c.getCname());
		%>

		<tr>
			<td>课程名称</td>
			<td>人数上限</td>
			<td>已选人数</td>
			<td>上课教室</td>
			<td>课时</td>
			<td>学分</td>
			<td>选择</td>
		</tr>
		<tr height="40">
			<td><%=c.getCname()%></td>
			<td><%=c.getChooseMax()%></td>
			<td><%=c.getChooseCurNum()%></td>
			<td><%=c.getRoomId()%></td>
			<td><%=c.getCourTime()%></td>
			<td><%=c.getCmark()%></td>

			<td><a href="xuanxiu.action?csId=<%=id%>">选修</a></td>
		</tr>

		<%
			}
				}
			}
		%>
	</table>


</body>
</html>