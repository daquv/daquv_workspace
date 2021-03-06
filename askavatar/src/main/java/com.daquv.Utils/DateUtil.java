package com.daquv.Utils;


import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

@Slf4j
public class DateUtil {

	/**
	 * 年月日时分秒毫秒(无下划线) yyyyMMddHHmmssSSS
	 */
	public static final String dtLongs = "yyyyMMddHHmmssSSS";

	/**
	 * 年月日时分秒(无下划线) yyyyMMddHHmmss
	 */
	public static final String dtLong = "yyyyMMddHHmmss";

	/**
	 * 完整时间 yyyy-MM-dd HH:mm:ss
	 */
	public static final String simple = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 年月日 yyyy-MM-dd
	 */
	public static final String dtShort_ = "yyyy-MM-dd";

	/**
	 * 年月日(无下划线) yyyyMMdd
	 */
	public static final String dtShort = "yyyyMMdd";

	/**
	 * 时分秒(无下划线) HHmmss
	 */
	public static final String dtTime = "HHmmss";

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

	/** yyyy-MM-dd */
	public static final DateFormat dfDate = new SimpleDateFormat(DATE_FORMAT);
	/** yyyyMd */
	public static final DateFormat dfDateShort = new SimpleDateFormat("yyyyMd");
	/** yyyy-MM-dd HH:mm:ss */
	public static final DateFormat dfDateTime = new SimpleDateFormat(DATE_TIME_FORMAT);
	/** yyyy-MM-dd HH:mm */
	public static final DateFormat dfDateTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	/** yyyy/M/d/H */
	public static final DateFormat dfDateTime3 = new SimpleDateFormat("yyyy/M/d/H");
	/** yyyyMMdd_HHmmss */
	public static final DateFormat dfDateTime4 = new SimpleDateFormat("yyyyMMdd_HHmmss");
	/** yyyy-MM-dd HH:mm:ss.SSS */
	public static final SimpleDateFormat dfDateTime5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public static String getFormatDate(Date date) {
		if (date == null) {
			return "";
		}
		return dfDateTime2.format(date);
	}

