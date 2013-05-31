package com.fe.bean.weixin;

import com.fe.base.BaseRequestBean;

/**
 * 事件推送消息
 * @author Fet
 *
 */
public class WX_EventMessage_Request  extends BaseRequestBean
{
  
  /*
	 <xml>
	    <ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
		<Event><![CDATA[EVENT]]></Event>
		<EventKey><![CDATA[EVENTKEY]]></EventKey>
     </xml>
	
	参数	描述
	ToUserName	 接收方微信号
	FromUserName	 发送方微信号，若为普通用户，则是一个OpenID
	CreateTime	 消息创建时间
	MsgType	 消息类型，event
	Event	 事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件)
	EventKey	 事件KEY值，与自定义菜单接口中KEY值对应 
	
  */
	
//	public String ToUserName;
//		
//	public String FromUserName;
//	
//	public Integer CreateTime;
	
	public String MsgType = "event";
	
	public String Event;
	
	public String EventKey;
	

	
}
