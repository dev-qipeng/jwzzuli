<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>
	var curopenItem = '1';
</script>
<script language="javascript" type="text/javascript"
	src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body>
	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left: 3px; padding-top: 8px' valign="top">
				<!-- 常用操作开始 -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_1")'>
						<b>常用操作</b>
					</dt>
					<dd style='display: block' class='sitem' id='items1_1'>
						<ul class='sitemu'>
							<li>
								<div class="items">
									<div class="fllct">
										<a href="skanStudent" target="main">学生学籍</a>
									</div>
								</div>
							</li>
							<li>
								<div class="fllct">
									<a href="queryScore" target="main">成绩查询</a>
								</div>
							</li>
							<li>
								<div class="fllct">
									<a href="forUpdateStudent" target="main">修改个人信息</a>
								</div>
							</li>
							<li>
								<div class="fllct">
									<a href="stuinfo/updatePwd.jsp" target="main">密码修改</a>
								</div>
							</li>
						</ul>
					</dd>
				</dl>
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>选课系统</b>
					</dt>
					<dd style='display: block' class='sitem' id='items2_1'>
						<ul class='sitemu'>
							<li><a href='"chooseClasses"' target='main'>进入选课</a></li>
							<li><a href='myClasses' target='main'>已选课程</a></li>
							<li><a href='queryScore' target='main'>选课成绩</a></li>
						</ul>
					</dd>
				</dl> <!-- 选课系统结束 --> <!-- 其他开始 -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>其他</b>
					</dt>
					<dd style='display: block' class='sitem' id='items2_1'>
						<ul class='sitemu'>
							<li><a target="_blank"
								href="http://wpa.qq.com/msgrd?v=3&uin=330262363&site=qq&menu=yes"><img
									border="0"
									src="http://wpa.qq.com/pa?p=2:330262363:41 &r=0.7815125500474443"
									alt="请留言" title="请留言"></a></li>
							<li><a href='' target='main'>校园论坛</a></li>
						</ul>
					</dd>
				</dl> <!-- 其他结束 -->
			</td>
		</tr>
	</table>
</body>
</html>
