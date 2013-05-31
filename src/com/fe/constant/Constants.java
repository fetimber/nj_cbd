package com.fe.constant;

public interface Constants {

	//存储返回json
	String RETRUN_OBJECT_JSON = "return_object_json";

	//存储返回XML
	String RETRUN_OBJECT_XML = "return_object_xml";

	//存储返回STRING
	String RETRUN_OBJECT_STRING = "return_object_string";
	
	//微信用户请求类型
	String WEXIN_MESSAGE_TYPE_TEXT = "text";
	
	String WEXIN_MESSAGE_TYPE_IMAGE = "image";
	
	String WEXIN_MESSAGE_TYPE_LINK = "link";
	
	String WEXIN_MESSAGE_TYPE_LOCATION = "location";
	
	String WEXIN_MESSAGE_TYPE_EVENT = "event";
	
	//微信用户响应类型
	String WEXIN_MESSAGE_TYPE_NEWS = "news";
	
	String WEXIN_MESSAGE_TYPE_MUSIC = "music";
	
	
	//判断微信信息类型标识
	String MSGTYPE = "MsgType";
	
	//返回给用户的消息类型
	String WEXIN_RESPONSE_BEAN_TEXT = "com.fe.bean.weixin.WX_TextMessage_Response";
	
	String WEXIN_RESPONSE_BEAN_MUSIC = "com.fe.bean.weixin.WX_MusicMessage_Response";
	
	String WEXIN_RESPONSE_BEAN_NEWS = "com.fe.bean.weixin.WX_NewsMessage_Response";
}
