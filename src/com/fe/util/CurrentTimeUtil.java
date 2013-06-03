package com.fe.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentTimeUtil {

	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
	
	private static SimpleDateFormat df1 = new SimpleDateFormat("kkmmss");
	
	private static SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
	
	private static SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd:kk-mm-ss");
	
	//201101 YYmm
	public static String getCurrentYearAndMonth()
	{		
		return df.format(new Date());
	}
	
	//2011-01-01 yyyy-MM-dd
	public static String getCurrentYearAndMonthDay()
	{		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DAY_OF_MONTH, + 15);		
		return df3.format(calendar.getTime());
	}
	
	//2011-01-01 yyyy-MM-dd
	public static String getCurrentYearMonthDay()
	{		
		Calendar calendar = Calendar.getInstance(); 
		//calendar.add(Calendar.DAY_OF_MONTH,);		
		return df3.format(calendar.getTime());
	}
	
	//2011-01-01 yyyy-MM-dd
	public static String getCurrentTime()
	{		
		Calendar calendar = Calendar.getInstance(); 
		return df4.format(calendar.getTime());
	}
	
	//kkmmss
	public static String getCurrentMinutes()
	{		
		return df1.format(new Date());
	}
	
	//时间为秒
	public static boolean compareTime(String createTime,String currentTime,int time) 
	{
		 boolean rs = false; 
		 
		 SimpleDateFormat format = new SimpleDateFormat("kkmmss");    
		 Date date1;
		 Date date2;
		 try {
			date1 = format.parse(createTime);
			date2= format.parse(currentTime);
			if((date2.getTime() - date1.getTime())/1000 <= time)
		    {
		       rs = true;
		    }
		} catch (ParseException e) 
		{ }
		
		return rs;
	 }
	
	//时间为秒
	public static boolean compareActiveTime(String createTime,String currentTime,int time) 
	{
		 boolean rs = false; 
		 
		 SimpleDateFormat format = new SimpleDateFormat("kkmmss");    
		 Date date1;
		 Date date2;
		 try {
			date1 = format.parse(createTime);
			date2= format.parse(currentTime);
			if((date2.getTime() - date1.getTime())/1000 <= time)
		    {
		       rs = true;
		    }
		} catch (ParseException e) 
		{ }
		
		return rs;
	 }
	
	public static String monthList(int mount)
	{
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.MONTH, - mount);		
		return df2.format(calendar.getTime());
	}
	
	public static String getCurrentTime(String format) {
		return new java.text.SimpleDateFormat(format)
				.format(new java.util.Date());
	}
	
	//2011-01-01 yyyy-MM-dd
	public static boolean getBeforeDay(Date date)
	{		
		Calendar calendarStart = Calendar.getInstance(); 
		calendarStart.set(2011, 11, 01, 0, 0);
		calendarStart.add(Calendar.DAY_OF_MONTH, -2);
		
		Calendar calendarEnd = Calendar.getInstance(); 
		calendarEnd.set(2011, 11, 01, 24,  0);
		calendarEnd.add(Calendar.DAY_OF_MONTH, -1);
		
		System.out.println(calendarStart.getTime());
		System.out.println(calendarEnd.getTime());
		boolean rs = (calendarStart.getTime().compareTo(date)<= 0
				&& calendarEnd.getTime().compareTo(date) >= 0);
	
		return rs;
	}
	
	
	//2011-01-01 yyyy-MM-dd
	public static String getRealBeforeDay(Date date)
	{		
		Calendar calendar = Calendar.getInstance(); 
		//calendarStart.set(2011, 11, 01, 0, 0);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.getTime());
		
		return df3.format(calendar.getTime());
	}
	
	//返回某月最后一天
	public static String getLastDayOfMonth(String sTime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(sTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar   cal   =   Calendar.getInstance(); 
        cal.setTime(date); 
        cal.set(cal.get(Calendar.YEAR),   cal.get(Calendar.MONTH),   1,   0,   0,   0); 
        cal.add(Calendar.MONTH,   1); 
        cal.add(Calendar.DAY_OF_MONTH,   -1); 
        Date   newDate   =   cal.getTime();
        
        return dateToString(newDate, "yyyy-MM-dd");
	}
	
	//返回给定格式的日期字符串形式
	public static String dateToString(Date date, String formatStr) {
	    SimpleDateFormat formatDate = new SimpleDateFormat(formatStr);
	    return formatDate.format(date);
	} 
	
	public static void main(String[] args) throws ParseException
	{
		//System.out.println(CurrentTimeUtil.getBeforeDay());
		
//		Calendar calendarStart = Calendar.getInstance(); 
//		calendarStart.set(2011, 11, 01, 0, 0);
//		calendarStart.add(Calendar.DAY_OF_MONTH, 0);
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2012, 01, 05, 21, 30 , 0);
//		calendar.add(Calendar.MONTH, -1);
//		calendar.add(Calendar.SECOND, +5);
//		
		Calendar calendar1 = Calendar.getInstance();
		//calendar.add(Calendar.MONTH, -1);
		System.out.println("测试时间1" + calendar1.getTime());
//		System.out.println("测试时间2" + System.currentTimeMillis());
//		System.out.println("测试时间" + CurrentTimeUtil.df4.format(calendar1.getTime()));
        System.out.println("+++++== ====+==" + CurrentTimeUtil.getCurrentTime());
		//System.out.println(CurrentTimeUtil.getRealBeforeDay(new Date()));
		
//		String test1 = "151638";
//		String test2 = "152139";

//		System.out.println(compareTime(test1,test2,300));
//		String lastTime = "2008-08-08";
//		lastTime = lastTime.substring(0, lastTime.indexOf("-"))+"年"
//		+ lastTime.substring(lastTime.indexOf("-")+1, lastTime.lastIndexOf("-"))+"月"
//		+ lastTime.substring(lastTime.lastIndexOf("-"));
//        
//		System.out.println(lastTime);
	}
	
}
