package com.fe.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.stringtree.json.JSONValidatingWriter;
import org.stringtree.json.JSONWriter;

import com.fe.constant.Constants;
import com.fe.util.JsonUtil;

@Component("baseInterceptorAdapter")
@Scope("singleton")
public class BaseInterceptorAdapter extends HandlerInterceptorAdapter {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
 
		if (request != null) 
		{
			Object obj = null;
			
			if(null != request.getAttribute(Constants.RETRUN_OBJECT_JSON))
			{
				obj = request.getAttribute(Constants.RETRUN_OBJECT_JSON);
				jsonResponse(request,response,obj);
			}
			else
			{
				obj = request.getAttribute(Constants.RETRUN_OBJECT_STRING);
				response.setCharacterEncoding("UTF-8");
				try 
				{
					PrintWriter writer  = response.getWriter();
					
					 if (writer != null) 
					 {
			             writer.print(obj.toString());
			             writer.flush();
			         }
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 *  //将结果对象转化为JSON串
	 * @param request
	 * @param response
	 * @param obj
	 */
	private void jsonResponse(HttpServletRequest request,
			HttpServletResponse response,Object obj)
	{	   
		JsonUtil jsonUtil = new JsonUtil();
		
		if (obj != null) 
		{
			JSONWriter jsonWriter = new JSONValidatingWriter();
			
			System.out.println("JSON VALUE:\n" + jsonWriter.write(obj) + "\n");
			
			jsonUtil.writeByStringtree(response, obj);
		}
		
	}

}
