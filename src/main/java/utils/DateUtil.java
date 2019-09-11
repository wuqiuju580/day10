package utils;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//		https://www.imooc.com/article/41686    工具类地址
/**
日期工具类:
	1.	根据日期算年龄
	2.	求未来日期离今天还剩的天数	
	3.	求过去日期离今天还剩的天数	
	4.	判断给定的日期是否为今天
	5.	判断给定的日期是否在本周之内
	6.	判断给定的日期是否在本月之内
	7.	给定时间对象，初始化到该月初的1月1日0时0分0秒0毫秒		
	8.	给定时间对象，设定到该月最一天的23时59分59秒999毫秒	
	9.	时间比较	
    @author wanghd
 */
public class DateUtil {
	
	public static void main(String[] args) {
		String birthday = "1992-06-14";
		Date date = stringToDate(birthday, "yyyy-MM-dd");
		
		
		int age = getAge(date);
		System.out.println(age);
		
		
	}
	
	
	/**
	 * 根据日期算年龄
	 */
	public static int getAge(Date birthday) {
        return getYearsBetween(birthday, new Date()) + 1;
    }
	
	 /**
     * 计算两个日期之间相差的周年数，忽略时间
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getYearsBetween(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);//用户生日
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH);
        int day1 = calendar.get(Calendar.DATE);

        calendar.setTime(endDate); //当前时间
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH);
        int day2 = calendar.get(Calendar.DATE);
        
        int result = year2 - year1;
        if (month2 < month1) {
            result--;
        } else if (month2 == month1 && day2 < day1) {
            result--;
        }
        return result;
    }
	
    /**
     *  日期转换字符串工具类
     * @param date
     * @param pattern    设置转换后的日期格式(yyyy-MM-dd HH:mm:ss)
     * @return
     */
	public static String dateToString(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	
	
	/**
     * 字符串转日期 
     * @param dateString   日期的字符串格式
     * @param format  	        日期格式   
     * @return
     */
    public static Date stringToDate(String dateString, String format){
        if(dateString == null) {
            throw new InvalidParameterException("dateString cannot be null!");
        }
        try {
            return new SimpleDateFormat(format).parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("parse error! [dateString:"+ dateString +";format:"+ format +"]");
        }
    }
	
	
	
	
}
