<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student-register" method="post">
		用户名:<input type="text" name="studentRegister.username" />
		<br />
		密码:<input type="password" name="studentRegister.password" />
		<br />
		所在院校:
		<input type="text" name="studentRegister.city" />市
		<input type="text" name="studentRegister.district" />区
		<input type="text" name="studentRegister.schoolName" />（所在院校）
		<br />
		手机号:
		<input type="text" name="studentRegister.telphone" />
		邮箱地址:
		<input type="text" name="studentRegister.email" />
		<input type="submit" name="studentRegister.submit"/>
	</form>
</body>
</html>