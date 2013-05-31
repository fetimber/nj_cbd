package com.fe.bean.weixin;

import com.fe.base.BaseRequestBean;

/**
 * 超链接消息
 * @author Fet
 *
 */
public class WX_LinkMessage_Request  extends BaseRequestBean {
  
	/*
	 <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>1351776360</CreateTime>
		<MsgType><![CDATA[link]]></MsgType>
		<Title><![CDATA[公众平台官网链接]]></Title>
		<Description><![CDATA[公众平台官网链接]]></Description>
		<Url><![CDATA[url]]></Url>
		<MsgId>1234567890123456</MsgId>
    </xml> 
	
	参数	      描述
	ToUserName	 接收方微信号
	FromUserName	 发送方微信号，若为普通用户，则是一个OpenID
	CreateTime	 消息创建时间
	MsgType	 消息类型，link
	Title	 消息标题
	Description	 消息描述
	Url	 消息链接
	MsgId	 消息id，64位整型 
	 
	 */
	
//	    public String ToUserName;
//		
//		public String FromUserName;
//		
//		public Integer CreateTime;
		
		public String MsgType = "link";
		
		public String Title;
		
		public String Description;
		
		public String Url;
		
		public Long MsgId;
	
}
