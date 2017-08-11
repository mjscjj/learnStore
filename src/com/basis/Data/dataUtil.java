package com.basis.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class dataUtil {
	
	
	/** 
	 * 得到当前系统日期 
	 *  
	 * @return 当前时间的格式字符串，格式为"yyyy—mm-dd" 
	 */ 
	public static String getCurrentDate() {  
	    String pattern = "yyyy-MM-dd";  
	    SimpleDateFormat df = new SimpleDateFormat(pattern);  
	    Date today = new Date();  
	    String tString = df.format(today);  
	    return tString;  	
	}  
	  
	/** 
	 * 得到当前系统时间  
	 *  
	 * @return 当前时间的格式字符串，时间格式为"HH:mm:ss" 
	 */  
	public static String getCurrentTime() {  
	    String pattern = "HH:mm:ss";  
	    SimpleDateFormat df = new SimpleDateFormat(pattern);  
	    Date today = new Date();  
	    String tString = df.format(today);  
	    return tString;  
	}  
}