<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>文件上传</title>
</head>
<body>
	<s:form action="upload" enctype="multipart/form-data">
		<s:file name="upload" label="选择文件" />
		<br>
		<s:submit value="上传" />
	</s:form>
</body>
</html>