	public static String getFormatDate(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 判断指定的年份是否为闰年
	 * 
	 * @date 2016-1-20 22:17:04
	 * @param year
	 * @return 如果是闰年，则返回true
	 */
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	public static Date getNewDateByAdd(Date d, int days) {
		int Year, Month, Day;
		boolean rYear;
		int DayOfMonths[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		Calendar cal;
		cal = Calendar.getInstance();
		cal.setTime(d);

		Year = cal.get(Calendar.YEAR);
		Month = cal.get(Calendar.MONTH);
		Day = cal.get(Calendar.DAY_OF_MONTH);

		Day = Day + days;

		if ((Year % 4 == 0 && Year % 100 != 0) || Year % 400 == 0) {
			rYear = true;
		} else {
			rYear = false;
		}

		if (rYear) {
			DayOfMonths[1] = 29;
		} else {
			DayOfMonths[1] = 28;
		}

		while (Day > DayOfMonths[Month]) {
			Day = Day - DayOfMonths[Month];
			Month++;
			if (Month > 11) {
				Month = 0;
				Year++;
			}
		}

		cal.set(Year, Month, Day);
		return cal.getTime();
	}

	public static Date getDateByString(String dateString) {
		if (dateString == null || dateString.trim().length() == 0)
			return null;
		Date resultDate = null;
		try {
			resultDate = dfDateTime5.parse(dateString.trim());
		} catch (ParseException pe) {
			// do nothing
		}
		return resultDate;
	}

	public static Date getSubtractedDate(int numberOfDate) {
		Calendar calendar = Calendar.getInstance();
		int substractedDays = numberOfDate *= -1;
		calendar.add(Calendar.DATE, substractedDays);
		return calendar.getTime();
	}

	/**
	 * 获 date 时间 elapsedHourValue 小时前的时间
	 * 
	 * @param elapsedHourValue
	 * @return
	 */
	public static Date getSubtractedDateByElapsedHourValue(Date date, long elapsedHourValue) {
		long elapsedTimeInMillis = elapsedHourValue * 60 * 60 * 1000;
		long currentTimeInMillis = date.getTime();

		long previousTimeInMillis = currentTimeInMillis - elapsedTimeInMillis;
		Date previousDate = new Date(previousTimeInMillis);
		return previousDate;
	}

	/**
	 * 获得当前时间 elapsedHourValue 小时前的时间
	 * 
	 * @param elapsedHourValue
	 * @return
	 */
	public static Date getSubtractedDateByElapsedHourValue(long elapsedHourValue) {
		long elapsedTimeInMillis = elapsedHourValue * 60 * 60 * 1000;
		long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();

		long previousTimeInMillis = currentTimeInMillis - elapsedTimeInMillis;
		Date previousDate = new Date(previousTimeInMillis);
		return previousDate;
	}

	/**
	 * 获得当前时间 elapsedHourValue 小时前的时间
	 * 
	 * @param elapsedHourValue
	 * @return
	 */
	public static Date getSubtractedDateByElapsedHourValue(int elapsedHourValue) {
		return getSubtractedDateByElapsedHourValue((long) elapsedHourValue);
	}

	/**
	 * 获 date 时间 elapsedHourValue 小时前的时间
	 * 
	 * @param elapsedHourValue
	 * @return
	 */
	public static Date getSubtractedDateByElapsedHourValue(Date date, int elapsedHourValue) {
		return getSubtractedDateByElapsedHourValue(date, (long) elapsedHourValue);
	}

	public static Date getSubtractedDateByElapsedHourValue(double elapsedHourValue) {
		long elapsedTimeInMillis = (long) (elapsedHourValue * 60.0 * 60.0 * 1000.0);
		long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();

		long previousTimeInMillis = currentTimeInMillis - elapsedTimeInMillis;
		Date previousDate = new Date(previousTimeInMillis);
		return previousDate;
	}

	public static Date getSubtractedDateByElapsedYearValue(int elapsedYearValue) {
		Calendar calendar = Calendar.getInstance();
		int currentYearValue = calendar.get(Calendar.YEAR);
		calendar.set(Calendar.YEAR, currentYearValue - elapsedYearValue);
		return new Date(calendar.getTimeInMillis());
	}

	public static Calendar getSubtractedCalendarByElapsedYearValue(int elapsedYearValue) {
		Calendar calendar = Calendar.getInstance();
		int currentYearValue = calendar.get(Calendar.YEAR);
		calendar.set(Calendar.YEAR, currentYearValue - elapsedYearValue);
		return calendar;
	}

	public static Calendar getBeginningOfDayCalendar() {
		Calendar beginningOfDayCalendar = Calendar.getInstance();
		beginningOfDayCalendar.set(Calendar.HOUR_OF_DAY, 0);
		beginningOfDayCalendar.set(Calendar.MINUTE, 0);
		beginningOfDayCalendar.set(Calendar.SECOND, 0);

		return beginningOfDayCalendar;
	}

	public static Date getBeginningOfDayDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		return new Date(c.getTimeInMillis());
	}

	// public static Date getDateFromString(String dateString, String parseString) {
	// long longDateValue=0L;
	// Date resultDate = null;
	// if(StringUtil.isEmpty(dateString))
	// return null;
	// List<String> monthDayYearStringList =
	// StringUtil.parseStringToList(dateString, parseString);
	// int year=0, month=0, day=0;
	//
	// try {
	// month = Integer.parseInt((String)monthDayYearStringList.get(1));
	//// logger.info("##### DateUtil.getDateFromString(), after parsing,
	// month="+month);
	// if(month > 0)
	// month = month-1;
	// day = Integer.parseInt((String)monthDayYearStringList.get(2));
	// year = Integer.parseInt((String)monthDayYearStringList.get(0));
	//// logger.info("##### DateUtil.getDateFromString(), after parsing,
	// month="+month+", day="+day+", year="+year);
	// longDateValue = getTimeValueByYearMonthDay(year, month, day);
	// resultDate = new Date(longDateValue);
	// } catch(NumberFormatException nfe) {
	// //do nothing
	// }
	// if(resultDate==null)
	// log.info("#####, within DateUtil.getDateFromString(), right before return,
	// longDateValue is NULL!!!!");
	//
	// return resultDate;
	// }

	public static long getTimeValueByYearMonthDay(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);

		return calendar.getTimeInMillis();
	}

	public static int getDifferentDaysBetweenTwoDates(Date beforeDate, Date afterDate) {
		// Get difference in milliseconds
		long diffMillis = afterDate.getTime() - beforeDate.getTime();

		// // Get difference in seconds
		// long diffSecs = diffMillis/(1000);
		//
		// // Get difference in minutes
		// long diffMins = diffMillis/(60*1000);
		//
		// // Get difference in hours
		// long diffHours = diffMillis/(60*60*1000);

		// Get difference in days
		long diffDays = diffMillis / (24 * 60 * 60 * 1000);

		return (int) diffDays;
	}

	/**
	 * 获取当月总天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getActualMaximumDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DATE);
	}

	public static int getNonceTimeKind(Date startDate, Date endDate, Date nonceDate) {
		long start = startDate.getTime();
		long end = endDate.getTime();
		long nonce = nonceDate.getTime();

		if (nonce < start) {
			return -1;
		} else if (nonce > end) {
			return 1;
		}

		return 0;
	}

	/**
	 * String ==> java.util.Date
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date dateString2Util(String dateStr, String format) {
		return new SimpleDateFormat(format).parse(dateStr, new ParsePosition(0));
	}

	/**
	 * java.util.Date ==> String
	 *
	 * @return
	 */
	public static String dateUtil2String(Date date, String format) {
		if (date == null)
			return null;
		return new SimpleDateFormat(format).format(date);
	}

