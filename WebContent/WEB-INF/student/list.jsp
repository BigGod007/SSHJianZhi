<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/colResizable-1.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>

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
		<div id="search_bar" class="mt10">
			<div class="box">
				<div class="box_border">
					<div class="box_top">
						<b class="pl15">筛选</b>
					</div>
					<form
						action="${pageContext.request.contextPath}/student/list"
						method="post">
						<div class="box_center pt10 pb10">
							<table class="form_table" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td><span class="fl">
											<div class="select_border">
												<div class="select_containers ">
													<select name="cityFilter" class="select">
														<option>广州</option>
													</select>
												</div>
											</div> 市
									</span></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td><span class="fl">
											<div class="select_border">
												<div class="select_containers ">
													<select name="districtFilter" class="select">
														<option>越秀</option>
														<option>海珠</option>
														<option>荔湾</option>
														<option>天河</option>
														<option>白云</option>
														<option>黄埔</option>
														<option>花都</option>
														<option>番禺</option>
														<option>番禺</option>
														<option>萝岗</option>
														<option>南沙</option>
													</select>
												</div>
											</div> 区
									</span></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>工作性质</td>
									<td><span class="fl">
											<div class="select_border">
												<div class="select_containers ">
													<select name="correspondFilter" class="select">
														<option>实习</option>
														<option>兼职</option>
													</select>
												</div>
											</div> 区
									</span></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>工作类别</td>
									<td><span class="fl">
											<div class="select_border">
												<div class="select_containers ">
													<select name="workKindFilter" class="select">
														<option>技术</option>
														<option>营销</option>
														<option>派单</option>
													</select>
												</div>
											</div>
									</span></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>排序方式</td>
									<td><span class="fl">
											<div class="select_border">
												<div class="select_containers ">
													<select name="sort" class="select">
														<option>无序</option>
														<option>薪资</option>
														<option>发布时间</option>
													</select>
												</div>
											</div>
									</span></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								</tr>
							</table>
						</div>
						<div class="box_bottom pb5 pt5 pr10"
							style="border-top: 1px solid #dadada;">
							<div class="search_bar_btn" style="text-align: right;">
								<input type="submit" value="确定" class="ext_btn ext_btn_submit">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="table" class="mt10">
			<div class="box span10 oh">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="list_table">
					<tr>
						<th width="10">标题</th>
						<th width="15">城市</th>
						<th width="15">市区</th>
						<th width="40">地址</th>
						<th width="20">工资</th>
						<th width="30">联系电话</th>
						<th width="30">开始日期</th>
						<th width="30">结束日期</th>
						<th width="30">工作性质</th>
						<th width="30">工作类别</th>
						<th width="30">发布日期</th>
						<th width="30">发布人</th>
						<th width="30">备注</th>
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
						</tr>
					</s:iterator>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
