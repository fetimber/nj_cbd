package com.fe.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fe.base.BaseRequestBean;
import com.fe.base.BaseService;
import com.fe.bean.weixin.WX_TextMessage_Request;
import com.fe.bean.weixin.WX_TextMessage_Response;
import com.fe.service.ICoreService;

@Component("coreService")
@Scope("singleton")
public class CoreServiceImpl extends BaseService implements ICoreService 
{

	public Object coreSerivce(Object inObject) 
	       throws IllegalArgumentException, IllegalAccessException 
	{
		BaseRequestBean requestObject = (BaseRequestBean)inObject;
		
		//TODO 调用DAO获取内容 获取返回类型
		
		//返回文本
		WX_TextMessage_Response responseObject = new WX_TextMessage_Response();
		
		responseObject.Content = "欢迎使用集团微信助手";
		responseObject.ToUserName  = requestObject.FromUserName;
		responseObject.FromUserName = requestObject.ToUserName;
		responseObject.CreateTime = requestObject.CreateTime;
		
		
		return responseObject;
	}

	
	
	
	
	
}