	public static String dateUtil2StringDate(Date date) {
		if (date == null) {
			return null;
		}
		return dfDate.format(date);
	}

	public static String dateUtil2StringDateTime(Date date) {
		if (date == null) {
			return null;
		}
		return dfDateTime.format(date);
	}

	public static Date dateUtil2date(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(formatter.format(date), new ParsePosition(0));
	}

	/**
	 * java.util.Date ==> java.sql.Date
	 *
	 * @param date
	 * @return
	 */
	public static java.sql.Date dateUtil2SQL(Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * String ==> java.sql.Date
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static java.sql.Date dateString2SQL(String dateStr, String format) {
		Date date = dateString2Util(dateStr, format);
		return dateUtil2SQL(date);
	}

	/**
	 * String ==> java.sql.Timestamp
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Timestamp timestampString2SQL(String dateStr, String format) {
		Date date = dateString2Util(dateStr, format);
		if (null != date) {
			return new Timestamp(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * java.util.Date date ==> java.sql.Timestamp
	 *
	 * @param date
	 * @return
	 */
	public static Timestamp timestampDate2SQL(Date date) {
		if (null != date) {
			return new Timestamp(date.getTime());
		} else {
			return null;
		}
	}

	public static int getYear() {
		return new GregorianCalendar().get(Calendar.YEAR);
	}

	public static int getMonth() {
		return new GregorianCalendar().get(Calendar.MONTH) + 1;
	}

	public static String getMonthOfString() {
		int month = new GregorianCalendar().get(Calendar.MONTH) + 1;
		if (month < 10) {
			return "0" + month;
		}
		return month + "";
	}

	public static int getDay() {
		return new GregorianCalendar().get(Calendar.DATE);
	}

	public static String getDayOfString() {
		int day = new GregorianCalendar().get(Calendar.DATE);
		if (day < 10) {
			return "0" + day;
		}
		return day + "";
	}

	public static int getHour() {
		return new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
		// return new GregorianCalendar().get(Calendar.HOUR);
	}

	public static int getMinute() {
		return new GregorianCalendar().get(Calendar.MINUTE);
	}

	public static int getSecond() {
		return new GregorianCalendar().get(Calendar.SECOND);
	}

	public static String getDateTime() {
		return dfDateTime.format(new Date());
	}

	/**
	 * 获取当前日期，格式：yyyy/M/d/H
	 * 
	 * @author 胡海斌(Haibin.hu@okcoin.com)
	 * @return
	 */
	public static String getDatePath() {
		return dfDateTime3.format(new GregorianCalendar().getTime());
	}

	/**
	 * 获取当前日期，格式：yyyyMd
	 * 
	 * @author 胡海斌(Haibin.hu@okcoin.com)
	 * @return
	 */
	public static String getImageDatePath() {
		return dfDateShort.format(new GregorianCalendar().getTime());
	}

	/**
	 * 获取当前日期，格式：yyyy-MM-dd
	 * 
	 * @author 胡海斌(Haibin.hu@okcoin.com)
	 * @return
	 */
	public static String getCurrentDate() {
		return dfDate.format(new GregorianCalendar().getTime());
	}

	/**
	 * 获当前日期
	 *
	 * @param dateFormat
	 * @return String
	 */
	public static String getCurrentDate(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(new Date());
	}

	public static long getNumberOfDays(Date date) {
		long dateNumber = 0l;
		if (date == null) {
			return 0l;
		}
		Calendar beginningOfDayCalendar = Calendar.getInstance();
		beginningOfDayCalendar.setTime(new Date(System.currentTimeMillis()));
		beginningOfDayCalendar.set(Calendar.HOUR_OF_DAY, 0);
		beginningOfDayCalendar.set(Calendar.MINUTE, 0);
		beginningOfDayCalendar.set(Calendar.SECOND, 0);

		long beginningOfDayInMillis = beginningOfDayCalendar.getTimeInMillis();
		beginningOfDayCalendar.setTime(date);
		beginningOfDayCalendar.set(Calendar.HOUR_OF_DAY, 0);
		beginningOfDayCalendar.set(Calendar.MINUTE, 0);
		beginningOfDayCalendar.set(Calendar.SECOND, 0);
		long dateMillis = beginningOfDayCalendar.getTimeInMillis();
		// Date now=new Date(System.currentTimeMillis());
		// dateNumber=now.getTime()-date.getTime();
		dateNumber = beginningOfDayInMillis - dateMillis;
		dateNumber = dateNumber / (1000 * 60 * 60 * 24);
		if (dateNumber < 0) {
			dateNumber = 0;
		}
		return dateNumber;
	}

	public static String getChinaDate(Date date) {
		String s = "";
		Long temp;
		long days = getNumberOfDays(date);

		if ((days / 365) >= 1l) {
			temp = days / 365;
			s = temp.toString();
			s = s + "年前";
		} else if ((days / 31) >= 1l) {
			temp = days / 31;
			s = temp.toString();
			s = s + "月前";
		} else if ((days / 7) >= 1l) {
			temp = days / 7;
			s = s + "周前";
		} else {
			temp = days;
			if (temp == 0) {
				s = "今天";
			} else {
				s = temp.toString();
				s = s + "天前";
			}
		}
		return s;
	}

	public static Date getDateByString(String dateStr, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.getMessage();
			return null;
		}
	}

