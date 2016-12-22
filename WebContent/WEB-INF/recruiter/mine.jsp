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
			<a href="${pageContext.request.contextPath}/recruiter/to-add"><input type="button" name="button" class="btn btn82 btn_add"
				value="新增"></a> 
			<a href="${pageContext.request.contextPath}/recruiter/getMine"><input type="button"
				name="button" class="btn btn82 btn_recycle" value="我的"></a> 
			<a href="${pageContext.request.contextPath}/recruiter/list"><input
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
										value="#request.rec.username" /></td>
							</tr>

							<tr>
								<td class="td_right">所属公司：</td>
								<td><s:property
										value="#request.rec.company.companyName" /></td>
							</tr>

							<tr>
								<td class="td_right">手机号：</td>
								<td><s:property
										value="#request.rec.telphone" /></td>
							</tr>

							<tr>
								<td class="td_right">邮箱地址：</td>
								<td><s:property
										value="#request.rec.email" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div id="forms" class="mt10">
			<div class="box">
				<div class="box_border">
					<div class="box_top">
						<b class="pl15">我发布的招聘信息</b>
					</div>
					<div class="box_center">

						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="list_table">
							<tr>
								<th width="25">标题</th>
								<th width="10">城市</th>
								<th width="10">市区</th>
								<th width="40">地址</th>
								<th width="10">工资</th>
								<th width="25">联系电话</th>
								<th width="25">开始日期</th>
								<th width="25">结束日期</th>
								<th width="20">工作性质</th>
								<th width="20">工作类别</th>
								<th width="35">发布日期</th>
								<th width="20">发布人</th>
								<th width="60">备注</th>
								<th width="10">删除</th>
							</tr>
							<s:iterator var="recruitment" value="#request.list">
								<tr class="tr">
									<td><s:property value="#recruitment.title" /></td>
									<td><s:property value="#recruitment.city.cityName" /></td>
									<td><s:property value="#recruitment.district" /></td>
									<td><s:property value="#recruitment.address" /></td>
									<td><s:property value="#recruitment.salary" /></td>
									<td><s:property value="#recruitment.phone" /></td>
									<td><s:property value="#recruitment.beginYear" />. <s:property
											value="#recruitment.beginMonth" />. <s:property
											value="#recruitment.beginDay" /></td>
									<td><s:property value="#recruitment.endYear" />. <s:property
											value="#recruitment.endMonth" />. <s:property
											value="#recruitment.endDay" /></td>
									<td><s:property
											value="#recruitment.correspond.correspondName" /></td>
									<td><s:property value="#recruitment.workKind.workKindName" /></td>
									<td><s:property value="#recruitment.date" /></td>
									<td><s:property value="#recruitment.recruiter.username" /></td>
									<td><s:property value="#recruitment.context" /></td>
									<td><a href="${pageContext.request.contextPath}/recruiter/deleteRecruitment?id=<s:property value="#recruitment.recruitment_id" />">删除</a></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>