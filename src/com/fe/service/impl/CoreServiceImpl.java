package com.fe.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fe.base.BaseRequestBean;
import com.fe.base.BaseService;
import com.fe.bean.weixin.WX_TextMessage_Response;
import com.fe.constant.Constants;
import com.fe.service.ICoreService;

@Component("coreService")
@Scope("singleton")
public class CoreServiceImpl extends BaseService implements ICoreService 
{

	public Object coreSerivce(Object inObject) 
	       throws IllegalArgumentException, IllegalAccessException,
	       ClassNotFoundException, InstantiationException 
	{
		BaseRequestBean requestObject = (BaseRequestBean)inObject;
		
		//TODO 调用DAO获取 内容及返回报文类型
		
		//返回文本
		WX_TextMessage_Response  responseObject = 
			(WX_TextMessage_Response)getResponseObject(Constants.WEXIN_MESSAGE_TYPE_TEXT);
		
		
		responseObject.Content = "欢迎关注 ";
		
		responseObject.ToUserName  = requestObject.FromUserName;
		responseObject.FromUserName = requestObject.ToUserName;
		responseObject.CreateTime = requestObject.CreateTime;
		
		return responseObject;
	}

	
	
	
	
	
}