	public static Date[] getThisWeekStartAndEnd(int difDays, Date baseDate) {
		Date[] startEnd = new Date[2];
		Date startTime, endTime;
		Calendar start_date = Calendar.getInstance();
		if (baseDate != null)
			start_date.setTime(baseDate);
		start_date.add(Calendar.DAY_OF_YEAR, difDays);
		start_date.add(Calendar.DAY_OF_WEEK, -1);
		// logger.info(start_date.getTime().toLocaleString());
		start_date.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		start_date.set(Calendar.HOUR_OF_DAY, 0);
		start_date.set(Calendar.MINUTE, 0);
		start_date.set(Calendar.SECOND, 0);
		startTime = start_date.getTime();
		start_date.add(Calendar.DAY_OF_MONTH, 6);
		start_date.set(Calendar.HOUR_OF_DAY, 11);
		start_date.set(Calendar.MINUTE, 59);
		start_date.set(Calendar.SECOND, 59);
		endTime = start_date.getTime();
		startEnd[0] = startTime;
		startEnd[1] = endTime;
		return startEnd;

	}

	/**
	 * 根据当前的时间返回问候信息<br>
	 * (4,11]->上午好 (11,13]->中午好 (13,18]->下午好 其他->
	 * 
	 * @author 胡海斌(Haibin.hu@okcoin.com)
	 * @return
	 */
	public static String getPeriodOfTime() {
		switch (getHour()) {
			case 5 :
			case 6 :
			case 7 :
			case 8 :
			case 9 :
			case 10 :
			case 11 :
				return "上午好";
			case 12 :
			case 13 :
				return "中午好";
			case 14 :
			case 15 :
			case 16 :
			case 17 :
			case 18 :
				return "下午好";
			default :
				return "晚上好";
		}
		// if(DateUtil.getHour()>4&&DateUtil.getHour()<=11){
		// return "早上好";
		// }else if(DateUtil.getHour()>11&&DateUtil.getHour()<=13){
		// return "中午好";
		// }else if(DateUtil.getHour()>13&&DateUtil.getHour()<=18){
		// return "下午好";
		// }else{
		// return "晚上好";
		// }
	}

	public static Date getDateBetweenTwoDate(Date startDate, Date endDate) {
		Calendar beginningOfDayCalendar = Calendar.getInstance();
		Calendar endningOfDayCalendar = Calendar.getInstance();
		beginningOfDayCalendar.setTime(startDate);
		endningOfDayCalendar.setTime(endDate);
		long beginM = beginningOfDayCalendar.getTimeInMillis();
		long endM = endningOfDayCalendar.getTimeInMillis();
		long m = beginM;
		long difM = endM - beginM;
		if (difM <= 0) {
			return new Date(beginM);
		}

		Random r = new Random();
		long rM = r.nextLong();
		if (rM < 0) {
			rM = -1l * rM;
		}
		rM = rM % difM;
		m += rM;
		if (m < beginM) {
			m = beginM;
		}
		if (m > endM) {
			m = endM;
		}
		Date date = new Date(m);

		return date;
	}

	public static Date getDate() {
		Calendar beginningOfDayCalendar = Calendar.getInstance();
		beginningOfDayCalendar.set(Calendar.HOUR_OF_DAY, 0);
		beginningOfDayCalendar.set(Calendar.MINUTE, 0);
		beginningOfDayCalendar.set(Calendar.SECOND, 0);
		beginningOfDayCalendar.set(Calendar.MILLISECOND, 0);
		return beginningOfDayCalendar.getTime();
	}

	/**
	 * yyyyMMdd_HHmmss
	 * 
	 * @author 胡海斌(Haibin.hu@okcoin.com)
	 * @return
	 */
	public static String getDateStr() {
		return dfDateTime4.format(new GregorianCalendar().getTime());
	}

