<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>

<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
</style>
</head>
<body>
	<s:form action="login" method="post">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td bgcolor="#e5f6cf">&nbsp;</td>
			</tr>
			<tr>
				<td height="608" background="images/login_03.gif">
					<table width="862" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="266" background="images/login_04.gif">
								<div align="center" class="STYLES">教务管理系统</div>
							</td>
						</tr>
						<tr>
							<td height="95">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="342" height="95" background="images/login_06.gif">&nbsp;</td>
										<td width="265" background="images/login_07.gif">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="21%" height="30">
														<div align="center">
															<span class="STYLE3">用户</span>
														</div>
													</td>
													<td width="39%" height="30"><input type="text"
														name="sno"
														style="height: 18px; width: 130px; border: solid 1px# cadcb2; font-size: 12px; color: #81b432;" />
													</td>
													<td width="40%"><label> <input type="radio"
															name="radiobutton" value="1" checked="checked" />学生
													</label></td>
												</tr>
												<tr>
													<td height="30">
														<div align="center">
															<span class="STYLE3">密码</span>
														</div>
													</td>
													<td height="30"><input type="password" name="password"
														style="height: 18px; width: 130px; border: solid 1px# cadcb2; font-size: 12px; color: #81b432;" />
													</td>
													<td height="30"><label> <input type="radio"
															name="radiobutton" value="2" />教师
													</label></td>
												</tr>
												<tr>
													<td height="30">&nbsp;</td>
													<td height="30"><input type="submit" value="登  录" /> <label>
															<input type="reset" name="Submit" value="重  置" />
													</label></td>
													<td height="30"><input type="radio"
														name="radiobutton" value="3" />管理员</td>
												</tr>
											</table>
										</td>
										<td width="255" background="images/login_08.gif"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="247" valign="top" background="images/login_09.gif">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="22%" height="30">&nbsp;</td>
										<td width="56%">&nbsp;</td>
										<td width="22%">&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td height="30">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="44%" height="20">&nbsp;</td>
													<td width="56%" class="STYLE4">版本 2012V1.0</td>
												</tr>
											</table>
										</td>
										<td>&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

				</td>
			</tr>

		</table>

	</s:form>
</body>
</html>