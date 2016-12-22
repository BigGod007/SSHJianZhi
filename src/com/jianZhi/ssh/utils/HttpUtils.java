package com.jianZhi.ssh.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class HttpUtils {

	public static HttpServletRequest getRequest() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		return request;
	}
	
	public static HttpServletResponse getResponse(String contentType) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
		return response;
	}
	
}