	/**
	 * 获得据今天dateNum间隔的时间
	 * 
	 * @param date
	 *            基准日期
	 * @param dateNum
	 *            时间间隔。
	 * @param type
	 *            dateNum代表的类型。如Calendar.SECOND代表秒, Calendar.DATE代表天
	 * @return 异常情况返回NULL
	 */
	public static Date getDate(Date date, int dateNum, int type) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(type, dateNum);
			return cal.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean getDateDispatchToHour(Date start, Date end) {
		long createDate = start.getTime();
		long currentDate = end.getTime();
		long result = currentDate - createDate;
		int date = (int) (result / (60 * 1000));
		boolean falg = false;
		if (date <= 0) {
			falg = true;
		}
		if (date >= 60) {
			date = (int) (date / 60);

			if (date >= 24) {
				date = (int) (date / 24);
				if (date <= 2) {
					falg = true;
				}
			} else {
				falg = true;
			}
		} else {
			falg = true;
		}
		return falg;
	}

	public static String getDateDispatch(Date start, Date end) {
		long createDate = start.getTime();
		long currentDate = end.getTime();
		long result = currentDate - createDate;
		int date = (int) (result / (60 * 1000));
		String str = date + "<span>分钟前</span>";
		if (date <= 0) {
			str = "<span>1分钟前</span>";
		}
		if (date >= 60) {
			date = (int) (date / 60);
			str = date + "<span>小时前</span>";
			if (date >= 24) {
				date = (int) (date / 24);
				str = date + "<span>天前</span>";
				if (date >= 30) {
					date = (int) (date / 30);
					str = date + "<span>个月前</span>";
				}
			}
		}
		return str;
	}

	public static String getDateDispatchChange(Date start, Date end, int type) {
		long createDate = start.getTime();
		long currentDate = end.getTime();
		long result = currentDate - createDate;
		int date = (int) (result / (60 * 1000));
		String str;
		if (type == 1) {
			str = date + "<span> minutes before</span>";
		} else {
			str = date + "<span>分钟前</span>";
		}

		if (date <= 0) {
			if (type == 1) {
				str = "<span>1分钟前</span>";
			} else {
				str = "<span>1 minutes before</span>";
			}
		}
		if (date >= 60) {
			if (type == 1) {
				date = (int) (date / 60);
				str = date + "<span> hours ago</span>";
				if (date >= 24) {
					date = (int) (date / 24);
					str = date + "<span> Days before</span>";
					if (date >= 30) {
						date = (int) (date / 30);
						str = date + "<span> months before</span>";
					}
				}
			} else {
				date = (int) (date / 60);
				str = date + "<span>小时前</span>";
				if (date >= 24) {
					date = (int) (date / 24);
					str = date + "<span>天前</span>";
					if (date >= 30) {
						date = (int) (date / 30);
						str = date + "<span>个月前</span>";
					}
				}
			}
		}
		return str;
	}

	public static String getDateDispatchByIndexPage(Date start, Date end) {
		long createDate = start.getTime();
		long currentDate = end.getTime();
		long result = currentDate - createDate;
		int date = (int) (result / (60 * 1000));
		String str = date + "<span>分钟前</span>登录过";
		if (date <= 0) {
			str = "<span>1分钟前</span>登录过";
		}
		if (date >= 60) {
			date = (int) (date / 60);
			str = date + "<span>小时前</span>登录过";
			if (date >= 24) {
				date = (int) (date / 24);
				str = date + "<span>天前</span>登录过";
				if (date > 5) {
					str = "";
				}
			}
		}
		return str;
	}

	public static String getDateStr(Date start, Date end) {
		long createDate = start.getTime();
		long currentDate = end.getTime();
		long result = currentDate - createDate;
		int date = (int) (result / (60 * 1000));
		String str = date + "分钟前";
		if (date <= 0) {
			str = "1分钟前";
		}
		if (date >= 60) {
			date = (int) (date / 60);
			str = date + "小时前";
			if (date >= 24) {
				date = (int) (date / 24);
				str = date + "天前";
				if (date >= 7) {
					date = (int) (date / 7);
					str = date + "周前";
					if (date >= 4) {
						str = dateUtil2String(start, DATE_FORMAT);
					}
				}
			}
		}
		return str;
	}

