package com.fe.base;

import com.fe.util.Config;

public class BaseService 
{
	/**
	 * 根据响应类型创建对象
	 * @param responseType
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Object getResponseObject(String responseType) 
	throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> clazz = Class.forName(Config.WEIXIN_PACKAGE 
				+ returnRequestObjectName(responseType));
		
		Object obj = clazz.newInstance();
		
		return obj;
	}
	
	/**
	 * 组装REQUEST对象的类名
	 * @param msgType
	 * @return
	 */
	private String returnRequestObjectName(String msgType)
	{
		return Config.WEIXIN_RESPONSE_BEGIN + 
		 String.valueOf(msgType.charAt(0)).toUpperCase() 
		+ String.valueOf(msgType.substring(1))
		+ Config.WEIXIN_RESPONSE_END;
	}
	
	
	
}
