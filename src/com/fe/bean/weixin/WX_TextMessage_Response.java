package com.fe.bean.weixin;

import com.fe.base.BaseResponseBean;


/**
 * 文本消息
 * @author Fet
 *
 */
public class WX_TextMessage_Response  extends BaseResponseBean
{
    
	
	 /* 响应给微信平台的报文格式
	   <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName>
		 <CreateTime>12345678</CreateTime>
		 <MsgType><![CDATA[text]]></MsgType>
		 <Content><![CDATA[content]]></Content>
		 <FuncFlag>0</FuncFlag>
       </xml>
	  */
	
	 /*
	    ToUserName	 接收方帐号（收到的OpenID）
		FromUserName	 开发者微信号
		CreateTime	 消息创建时间
		MsgType	 text
		Content	 回复的消息内容,长度不超过2048字节
		FuncFlag	 位0x0001被标志时，星标刚收到的消息。
	  */
	
	public String ToUserName;
	
	public String FromUserName;
	
	public Integer CreateTime;
	
	public String MsgType = "text";
	
	public String Content; 
	
	//0不标记  1标记为星型
	public Integer FuncFlag = 0;
	
}