	public static long getDateDispatchNowToCurrentDayEnd() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		try {
			// 去除时分秒信息
			date = dfDate.parse(dfDate.format(date));
		} catch (ParseException e) {
			return 24 * 60 * 60 * 1000L;
		}
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.SECOND, -1);
		date = cal.getTime();

		Date cur_date = new Date(System.currentTimeMillis());
		return date.getTime() - cur_date.getTime();
	}

	public static String getTeamTaoLunDate(Date date) {
		long time = (System.currentTimeMillis() - date.getTime());
		if (time < 60 * 1000l) {
			return time / 1000 + "秒前";
		} else if (time < 60 * 60 * 1000l) {
			return time / (1000 * 60) + "分钟前";
		} else if (time < 24 * 60 * 60 * 1000l) {
			return dateUtil2String(date, "HH:mm");
		} else if (time < 30 * 24 * 60 * 60 * 1000l) {
			return dateUtil2String(date, "MM-dd");
		} else {
			return dateUtil2String(date, "yyyy-MM");
		}

	}

	/**
	 * 获取今天日期以前，或以后的时间 如果是正数则是以后的时间，如果是负数则是以前的时间
	 */
	public static Date getDateInHourAgo(Date date, int hourNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hourNum);
		return cal.getTime();
	}

	/**
	 * 获取当前日期是星期几
	 * 
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static int getWeekOfDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w <= 0)
			w = 7;

		return w;
	}

	/**
	 * date 日期加上，或减去几天
	 * 
	 * @param dateNum
	 * @return
	 */
	public static Date getDateInDayAgo(int dateNum) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, dateNum);
		return cal.getTime();
	}

	/**
	 * 连个日期相差的小时数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getHour(Date startDate, Date endDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		long totalDate = Math.abs((timeend - timestart)) / (1000 * 60 * 60);
		return totalDate;
	}

	/**
	 * 连个日期相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getDays(Date startDate, Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = Math.abs((timeend - timestart)) / (1000 * 60 * 60 * 24);
		return totalDate;
	}

	/**
	 * 传进日期是当年的第几周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * date 日期加上，或减去几天
	 * 
	 * @param date
	 * @param dateNum
	 * @return
	 */
	public static Date getDateInDayAgo(Date date, int dateNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, dateNum);
		return cal.getTime();
	}

	/**
	 * 获取 date 日期加上 或 减去几月
	 * 
	 * @param date
	 * @param monthNum
	 * @return
	 */
	public static Date getDateInMonthAgo(Date date, int monthNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, monthNum);
		return cal.getTime();
	}

	/**
	 * 获取两个日期之间的月数，end>start时最小间隔认为是1个月 收利息使用该方法
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getMonthSpace(Date start, Date end) {
		int count = 0;
		while (getDateInMonthAgo(start, count).before(end)) {
			count++;
		}
		return count;
	}

	public static Date getDateInMonthAgo(int monthNum) {
		return getDateInMonthAgo(new Date(), monthNum);
	}

	/**
	 * date 分钟
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date getDateInMinuteAgo(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}

	/**
	 * date 秒
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date getDateInSecondAgo(Date date, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, second);
		return cal.getTime();
	}

	/**
	 * 计算时间毫秒
	 * 
	 * @param inVal
	 * @return 返回毫秒数
	 */
	private static long fromDateStringToLong(String inVal) {
		Date date = null; // 定义时间类型
		try {
			date = dfDateTime.parse(inVal); // 将字符型转换成日期型
		} catch (Exception e) {
			e.getMessage();
		}
		return date.getTime(); // 返回毫秒数
	}

	public static long getMillisecond(String val1, String val2) {
		long startT = fromDateStringToLong(val1); // 定义上机时间
		long endT = fromDateStringToLong(val2); // 定义下机时间

		return startT - endT;
	}

	// 根据给定日期，返回该日期所在星期内的开始时间与结束时间
	public static String[] getMonAndSun(Date date) {
		String[] monAndSun = {"", ""};
		if (date == null)
			return monAndSun;

		int d = DateUtil.getWeekOfDate(date);
		Date mon = DateUtil.getDateInDayAgo(date, 1 - d);
		Date sun = DateUtil.getDateInDayAgo(date, 7 - d);
		monAndSun[0] = DateUtil.dateUtil2String(mon, DATE_FORMAT) + " 00:00:00";
		monAndSun[1] = DateUtil.dateUtil2String(sun, DATE_FORMAT) + " 59:59:59";
		return monAndSun;
	}

	// 返回给定时间的下下周一
	public static Date getLastDate(Date now) {
		if (now == null)
			now = new Date();
		Date lastDate = null;
		int d = DateUtil.getWeekOfDate(now);
		d = 15 - d;
		lastDate = DateUtil.getDateInDayAgo(now, d);
		return lastDate;
	}

	public static Date getNexWeek() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		Date date = cal.getTime();
		return date;
	}

	/**
	 * 获得下一个星期五
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNexFriday(Date date) {
		date = getDateInDayAgo(date, 14);
		int week = getWeekOfDate(date);
		if (week == 5) {
			return date;
		}
		Date d = null;
		int i = week - 5;
		if (i > 0) {
			d = getDateInDayAgo(date, -i);
		} else {
			i = 7 - (5 - week);
			d = getDateInDayAgo(date, -i);
		}
		return d;
	}

	/**
	 * 获得当前日期下个月的最后一个星期五日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastFriday(Date date) {
		date.setMonth(date.getMonth() + 2);
		date.setDate(1);
		// 获得这个月最后一天 判断星期
		Date d = getDateInDayAgo(date, -1);
		int week = getWeekOfDate(d);
		if (week == 5) {
			return d;
		}
		int i = week - 5;
		if (i > 0) {
			d = getDateInDayAgo(d, -i);
		} else {
			i = 7 - (5 - week);
			d = getDateInDayAgo(d, -i);
		}
		return d;
	}

	/**
	 * 判断 此时间是否在当前时间之后( 当前时间小于此时刻)
	 * 
	 * @param time
	 *            格式" 10:50:00"
	 * @return time>当前时刻 是 true 否 false
	 */
	public static boolean isAfterNowDate(String time) {
		String curDateStr = DateUtil.dateUtil2String(new Date(), DATE_FORMAT);
		Date curDate = DateUtil.dateString2Util(curDateStr + time, DATE_TIME_FORMAT);
		if (curDate == null) {
			return false;
		}
		return curDate.after(new Date());
	}

	/**
	 * 比较两个时刻
	 * 
	 * @param timeA
	 *            timeB 格式"2012-11-11 11:11:00"
	 * @return timeA>timeB是 true 否 false
	 */
	public static boolean compare(String timeA, String timeB) {
		Date dateA = DateUtil.dateString2Util(timeA, DATE_TIME_FORMAT);
		Date dateB = DateUtil.dateString2Util(timeB, DATE_TIME_FORMAT);
		if (dateA == null || dateB == null) {
			return false;
		}

		return dateA.after(dateB);
	}

	/**
	 * 获得当前时间elapsedSecondValue前后的时间
	 * 
	 * @param minutes
	 *            毫秒
	 * @return
	 */
	public static Date getSubtractedDateByElapsedMinutesValue(double minutes) {
		long elapsedTimeInMillis = (long) (minutes);
		long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();

		long previousTimeInMillis = currentTimeInMillis - elapsedTimeInMillis;
		Date previousDate = new Date(previousTimeInMillis);
		return previousDate;
	}

	/**
	 * 获得当前时间elapsedSecondValue前后的时间
	 * 
	 * @param elapsedSecondValue
	 * @return
	 */
	public static Date getSubtractedDateByElapsedSecondValue(double elapsedSecondValue) {
		long elapsedTimeInMillis = (long) (elapsedSecondValue * 60.0 * 1000.0);
		long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();

		long previousTimeInMillis = currentTimeInMillis - elapsedTimeInMillis;
		Date previousDate = new Date(previousTimeInMillis);
		return previousDate;
	}

	/**
	 * 获得当前时间elapsedSecondValue前后的时间
	 *
	 * @param elapsedSecondValue
	 *            分钟
	 * @return
	 */
	public static Date getSubtractedDateByElapsedSecondValue(long currentTimeInMillis, double elapsedSecondValue) {
		long elapsedTimeInMillis = (long) (elapsedSecondValue * 60.0 * 1000.0);

		long previousTimeInMillis = currentTimeInMillis - elapsedTimeInMillis;
		Date previousDate = new Date(previousTimeInMillis);
		return previousDate;
	}

	/**
	 * 获取一个月之前的日期
	 * 
	 * @return
	 */
	public static String lastMonth() {
		Date date = new Date();

		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date)) - 1;
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
		if (month == 0) {
			year -= 1;
			month = 12;
		} else if (day > 28) {
			if (month == 2) {
				if (year % 0 == 0 || (year % 4 == 0 && year != 0)) {
					day = 29;
				} else
					day = 28;
			} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
				day = 30;
			}
		}
		String y = year + "";
		String m = "";
		String d = "";
		if (month < 10)
			m = "0" + month;
		else
			m = month + "";
		if (day < 10)
			d = "0" + day;
		else
			d = day + "";

		return y + "-" + m + "-" + d;
	}

	/**
	 * 获得本周几的日期 周日是一周的第一天
	 * 
	 * @param week
	 * @return mm-dd
	 */
	public static String getWeekDate(int week) {
		int nowWeek = DateUtil.getWeekOfDate(new Date());
		int differDay = nowWeek == 7 ? (week == 7 ? 0 : week) : (week - nowWeek);
		String weekDate = DateUtil.dateUtil2String(DateUtil.getNewDateByAdd(new Date(), differDay), "MM-dd");
		return weekDate;
	}

	/**
	 * 获得指定日期的后一天
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 * @return
	 */
	public static String getAfterDay(String dateStr) {

		String afterDay = "";
		Date originDate = DateUtil.dateString2Util(dateStr, DATE_FORMAT);
		afterDay = DateUtil.dateUtil2String(DateUtil.getNewDateByAdd(originDate, 1), DATE_FORMAT);
		return afterDay;
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getPreDay(String dateStr) {
		String afterDay = "";
		Date originDate = DateUtil.dateString2Util(dateStr, DATE_FORMAT);
		afterDay = DateUtil.dateUtil2String(DateUtil.getNewDateByAdd(originDate, -1), DATE_FORMAT);
		return afterDay;
	}

	public static String getPreDay(String dateStr, int days) {
		String afterDay = "";
		Date originDate = DateUtil.dateString2Util(dateStr, DATE_FORMAT);
		afterDay = DateUtil.dateUtil2String(DateUtil.getNewDateByAdd(originDate, -days), DATE_FORMAT);
		return afterDay;
	}

	/**
	 * 获得本周几的日期 周一是一周的第一天
	 * 
	 * @param week
	 * @return mm-dd
	 */
	public static String getWeekDateFirstMonday(int week) {
		int nowWeek = DateUtil.getWeekOfDate(new Date());
		int differDay = nowWeek == 1 ? (week == 1 ? 0 : week) : (week - nowWeek);
		String weekDate = DateUtil.dateUtil2String(DateUtil.getNewDateByAdd(new Date(), differDay), DATE_FORMAT);
		return weekDate;
	}

	/**
	 * 根据秒数获得数据类型
	 * 
	 * @param second
	 * @return
	 */
	public static int returnDataType(int second) {
		int result = 0;
		switch (second) {
			case 60 :
				result = 0;
				break;
			case 180 :
				result = 7;
				break;
			case 300 :
				result = 1;
				break;
			case 900 :
				result = 2;
				break;
			case 1800 :
				result = 9;
				break;
			case 3600 :
				result = 10;
				break;
			case 7200 :
				result = 11;
				break;
			case 14400 :
				result = 12;
				break;
			case 21600 :
				result = 13;
				break;
			case 43200 :
				result = 14;
				break;
			case 86400 :
				result = 3;
				break;
			case 259200 :
				result = 15;
				break;
			case 604800 :
				result = 4;
				break;
			default :
				result = 2;
				break;
		}
		// 3:日 4:周 5:月 6:年 14:12小时 15：3日',
		return result;
	}

	public static String getWeekStr(Date day) {
		int week = getWeekOfDate(day);
		switch (week) {
			case 1 :
				return "星期一";
			case 2 :
				return "星期二";
			case 3 :
				return "星期三";
			case 4 :
				return "星期四";
			case 5 :
				return "星期五";
			case 6 :
				return "星期六";
			case 7 :
				return "星期日";
		}
		return "";
	}

	/**
	 * 返回长度为6最近的16点、8点、0点的日期数组
	 * 
	 * @return
	 */
	public static Date[] getDateInDayZero() {
		Date[] arrDate = new Date[6];
		Date date = new Date();
		date.setMinutes(0);
		date.setSeconds(0);
		if (date.getHours() < 8) {
			date.setHours(0);
		} else if (date.getHours() < 16) {
			date.setHours(8);
		} else {
			date.setHours(16);
		}
		for (int i = 0; i < 6; i++) {
			arrDate[i] = DateUtil.getDateInHourAgo(date, -8 * i);
		}
		return arrDate;
	}

	/**
	 * 通过通过间隔时间获取当前时间之前的时间点
	 * 
	 * @param date
	 *            时间
	 * @param interval
	 *            间隔
	 * @return
	 */
	public long compute_date(long date, long interval) {
		long ys = date % interval;
		long result = date - ys;
		return result;
	}

	public static String getDateStringByTimestamp(long ts) {
		Timestamp timestamp = new Timestamp(ts);
		return dfDateTime.format(timestamp);
	}

	public static int getYears(Date startDate, Date endDate) {
		int differ = 0;
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		int startYear = startCal.get(Calendar.YEAR);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		int endYear = endCal.get(Calendar.YEAR);

		Calendar compareCal = Calendar.getInstance();// 比较日期
		compareCal.setTime(startDate);
		compareCal.set(Calendar.YEAR, endYear);

		differ = endYear - startYear;
		if (compareCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			differ--;
		}

		return differ;
	}

	/**
	 * 根据时间差显示时间 目前只有后台工单系统使用
	 * 
	 * @param l
	 *            两Date的时间差
	 * @return 时间字符串
	 */
	public static String getStringByTime(long l) {
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

		String str = "";
		if (day > 0) {
			str = str + day + " ";
		}
		if (day > 0 || hour > 0) {
			str = str + hour + ":";
		}
		if (day > 0 || hour > 0 || min > 0) {
			str = str + min + ":";
		}
		str = str + s;
		return str;
	}

	/**
	 * 获取一周内的某一天
	 * 
	 * @param dayOfWeek
	 * @return
	 */
	public static Date getDateOfWeek(int dayOfWeek) {
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.set(7, dayOfWeek);
		calendarNow.set(11, 0);
		calendarNow.set(12, 0);
		calendarNow.set(13, 0);
		return calendarNow.getTime();
	}

	// 增加多长时间
	public static Date add(Date date, int field, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, value);
		return calendar.getTime();
	}

	/**
	 * 判断两个日期是否是同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

		return isSameDate;
	}

	/***
	 * 设置时间 小时 分钟 秒
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date setTime(int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		return calendar.getTime();
	}


}