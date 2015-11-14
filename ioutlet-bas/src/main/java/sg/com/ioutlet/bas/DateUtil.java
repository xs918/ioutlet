package sg.com.ioutlet.bas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class DateUtil
{
	private static final String YYYY = "yyyy";

	private static final String MM = "MM";

	private static final String DD = "dd";

	private static final String FILE_NAME_FORMAT_DATETIME = "yyyyMMddHHmmss";

	private static final String FILE_NAME_FORMAT = "yyyyMMdd";

	public static String DATE_FORMAT = "dd/MM/yyyy"; // date format for

	// entire system

	public static String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

	public static String TIME_FORMAT = "HH:mm:ss";

	public static String DATE_FORMAT_WITH_DASH = "yyyy-MM-dd";

	// RETRIEVING DATES

	/**
	 * Get the date from input year, month and date
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Date getDate(int year, int month, int date)
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, date);
		return c.getTime();
	}

	/**
	 * Get the date from input year, month, date, hours, minute and seconds
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @param hour
	 * @param min
	 * @param sec
	 * @return
	 */
	public static Date getDate(int year, int month, int date, int hour, int min, int sec)
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, date);
		c.set(Calendar.HOUR, hour);
		c.set(Calendar.MINUTE, min);
		c.set(Calendar.SECOND, sec);
		return c.getTime();
	}

	/**
	 * This method returns the Year value of given date
	 * @param date
	 * @return
	 */
	public static int getYear(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	/**
	 * This method returns the Month value of given date
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}
	/**
	 * This method returns the Year value 
	 * @param date
	 * @return
	 */
	public static int getDate(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);
	}
	
	// CONVERTING STRING TO DATE

	/**
	 * From Date to String
	 * 
	 * @param date -
	 *            String in default dd/MM/yyyy format to convert to Date
	 */
	public static Date toDateFromString(String date)
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
			return df.parse(date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Return the Date object from yyMMdddd String
	 * 
	 * @param date
	 * @return
	 */
	public static Date toDateFromFileNameDateFormat(String date)
	{
		try
		{
			SimpleDateFormat fmt = new SimpleDateFormat(FILE_NAME_FORMAT);
			return fmt.parse(date);
		}
		catch (ParseException e)
		{
			return null;
		}
	}

	/**
	 * DEPRECATED use toDateFromString(String dateString, String format,TimeZone tz)
	 * Change the date String From one format to another format one
	 * 
	 * @param dateString
	 * @param oldPattern
	 * @param newPattern
	 * @return
	 */
	@Deprecated 
	public static Date toDateFromString(String dateString, String format)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(format);

		try
		{
			return fmt.parse(dateString);

		}
		catch (Exception e)
		{
		}
		return null;
	}	
	

	// CONVERTING DATE TO STRING

	/**
	 * From Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static String toStringFromDate(Date date)
	{
		return toFormattedDateString(date,DATE_FORMAT,null);
	}

	/**
	 * Return the date in yyyyMMdd format
	 * 
	 * @param date
	 * @return
	 */
	public static String toFileNameDateFormat(Date date)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(FILE_NAME_FORMAT);
		return fmt.format(date);
	}

	/**
	 * DEPRECATED. use toDateTimeFormat(Date date,TimeZone tz)
	 * Return the date in yyyyMMdd HHmmss format
	 * 
	 * @param date
	 * @return
	 */
	@Deprecated
	public static String toDateTimeFormat(Date date)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(DATE_TIME_FORMAT);
		return fmt.format(date);
	}
	
	/**
	 * Return the date in yyyyMMdd HHmmss format with specified TimeZone
	 * 
	 * @param date
	 * @return
	 */
	public static String toDateTimeFormat(Date date,TimeZone tz)
	{
		
		return toFormattedDateString(date,DATE_TIME_FORMAT,tz);
		
	}

	/**
	 * Return the date in yyyyMMdd format
	 * 
	 * @param date
	 * @return
	 */
	public static String toFileNameDateTimeFormat(Date date)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(FILE_NAME_FORMAT_DATETIME);
		return fmt.format(date);
	}

	/**
	 * DEPRECATED. use toFormattedDateString(Date date, String format,TimeZone t)
	 * Format Date according to given format
	 * 
	 * @param date
	 * @param format
	 * @return Stringz
	 * @throws ParseException
	 */
	@Deprecated
	public static String toFormattedDateString(Date date, String format)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	
	/**
	 * Format Date according to given format
	 * 
	 * @param date
	 * @param format
	 * @return String
	 * @throws ParseException
	 */
	public static String toFormattedDateString(Date date, String format,TimeZone tz)
	{
		
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		if(tz!=null)
			fmt.setTimeZone(tz);
		
		return fmt.format(date);
	}

	/**
	 * get current date value
	 * 
	 * @return java.lang.String
	 * @see getCurrentDate(Date d)
	 */
	public static String toCurrentDateString()
	{
		SimpleDateFormat df = new SimpleDateFormat(DD);
		String s = df.format(new Date());
		return s;
	}

	/**
	 * get current date value
	 * 
	 * @param d
	 * @return
	 */
	public static String toDateString(Date d)
	{
		SimpleDateFormat df = new SimpleDateFormat(DD);
		String s = df.format(d);
		return s;
	}

	/**
	 * get current month value
	 * 
	 * @return java.lang.String
	 * @see getCurrentMonth(Date d)
	 */
	public static String toCurrentMonthString()
	{
		String month;
		SimpleDateFormat df = new SimpleDateFormat(MM);
		month = df.format(new Date());
		return month;
	}

	/**
	 * get current month value
	 * 
	 * @param d
	 * @return java.lang.String
	 */
	public static String toMonthString(Date d)
	{
		String month;
		SimpleDateFormat df = new SimpleDateFormat(MM);
		month = df.format(d);
		return month;
	}

	/**
	 * get current year value
	 * 
	 * @return java.lang.String
	 * @see getCurrentYear(Date d)
	 */
	public static String toCurrentYearString()
	{
		SimpleDateFormat df = new SimpleDateFormat(YYYY);
		return df.format(new Date());
	}

	/**
	 * Return the year value in String
	 * 
	 * @param d
	 * @return
	 */
	public static String toYearString(Date d)
	{
		SimpleDateFormat df = new SimpleDateFormat(YYYY);
		return df.format(d);
	}

	/**
	 * The last day of month.
	 * 
	 * @param monthIndex
	 *            0-11
	 * @return
	 */
	public static int getLastDayOfMonth(int monthIndex)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, monthIndex);
		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * Return whether the specified date String is a valid date.
	 * 
	 * @param date -
	 *            the String object in date format (default date format to check
	 *            is dd/MM/yyyy)
	 * @return boolean
	 * 
	 */
	public static boolean isValidDate(String date)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			
			sdf.setLenient(false);
			if( sdf.parse(date) != null)
				return true;
		}
		catch (java.text.ParseException e)
		{
			return false;
		}
		return false;
	}
	/**
	 * Return whether the specified date String is a valid date.
	 * 
	 * @param date - The String object in date format
	 * @param pattern - The pattern the date is in
	 * @return boolean
	 * 
	 */
	public static boolean isValidDate(String date, String pattern)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			
			sdf.setLenient(false);
			if( sdf.parse(date) != null)
				return true;
		}
		catch (java.text.ParseException e)
		{
			return false;
		}
		return false;
	}

	// CHECKING

	/**
	 * Check the date is after
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean isAfter(String startDate, String endDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		try
		{
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			return start.after(end);
		}
		catch (ParseException e)
		{
			throw new SystemException(e.getMessage());
		}

	}

	// PROCESSING

	/**
	 * Return combination of date and time
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public static Date combineDateTime(Date date, Date time)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);

		if (time != null)
		{
			cal.setTime(time);
		}

		cal.set(year, month, day);
		return cal.getTime();
	}

	/**
	 * Adds the number of days to the given date
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addToGivenDate(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Adds the number of days to the current date
	 * 
	 * @param i
	 * @return
	 * @see addToDate
	 */
	public static Date addToDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Add the number of days to the input date
	 * 
	 * @param oraginalDate
	 * @param days
	 * @return
	 */
	public static Date addToDate(Date oraginalDate, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(oraginalDate);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Get the numbers of days differece
	 * 
	 * @param laterDate
	 * @param earlierDate
	 * @return
	 */
	public static int daysDifference(Date laterDate, Date earlierDate)
	{

		GregorianCalendar laterCal = new GregorianCalendar();
		laterCal.setTime(laterDate);
		laterCal.set(Calendar.HOUR_OF_DAY, 0);
		laterCal.set(Calendar.MINUTE, 0);
		laterCal.set(Calendar.SECOND, 0);
		laterCal.set(Calendar.MILLISECOND, 0);

		GregorianCalendar earlierCal = new GregorianCalendar();
		earlierCal.setTime(earlierDate);
		earlierCal.set(Calendar.HOUR_OF_DAY, 0);
		earlierCal.set(Calendar.MINUTE, 0);
		earlierCal.set(Calendar.SECOND, 0);
		earlierCal.set(Calendar.MILLISECOND, 0);

		float time = laterCal.getTimeInMillis() - earlierCal.getTimeInMillis();

		float days = (float) (time / (1000 * 60 * 60 * 24));

		return (int) days;
	}
	
	/***** ---------- FOR MULIT TIMEZONE, LOCALE ****************************/

	

	/**
	 * Return the formatted date string from Calendar using Calendar time zone.
	 * @param aCalendar
	 */
	public static String toFormattedDateString(Calendar cal){
		return toDateTimeFormat(cal.getTime(),cal.getTimeZone());
	}
	


	/**
	 * Return the formatted date string according to the format,time zone and locale specified
	 * @param aDate
	 * @param newPattern
	 * @param tz
	 * @param locale
	 * @return
	 */
	public static String toFormattedDateString(java.util.Date aDate, String newPattern,TimeZone tz,Locale locale) {
	    if(locale==null)locale=Locale.getDefault();
	    
        SimpleDateFormat sdf = new SimpleDateFormat(newPattern,locale);
        if(tz!=null)
        	sdf.setTimeZone(tz);
        
        return sdf.format(aDate);
    }
	
	
	/**
	 * To conver the string to Date with the given timezone
	 * @param dateString
	 * @param format
	 * @param tz
	 * @return
	 */
	public static Date toDateFromString(String dateString, String format,TimeZone tz)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		fmt.setTimeZone(tz);
		try
		{
			return fmt.parse(dateString);

		}
		catch (Exception e)
		{
		}
		return null;
	}
}
