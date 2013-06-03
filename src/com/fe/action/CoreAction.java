package com.fe.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fe.base.BaseAction;
import com.fe.bean.UserInfo;
import com.fe.constant.Constants;
import com.fe.service.ICoreService;
import com.fe.service.impl.CoreServiceImpl;
import com.fe.util.CommonUtil;
import com.fe.util.Config;
import com.fe.util.StringUtil;

@Controller
@Scope("singleton")
public class CoreAction extends BaseAction
{
	/**
	 * 微信平台验证使用
	 * @param request
	 * @param response
	 * @param session
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public void vaildWeixin_CorePlant(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			String signature,String timestamp,String nonce,String echostr)
	{
		//调用父类验证方法
		String rs = vaildWeiXinPlantForm(timestamp , nonce , 
				signature, echostr , Config.CORE_TOKEN);
		
		if(!"".equals(rs)&& rs != null)
        { 
           request.setAttribute(Constants.RETRUN_OBJECT_STRING, rs);
        }  
		
	}
	
	/**
	 * 根据用户输入返回内容
	 * @param request
	 * @param response
	 * @param session
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	@RequestMapping(value = "/test.do", method = RequestMethod.POST)
	public void responseWeixin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			String signature,String timestamp,String nonce,String echostr)
	{
		String rs = null;
		Element root;
		String msgType;
		
		try
		{
			//转换编码格式
			request.setCharacterEncoding("utf-8");
			//获取xml字符串
			rs = dealRequestXML(request.getReader());
			//获取xml解析为Element
	        root  = returnXmlRoot(rs);
	        //获取MsgType
	        msgType = returnMsgType(root);
	        //根据MsgType转换为wx_request对象 (xmlToObject)
			Object inObject = xmlToObject(root,msgType);
			//调用服务逻辑处理 封装为返回对象
			Object outObject = coreService.coreSerivce(inObject);
            //根据返回对象转换为xml字符串
			rs = objectToXml(root,outObject);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		
        request.setAttribute(Constants.RETRUN_OBJECT_STRING, rs);
	}
	
	
	@RequestMapping(value = "/test1.do", method = RequestMethod.GET)
	public void getTest(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
	{
		UserInfo user = new UserInfo();
		
//		user.setUserName("test1");
//		user.setUserPassWord("test2");
//		userDAO.addUser(user);
		request.setAttribute(Constants.RETRUN_OBJECT_JSON, user);
	
	}
		
	@RequestMapping(value = "/test2.do", method = RequestMethod.GET)
	public void getUserInfo(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
	{
		UserInfo user = new UserInfo();
//		user.setUserName("test1");
//		user = userDAO.findUser(user);
		request.setAttribute(Constants.RETRUN_OBJECT_JSON, user);
	}
	
  /*
	@Resource
	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
  */
	@Resource
	private ICoreService coreService;
	
	public void setCoreService(ICoreService coreService) {
		this.coreService = coreService;
	}

	public static void main(String[] args) throws Exception
	{
//		String requestXml =  "<xml>" +
//				"<ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName>" +
//				"<FromUserName><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName>" +
//				"<CreateTime>1368968791</CreateTime>" +             
//				"<MsgType><![CDATA[text]]></MsgType>" +
//				"<Content><![CDATA[测试内容]]></Content>" +
//				"<MsgId>5879676186589659142</MsgId></xml>";
//		
		//String requestXml = "<xml><ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName><FromUserName><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName><CreateTime>1369922829</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[????????????è??]]></Content><MsgId>5883773748598800410</MsgId></xml>";
		
		String requestXml = "<xml><ToUserName><![CDATA[gh_215fa9bb277c]]></ToUserName><FromUserName><![CDATA[oDhJ2jpAw7PdNX2P2n1unMC7Ay3k]]></FromUserName><CreateTime>1370053290</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[啊八年]]></Content><MsgId>5884334074327203896</MsgId></xml>";
		
		System.out.println(System.currentTimeMillis());
		
		CoreAction action = new CoreAction();
		
		String rs = requestXml;
		Element root;
		String msgType;
		
		//获取xml解析为Element
		root  = action.returnXmlRoot(rs);
		//获取MsgType
		msgType = action.returnMsgType(root);

		//根据MsgType转换为wx_request对象 (xmlToObject)
		Object inObject = action.xmlToObject(root,msgType);
		
		//调用服务逻辑处理 封装为返回对象
		CoreServiceImpl coretest = new CoreServiceImpl();
		Object outObject = coretest.coreSerivce(inObject);
		
		//根据返回对象转换为xml字符串
		rs = action.objectToXml(root,outObject);
		
		//1  获取xml解析为Element
        //2 获取MsgType据此转换为wx_request对象 (xml To InObject)
		//3  业务逻辑处理（未开发） 处理输入对象 并组装为响应对象   (InObject To OutObject)
		//4  根据返回的wx_resopnse对象，组装成为XML返回给微信平台 (OutObject To xml)
	}
}
