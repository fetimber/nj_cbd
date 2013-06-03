package com.fe.bean.weixin;

import com.fe.base.BaseRequestBean;

/**
 * 图片消息
 * @author Fet
 *
 */
public class WX_ImageMessage_Request  extends BaseRequestBean {

	/*<xml>
	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 <CreateTime>1348831860</CreateTime>
	 <MsgType><![CDATA[image]]></MsgType>
	 <PicUrl><![CDATA[this is a url]]></PicUrl>
	 <MsgId>1234567890123456</MsgId>
	 </xml>
	 
	 
	 用户请求：
	 <xml>
	 <ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName>
	 <FromUserName><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName>
	 <CreateTime>1369922093</CreateTime>
	 <MsgType><![CDATA[image]]></MsgType>
	 <PicUrl><![CDATA[http://mmsns.qpic.cn/mmsns/OuFHQCSPp9O5XtqDsiaxapMhicKkKicemuIJ2WBIicobS5OucB7UTGcI2Q/0]]></PicUrl>
	 <MsgId>5883770587502870550</MsgId>
	 <MediaId><![CDATA[qceP-hYKLUzkSzlta3Z4zntX16FVRdyNfONGkgyzV2BNYlegbtrZER-YFLBMarop]]></MediaId>
     </xml>
	 
	*/
	
	
	
	/*
	   ToUserName	开发者微信号
       FromUserName	 发送方帐号（一个OpenID）
       CreateTime	 消息创建时间 （整型）
       MsgType	 image
       PicUrl	 图片链接
       MsgId	 消息id，64位整型
	 */
	
		
		public String MsgType = "image";
		
		public String PicUrl;
		
		public Long MsgId;
	
}
