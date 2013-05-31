package com.fe.base;

import java.lang.reflect.Field;

import com.fe.bean.weixin.WX_TextMessage_Request;
import com.fe.bean.weixin.WX_TextMessage_Response;
import com.fe.util.Config;

public class BaseService 
{
	public Object getResponseObject(Object inObject,String msgType) 
	throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
	    WX_TextMessage_Request requestObject = (WX_TextMessage_Request)inObject;
		
		WX_TextMessage_Response responseObject = new WX_TextMessage_Response();
		
		Class<?> clazz = Class.forName(Config.WEIXIN_PACKAGE 
				+ returnResponseObjectName(msgType));
		
		Object obj = clazz.newInstance();
		
		return obj;
	}
	
	
	
	
	//预留方法
	public Object fillObjectValue(Object inObject,Object outObject) 
       throws IllegalArgumentException, IllegalAccessException 
	{	
		Field[] dfList = inObject.getClass().getFields();
		
		outObject = inObject;
		
		for(Field df : dfList)
		{	
			df.setAccessible(true);
			
			Object value =  df.get(inObject); //df.get();
			
			System.out.println("+++ name ++" + df.getName() + "  ----value---  : " +value);
			
			df.set(outObject,value);	
	    }
		
		return outObject;
	}
	
	
	/**
	 * 组装REQUEST对象的类名
	 * @param msgType
	 * @return
	 */
	private String returnResponseObjectName(String msgType)
	{
		return Config.WEIXIN_OBJECT_BEGIN + 
		 String.valueOf(msgType.charAt(0)).toUpperCase() 
		+ String.valueOf(msgType.substring(1))
		+ Config.WEIXIN_OBJECT_END;
	}
	
}
