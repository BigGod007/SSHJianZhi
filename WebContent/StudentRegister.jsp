<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style2.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyform.js"></script>
</head>
<body>
	<br>
		<div class="form-div">
			<form id="reg-form" action="${pageContext.request.contextPath}/student-register" method="post">
				<table>
					<tr>
						<td>用户名</td>
						<td><input name="studentRegister.username" type="text"/>
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input name="studentRegister.password" type="password"/></td>`
					</tr>
					<tr>
						<td>email</td>
						<td><input name="studentRegister.email" type="text"/></td>
					</tr>
					<tr>
						<td>手机号</td>
						<td><input name="studentRegister.telphone" type="text"/></td>
					</tr>
					<tr>
						<td>所在市</td>
						<td><input name="studentRegister.city" type="text"/></td>
					</tr>
					<tr>
						<td>所在区</td>
						<td><input name="studentRegister.district" type="text"/></td>
					</tr>
					<tr>
						<td>所在学校</td>
						<td><input name="studentRegister.schoolName" type="text"/></td>
					</tr>
				</table>

				<div class="buttons">
					<input value="注 册" type="submit"
						style="margin-right: 20px; margin-top: 20px;" onclick="alert('注册成功')"/> 
				<a href="${pageContext.request.contextPath}/StudentLogin.jsp"><input
						value="我有账号，我要登录" type="button"
						style="margin-right: 45px; margin-top: 20px;" /></a>
				</div>

				<br class="clear" />
			</form>
		</div>
</body>
</html>
