package com.fe.bean.weixin;

import com.fe.base.BaseRequestBean;

/**
 * 文本消息
 * @author Fet
 *
 */
public class WX_TextMessage_Request extends BaseRequestBean
{
	/*微信平台推送来的消息格式	
	   <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName> 
		 <CreateTime>1348831860</CreateTime>
		 <MsgType><![CDATA[text]]></MsgType>
		 <Content><![CDATA[this is a test]]></Content>
		 <MsgId>1234567890123456</MsgId>
	   </xml>
	   
	   
	   用户请求：<xml><ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName><FromUserName
><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName><CreateTime>1369922819</
CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[112233]]></Conte
nt><MsgId>5883773705649127448</MsgId></xml>
用户请求：<xml><ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName><FromUserName
><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName><CreateTime>1369922829</
CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[????????????è??]
]></Content><MsgId>5883773748598800410</MsgId></xml>
	   
	*/
	
	
	
	/* 参数	描述
       ToUserName	开发者微信号
       FromUserName	 发送方帐号（一个OpenID）
       CreateTime	 消息创建时间 （整型）
       MsgType	 text
       Content	 文本消息内容
       MsgId	 消息id，64位整型
	 */
//	
//  public String ToUserName;
//	
//	public String FromUserName;
//	
//	public Integer CreateTime;
	
	public String MsgType = "text";
	
	public String Content;
	
	public Long MsgId;
	
}
