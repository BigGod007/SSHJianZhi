<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/colResizable-1.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

<script type="text/javascript">
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});

	});
</script>
<title>Document</title>
</head>
<body>
	<div class="container">
		<div id="button" class="mt10">
			<a href="${pageContext.request.contextPath}/student/getMine"><input type="button"
				name="button" class="btn btn82 btn_recycle" value="我的"></a> 
			<a href="${pageContext.request.contextPath}/student/list"><input
				type="button" name="button" class="btn btn82 btn_search" value="查询"></a>
		</div>

		<div id="forms" class="mt10">
			<div class="box">
				<div class="box_border">
					<div class="box_top">
						<b class="pl15">我的个人信息</b>
					</div>
					<div class="box_center">

						<table class="form_table pt15 pb15" width="100%" border="0"
							cellpadding="0" cellspacing="0">
							<tr>
								<td class="td_right">用户名：</td>
								<td><s:property
										value="#request.stu.username" /></td>
							</tr>

							<tr>
								<td class="td_right">所属学校：</td>
								<td><s:property
										value="#request.stu.school.schoolName" /></td>
							</tr>

							<tr>
								<td class="td_right">手机号：</td>
								<td><s:property
										value="#request.stu.telphone" /></td>
							</tr>

							<tr>
								<td class="td_right">邮箱地址：</td>
								<td><s:property
										value="#request.stu.email" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>