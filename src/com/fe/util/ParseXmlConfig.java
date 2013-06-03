package com.fe.util;
import java.io.ByteArrayInputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * XML解析类
 * @author fet
 *
 */
public class ParseXmlConfig implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4673796023084436158L;

	//public static final Logger logger = Logger.getLogger(ParseXmlConfig.class);
	

	public ParseXmlConfig ()
	{
		
	}
	
	/**
	 * 获取子节点信息
	 * @param e
	 * @param childName
	 * @return
	 */
	public String getChildText(Element e, String childName)
	{
		String str = "";
		
		try
		{
			if (null != e && null != childName && !"".equals(childName))
			{
				str = e.getChildText(childName)==null?"":e.getChildText(childName).trim();
			}
		}
		catch(Exception ex)
		{
			str = "";
		}

		return str;
	}
	
	/**
	 * 获取xml下父节点信息
	 * @param root
	 * @param name
	 * @return
	 */
	public List getContentList(Element root, String name)
	{
		List list = null;
		try
		{
			if (null != root && null != name && !"".equals(name))
			{
				list = root.getChild("xml").getChildren(name);
			}
		}
		catch (Exception e)
		{
			list = null;
		}
		return list;
	}
	
	/**
	 * 获取子节点
	 * @param e
	 * @param name
	 * @return
	 */
	public Element getElement(Element e, String name)
	{
		Element dt = null;
		try
		{
			if (null !=  e && null != name && !"".equals(name))
			{
				dt = e.getChild(name);
			}
		}
		catch (Exception ex)
		{
			dt = null;
		}
		return dt;
	}
	
	/**
	 * 解析报文
	 * @param xml
	 * @return
	 */
	public Element getElement(String xml)
	{
		Element root = null;
		try
		{
			if (null != xml && !"".equals(xml))
			{
				ByteArrayInputStream ins = new ByteArrayInputStream(xml.getBytes("utf-8"));
			
				SAXBuilder sax = new SAXBuilder();
				
				Document doc = sax.build(ins);
				
				root = doc.getRootElement();
				
			}
			return root;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return root;
	}
	

}
