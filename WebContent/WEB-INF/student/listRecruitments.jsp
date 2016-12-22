<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table cellpadding="5" cellspacing="0" border="2" align="center">
		<tr>
			<td>标题</td>
			<td>城市</td>
			<td>市区</td>
			<td>地址</td>
			<td>工资</td>
			<td>联系电话</td>
			<td>开始日期</td>
			<td>结束日期</td>
			<td>工作性质</td>
			<td>工作类别</td>
			<td>发布日期</td>
			<td>发布人</td>
			<td>备注</td>
		</tr>
		<s:iterator var="recruitment" value="#request.list">
			<tr>
				<td><s:property value="#recruitment.title"/></td>
				<td><s:property value="#recruitment.city.cityName" /></td>
				<td><s:property value="#recruitment.district" /></td>
				<td><s:property value="#recruitment.address" /></td>
				<td><s:property value="#recruitment.salary" /></td>
				<td><s:property value="#recruitment.phone" /></td>
				<td>
					<s:property value="#recruitment.beginYear" />.
					<s:property value="#recruitment.beginMonth" />.
					<s:property value="#recruitment.beginDay" />
				</td>
				<td>
					<s:property value="#recruitment.endYear" />.
					<s:property value="#recruitment.endMonth" />.
					<s:property value="#recruitment.endDay" />
				</td>
				<td><s:property value="#recruitment.correspond.correspondName" /></td>
				<td><s:property value="#recruitment.workKind.workKindName" /></td>
				<td><s:property value="#recruitment.date" /></td>
				<td><s:property value="#recruitment.recruiter.username" /></td>
				<td><s:property value="#recruitment.context" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>