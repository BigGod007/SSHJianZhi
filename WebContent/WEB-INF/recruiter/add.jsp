<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		$(function(){
		$(".list_table").colResizable({
		liveDrag:true,
		gripInnerHtml:"<div class='grip'></div>",
		draggingClass:"dragging",
		minWidth:30
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
						<div class="box_top"><b class="pl15">添加招聘信息</b></div>
						<div class="box_center">
							<form action="${pageContext.request.contextPath}/recruiter/addRecruitment" class="jqtransform" method="post">
								<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td class="td_right">标题：</td>
										<td class="">
											<input type="text" name="title" class="input-text lh30" size="40">
										</td>
										
									</tr>
									<tr >
										<td class="td_right">市区：</td>
										<td class="">
											<span class="fl">
												<div class="select_border">
													<div class="select_containers ">
														<select name="city" class="select">
															<option>广州</option>
															<option>天津</option>
															<option>上海</option>
															<option>重庆</option>
														</select>
													</div>
												</div>
											</span>&nbsp;市
										</td>
									</tr>

									<tr >
										<td class="td_right">&nbsp;</td>
										<td class="">
											<span class="fl">
												<div class="select_border">
													<div class="select_containers ">
														<select name="district" class="select">
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
												</div>
											</span>&nbsp;区
										</td>
									</tr>

									<tr>
										<td class="td_right">具体地址：</td>
										<td class="">
											<input type="text" name="address" class="input-text lh30" size="40">
										</td>
									</tr>

									<tr>
										<td class="td_right">薪资：</td>
										<td class="">
											<input type="text" name="salary" class="input-text lh30" size="40">元/天
										</td>
									</tr>

									<tr>
										<td class="td_right">联系电话：</td>
										<td class="">
											<input type="text" name="phone" class="input-text lh30" size="40">
										</td>
									</tr>

									<tr>
										<td class="td_right">工作时间：</td>
										<td class="">
										<span class="fl">
											<input type="text" name="beginYear" class="input-text lh30" size="10">年
											<input type="text" name="beginMonth" class="input-text lh30" size="10">月
											<input type="text" name="beginDay" class="input-text lh30" size="10">日&nbsp;至&nbsp;
											<input type="text" name="endYear" class="input-text lh30" size="10">年
											<input type="text" name="endMonth" class="input-text lh30" size="10">月
											<input type="text" name="endDay" class="input-text lh30" size="10">日
										</span>
										</td>
									</tr>
									<tr >
										<td class="td_right">工作性质：</td>
										<td class="">
											<span class="fl">
												<div class="select_border">
													<div class="select_containers ">
														<select name="correspond.correspondName" class="select">
															<option>实习</option>
															<option>兼职</option>
														</select>
													</div>
												</div>
											</span>
										</td>
									</tr>

									<tr >
										<td class="td_right">工作类别：</td>
										<td class="">
											<span class="fl">
												<div class="select_border">
													<div class="select_containers ">
														<select name="workKind.workKindName" class="select">
															<option>技术</option>
															<option>营销</option>
															<option>派单</option>
														</select>
													</div>
												</div>
											</span>
										</td>
									</tr>

									<tr>
										<td class="td_right">备注：</td>
										<td class="">
											<textarea name="context" id="" cols="30" rows="10" class="textarea"></textarea>
										</td>
									</tr>
									<tr>
										<td class="td_right">&nbsp;</td>
										<td class="">
											<input type="submit" name="button" class="btn btn82 btn_save2" value="添加">
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>