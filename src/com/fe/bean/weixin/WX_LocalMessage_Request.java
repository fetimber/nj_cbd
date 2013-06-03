package com.fe.bean.weixin;

import com.fe.base.BaseRequestBean;


/**
 * 地理位置消息
 * @author Fet
 *
 */
public class WX_LocalMessage_Request  extends BaseRequestBean {
    /*
       <xml>
			<ToUserName><![CDATA[toUser]]></ToUserName>
			<FromUserName><![CDATA[fromUser]]></FromUserName>
			<CreateTime>1351776360</CreateTime>
			<MsgType><![CDATA[location]]></MsgType>
			<Location_X>23.134521</Location_X>
			<Location_Y>113.358803</Location_Y>
			<Scale>20</Scale>
			<Label><![CDATA[位置信息]]></Label>
			<MsgId>1234567890123456</MsgId>
		</xml> 

		用户请求：
		<xml>
		<ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName>
		<FromUserName><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName>
		<CreateTime>1369922355</CreateTime>
		<MsgType><![CDATA[location]]></MsgType>
		<Location_X>32.001184</Location_X>
		<Location_Y>118.768934</Location_Y><Scale>20</Scale>
		<Label><![CDATA[???????±?è??????????????é?¨è?±??°???é?¨è?±è??è·?206??·]]></Label>
		<MsgId>5883771712784302103</MsgId>
		</xml>

		参数	描述
		ToUserName	开发者微信号
		FromUserName	 发送方帐号（一个OpenID）
		CreateTime	 消息创建时间 （整型）
		MsgType	 location
		Location_X	 地理位置纬度
		Location_Y	 地理位置经度
		Scale	 地图缩放大小
		Label	 地理位置信息
		MsgId	 消息id，64位整型
      */
		
		public String MsgType = "location";
		
		public Float Location_X;
		
		public Float Location_Y;
		
		public String Scale;
	
		public String Label;
		
		public Long MsgId;
}
