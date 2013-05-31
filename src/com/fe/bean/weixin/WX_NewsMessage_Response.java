package com.fe.bean.weixin;

import java.util.List;

import com.fe.base.BaseResponseBean;

public class WX_NewsMessage_Response extends BaseResponseBean{
   /*
    <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName>
		 <CreateTime>12345678</CreateTime>
		 <MsgType><![CDATA[news]]></MsgType>
		 <ArticleCount>2</ArticleCount>
		 <Articles>
		 <item>
		 <Title><![CDATA[title1]]></Title> 
		 <Description><![CDATA[description1]]></Description>
		 <PicUrl><![CDATA[picurl]]></PicUrl>
		 <Url><![CDATA[url]]></Url>
		 </item>
		 <item>
		 <Title><![CDATA[title]]></Title>
		 <Description><![CDATA[description]]></Description>
		 <PicUrl><![CDATA[picurl]]></PicUrl>
		 <Url><![CDATA[url]]></Url>
		 </item>
		 </Articles>
		 <FuncFlag>1</FuncFlag>
    </xml>  
     
          参数	    描述
	ToUserName	 接收方帐号（收到的OpenID）
	FromUserName	 开发者微信号
	CreateTime	 消息创建时间
	MsgType	 news
	ArticleCount	 图文消息个数，限制为10条以内
	Articles	 多条图文消息信息，默认第一个item为大图
	Title	 图文消息标题
	Description	 图文消息描述
	PicUrl	 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。
	Url	 点击图文消息跳转链接
    */
	
//  public String ToUserName;
//	
//	public String FromUserName;
//	
//	public Integer CreateTime;
	
	public String MsgType = "news";
	
	public Integer ArticleCount; 
	
	public List<Item> Articles;
	
	public Integer FuncFlag;
	
	public class Item {
		public String Title;
		public String Description;
		public String PicUrl;
		public String Url;
			
	}
	
	
}
