package com.fe.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	
	
	 public static String get8859ByGBK(String str) 
	 {
	    try 
	    {
	      String temp_p = str;
	      byte[] temp_t = temp_p.getBytes("GB2312");
	      String temp = new String(temp_t, "ISO8859_1");
	      
	      return temp;
	    }
	    
	    catch (Exception e) 
	    {
	      System.out.println(e.toString());
	      str = "";
	    }
	   
	    return str;
     }
	 
	 
	 public static String getStringByGBK(String str) 
	 {
		try 
        {
		   str = new String(str.getBytes("ISO-8859_1"),"UTF-8");
		} 
        catch (UnsupportedEncodingException e) 
        {
			e.printStackTrace();
		}
        
		return str;
     }
	 
}
