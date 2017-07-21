package com.xn.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;


/**
 * 时间工具类
 * 1.获取 Long 时间戳
 * 2.Long转时间
 * 3.获取当前时间
 * 4.字符串转时间
 * 5.时间比较
 * 6.时间差计算
 * 7.
 */
public class XnDateUtils {

	/**
	 * 获取时间戳
	 * @return long
	 */
	public static long getLongTime(){
		return new Date().getTime();
	}

	/**
	 * long 转时间
	 * @param strlongtime  时间戳
	 * @return D
	 */
	public static Date long2Time(long strlongtime){
		Date date = new Date(strlongtime);
		return date;
	}

	/**
	 * long数字的字符串 转时间
	 * @param strtime  时间戳
	 * @return D
	 */
	public static Date long2Time(String strtime){
		long lt = new Long(strtime);
		Date date = new Date(lt);
		return date;
	}

	/**
	 * 返回当前时间
	 * @param format 格式化字符串
	 * @return
	 */
	public static String getNow(String format){
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateTimeString = formatter.format(currentTime);
		return dateTimeString;
	}

	/**
	 * 返回当前时间和日期
	 * @return Date yyyy-MM-dd HH:mm:ss
	 */
	public static String getNow(){
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTimeString = formatter.format(currentTime);
		return dateTimeString;
	}

	/**
	 * 返回当前日期
	 * @return Date yyyy-MM-dd
	 */
	public static String getDate(){
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateTimeString = formatter.format(currentTime);
		return dateTimeString;
	}

	/**
	 * 返回当前时间
	 * @return Date HH:mm:ss
	 */
	public static String getTime(){
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateTimeString = formatter.format(currentTime);
		return dateTimeString;
	}

	/**
	 * 字符串转时间
	 * @param strDateTime 字符串时间
	 * @param pattern 字符串时间的格式，如 yyyy-mm-dd HH:mm:ss
	 * @return Date
	 */
	public static Date strToDateTime(String strDateTime, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = formatter.parse(strDateTime);
		} catch (ParseException e) {
			e.getMessage();
		}
		return date;
	}

	/**
	 * 字符串转时间
	 * @param strDateTime 字符串时间
	 * @return Date
	 */
	public static Date strToDateTime(String strDateTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(strDateTime);
		} catch (ParseException e) {
			e.getMessage();
		}
		return date;
	}

	/**
	 * 时间比较
	 * @param sDATE 格式：yyyy-MM-dd HH:mm:ss
	 * @param eDATE 格式：yyyy-MM-dd HH:mm:ss
	 * @return  sDATE>eDATE 时返回 1， sDATE<eDATE 时返回 -1，  sDATE=eDATE 时返回 0， 时间格式错误返回-2
	 */
	public static int dateCompare(String sDATE, String eDATE) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dt1 = df.parse(sDATE);
			Date dt2 = df.parse(eDATE);
			if (dt1.getTime() > dt2.getTime()) {
				return 1; //
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1; //
			} else {
				return 0;
			}
		} catch (ParseException e) {
			return -2;
		} catch (Exception exception) {
			return -3;
		}
	}

	/**
	 * 两个时间差
	 * @param sDATE
	 * @param eDATE
	 * @return HashMap<String, Long> key:  error： 错误码，d：天 ， h：时 ， m：分 ， s：秒
	 */
	public static HashMap<String, Long> dateDiff(String sDATE, String eDATE) {
		HashMap<String, Long> hmap = new HashMap();
		hmap.put("error", 0L);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date sd = df.parse(sDATE);
			Date ed = df.parse(eDATE);
			if (sd.getTime() > ed.getTime()) {
				hmap.put("error", -1L);
			} else {
				long between = (ed.getTime()-sd.getTime())/1000;
				hmap.put("d", (between/(24*3600)));
				hmap.put("h", (between%(24*3600)/3600));
				hmap.put("m", (between%3600)/60);
				hmap.put("s", (between%60));
			}
		} catch (ParseException e) {
			hmap.put("error", -2L);
		} catch (Exception exception) {
			hmap.put("error", -3L);
		}
		return hmap;
	}

}
