package com.fe.base;

import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.jdom.Element;

import com.fe.bean.weixin.WX_MusicMessage_Response;
import com.fe.bean.weixin.WX_NewsMessage_Response;
import com.fe.bean.weixin.WX_TextMessage_Response;
import com.fe.bean.weixin.WX_NewsMessage_Response.Item;
import com.fe.constant.Constants;
import com.fe.util.CommonUtil;
import com.fe.util.Config;
import com.fe.util.ParseXmlConfig;
import com.fe.util.StringUtil;

public class BaseAction {

	private ParseXmlConfig config = new ParseXmlConfig();
	
	/**
	 * 微信平台验证使用
	 * @param timestamp
	 * @param nonce
	 * @param signature
	 * @param echostr
	 * @return
	 */
	public String vaildWeiXinPlantForm(String timestamp,String nonce,
			String signature,String echostr,String plant_token)
	{
		String[] ArrTmp = {plant_token, timestamp, nonce }; 
        Arrays.sort(ArrTmp); 
     
        StringBuffer sb = new StringBuffer(); 
     
        for(int i = 0 ;i < ArrTmp.length ;i++)
        {
        	sb.append(ArrTmp[i]);
        }
		
        String  pwd = new CommonUtil().Encrypt(sb.toString());
        
        System.out.println("pwd==" + pwd); 
  
        if(pwd.equals(signature))
        { 
            if(!"".equals(echostr)&& echostr != null)
            { 
            	return echostr;
        	}       
	    }
        
        return null;
	}
	
