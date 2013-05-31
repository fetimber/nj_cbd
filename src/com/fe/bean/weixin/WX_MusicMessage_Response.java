package com.fe.bean.weixin;

import com.fe.base.BaseResponseBean;

public class WX_MusicMessage_Response extends BaseResponseBean {
 
	 /*
	  <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName>
		 <CreateTime>12345678</CreateTime>
		 <MsgType><![CDATA[music]]></MsgType>
		 <Music>
		 <Title><![CDATA[TITLE]]></Title>
		 <Description><![CDATA[DESCRIPTION]]></Description>
		 <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
		 <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
		 </Music>
         <FuncFlag>0</FuncFlag>
      </xml>
	
	参数	描述
	ToUserName	 接收方帐号（收到的OpenID）
	FromUserName	 开发者微信号
	CreateTime	 消息创建时间
	MsgType	 music
	MusicUrl	 音乐链接
	HQMusicUrl	 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	FuncFlag	 位0x0001被标志时，星标刚收到的消息。 
	   
	  */
	
//  public String ToUserName;
//	
//	public String FromUserName;
//	
//	public Integer CreateTime;
	
	public String MsgType = "music";
	
	public String Title;
	
	public String Description;
	
	public String MusicUrl; 
	
	public String HQMusicUrl;
	
	public Integer FuncFlag;
	
}