	/**
	 * 将处理接收到的XML转换为字符串
	 * @param reader
	 * @return
	 */
	public String dealRequestXML(BufferedReader reader) 
	{
		StringBuffer sb  = null;
		String line = "";
		//String rs = "";
		
		try 
		{ 
			sb = new StringBuffer();
			while ((line = reader.readLine()) != null) 
			{ 
				sb.append(line);
			}	
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("用户请求：" + sb.toString());
		
		//rs = sb.toString();

		return sb.toString();
	}
	
	/**
	 * 获取返回报文里的XML根节点
	 * @param inputXml
	 * @return
	 */
	public Element returnXmlRoot (String inputXml)
	{		
		return config.getElement(inputXml);	
	}
	
	/**
	 * 获取消息类型
	 * @param root
	 * @return
	 */
	public String returnMsgType (Element root)
	{
		return config.getChildText(root, Constants.MSGTYPE);	
	}
	
	
	/**
	 * 获取消息类型
	 * @param root
	 * @return
	 */
	public String returnElementText (Element root,String elementName)
	{
		return config.getChildText(root, elementName);	
	}
	
	/**
	 * XML字符串转化为实体REQUEST对象
	 * @param root
	 * @param MsgType
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Object xmlToObject(Element root,String MsgType) 
	throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> clazz = Class.forName(Config.WEIXIN_PACKAGE + returnRequestObjectName(MsgType));
		Object obj = clazz.newInstance();
		
		fillObjectValue(root,obj);
		
		return obj;
	}
	
	/**
	 * 组装REQUEST对象的类名
	 * @param msgType
	 * @return
	 */
	private String returnRequestObjectName(String msgType)
	{
		return Config.WEIXIN_OBJECT_BEGIN + 
		 String.valueOf(msgType.charAt(0)).toUpperCase() 
		+ String.valueOf(msgType.substring(1))
		+ Config.WEIXIN_OBJECT_END;
	}
	
	/**
	 * 请求对象赋值
	 * @param root
	 * @param inObject
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ClassNotFoundException 
	 * @throws InstantiationException 
	 */
	private Object fillObjectValue(Element root,Object inObject) 
	throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException
	{	
		Field[] dfList = inObject.getClass().getDeclaredFields();
			
		Field[] dfSupperList = inObject.getClass().getSuperclass().getDeclaredFields();
		
		//将父类及子类的所有属性字段合并
		Field[] bothList = (Field[])ArrayUtils.addAll(dfSupperList, dfList);
		
		for(Field df : bothList)
		{	
			df.setAccessible(true);
		    
			String value  = config.getChildText(root,df.getName());
			
			//String型数据的通用方法
			if(df.getType().equals(
					config.getChildText(root,df.getName()).getClass()))
			{
			   df.set(inObject,value);	
			}
			  
			else
			{
				//TODO 每增加一种类型就需要新增判断，需要完善
				if("java.lang.Integer".equals(df.getType().getName()))
				{
					df.set(inObject,Integer.parseInt(value));	
				}
				else if("java.lang.Long".equals(df.getType().getName()))
				{
					df.set(inObject,Long.parseLong(value));
				}	
			}
		}
		
		return inObject;
	}
	
	
	/**
	 * 根据请求消息类型进行组装响应 内容
	 * @param root
	 * @param MsgType
	 * @return
	 */
	public String objectToXml(Element root,Object responseObject1) 
	{
		String rs = null;
	
		String className = responseObject1.getClass().getName();
		
		//返回文字
		if(Constants.WEXIN_RESPONSE_BEAN_TEXT.equals(className))
		{
			rs = buildObjectToXml_Text((WX_TextMessage_Response)responseObject1);
		}
		
		//返回音乐
		else if(Constants.WEXIN_RESPONSE_BEAN_MUSIC.equals(className))
		{	
			rs = buildObjectToXml_Music((WX_MusicMessage_Response)responseObject1);
		}
		
		//返回图文
		else if(Constants.WEXIN_RESPONSE_BEAN_NEWS.equals(className))
		{			
			rs = buildObjectToXml_News((WX_NewsMessage_Response)responseObject1);
		}
		
		//未知类型
		else
		{	
			System.out.println("ERROR ： RESOPNSE TYPE "  + className);
		}
		
		return rs;
	}
	
	/**
	 * 文本返回报文
	 * @param input
	 * @return
	 */
	private String buildObjectToXml_Text(WX_TextMessage_Response input) 
	{
		String xmlResponse = 
			    "<xml>" +
				"<ToUserName><![CDATA["+ input.ToUserName +"]]></ToUserName>" +
				"<FromUserName><![CDATA[" + input.FromUserName + "]]></FromUserName>" +
				"<CreateTime>" + input.CreateTime + "</CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[" + input.Content + "]]></Content>" +
				"<FuncFlag>" + input.FuncFlag +"</FuncFlag>" +
				"</xml>";
		
		return xmlResponse;
	}
	
	/**
	 * 音乐返回报文
	 * @param input
	 * @return
	 */
	private String buildObjectToXml_Music(WX_MusicMessage_Response input) 
	{
		String xmlResponse = 
			    "<xml>" +
				"<ToUserName><![CDATA["+ input.ToUserName +"]]></ToUserName>" +
				"<FromUserName><![CDATA[" + input.FromUserName + "]]></FromUserName>" +
				"<CreateTime>" + input.CreateTime + "</CreateTime>" +
				"<Music>" +
				"<Title><![CDATA[" + input.Title + "]]></Title>" +
				"<Description><![CDATA[" + input.Description + "]]></Description>" +
				"<MusicUrl><![CDATA[" + input.MusicUrl + "]]></MusicUrl>" +
				"<HQMusicUrl><![CDATA[" + input.HQMusicUrl + "]]></HQMusicUrl>" +
				"</Music>" +
				"<FuncFlag>" + input.FuncFlag +"</FuncFlag>" +
				"</xml>";
		
		return xmlResponse;
	}
	
	/**
	 * 图文返回报文
	 * @param input
	 * @return
	 */
	private String buildObjectToXml_News(WX_NewsMessage_Response input) 
	{
		String xmlResponse = 
			    "<xml>" +
				"<ToUserName><![CDATA["+ input.ToUserName +"]]></ToUserName>" +
				"<FromUserName><![CDATA[" + input.FromUserName + "]]></FromUserName>" +
				"<CreateTime>" + input.CreateTime + "</CreateTime>" +
				"<MsgType><![CDATA[news]]></MsgType>" +
				"<ArticleCount>" + input.ArticleCount  +"</ArticleCount>" +
				
				"<Articles>" + 
				buildItenXmlResponse(input.Articles) +
		        "</Articles>" +
		        
				"<FuncFlag>" + input.FuncFlag +"</FuncFlag>" +
				"</xml>";
		
		return xmlResponse;
	}
	
	/**
	 * 图文多条拼装
	 * @param articlesList
	 * @return
	 */
	private String buildItenXmlResponse(List<Item> articlesList)
	{
		StringBuilder itemXmlResopnse = new StringBuilder(64);
			
		//最多返回10条
		int maxListSize =  articlesList.size() > 10  ? 10 : articlesList.size();
		
		for(int i = 0; i < maxListSize; i ++)
		{
			Item item = articlesList.get(i);
			itemXmlResopnse.append(
			"<item>" + 
			  "<Title><![CDATA[" + item.Title + "]]></Title>" +
			  "<Description><![CDATA[" + item.Description + "]]></Description>" +		 
			  "<PicUrl><![CDATA[" + item.PicUrl + "]]></PicUrl>" +	
			  "<Url><![CDATA[" + item.Url + "]]></Url>" +				
			 "</item>");
		}
		
		return itemXmlResopnse.toString();
	}
	
	
}
