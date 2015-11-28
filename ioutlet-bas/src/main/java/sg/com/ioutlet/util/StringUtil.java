package sg.com.ioutlet.util;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	public static final char SPACE = ' ';
	private static final String spaceRegex = "\\s{1}";
	
	private static final String decimalFormat = "^(([-]?[0-9]+)([.]?([0-9]*))?)$";

	private static final String decimalFormat2dec = "^(([-]?[0-9]+)([.]([0-9]{1,2}))?)$";
	
	private static final String decimalFormat162dec = "^(([-]?[0-9]{1,14}+)([.]([0-9]{1,2}))?)$";
	
	private static final String decimalFormat6dec = "^(([-]?[0-9]+)([.]?([0-9]{1,6}))?)$";
	
	private static final String decimalFormat96dec = "^(([-]?[0-9]{1,3}+)([.]([0-9]{1,6}))?)$";
	
	public static final String specialCharacters = "<>'\"&;$";
	
	private static final String specialCharactersRegex = ".*([" + specialCharacters  + "]).*";

	private static final String moneyFormat = "([0-9]{1,8})(\\.[0-9]{1,2})?";

	private static final String dateFormat = "([1-9]|0[1-9]|[12][0-9]|3[0-1])[/]([1-9]|0[1-9]|1[012])[/](19\\d{2}|2\\d{3})";

	private static final String noSpecialCharFormat = "^([a-zA-Z0-9])+$";

	private static final String alphanumericWithUnderscoreFormat = "^([a-zA-Z0-9_])+$";

//	private static final String emailFormat = "^([a-zA-Z0-9_\\.\\-])+@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
	
	private static final String urlFormat = "([A-Za-z][A-Za-z0-9+.-]{1,120}:[A-Za-z0-9/](([A-Za-z0-9$_.+!*,;/?:@&~=-])|%[A-Fa-f0-9]{2}){1,333}(#([a-zA-Z0-9][a-zA-Z0-9$_.+!*,;/?:@&~=%-]{0,1000}))?)";
	
	/**
	 * Split the string with space ' ' and put them to array
	 * 
	 * @param input
	 * @return String[] splitted values
	 */
	public static String[] toStringArray(String input)
	{
		return toStringArray(input, null);
	}

	/**
	 * Split the string with delim and put them to array
	 * 
	 * @param input
	 * @param delim
	 * @return String[] splitted values
	 */
	public static String[] toStringArray(String input, String delim)
	{
		if (input != null)
		{
			StringTokenizer st;
			if (delim == null)
				st = new StringTokenizer(input);
			else
				st = new StringTokenizer(input, delim);
			int count = st.countTokens();
			if (count <= 0)
				return null;
			else
			{
				String[] params = new String[count];
				for (int i = 0; i < params.length; i++)
				{
					params[i] = st.nextToken();
				}
				return params;
			}
		}
		return null;
	}

	/**
	 * Format the array of strings to one string with the passed in delimiter
	 * 
	 * @param input
	 * @param delimiter
	 * @param replaceDelimiter
	 * @return delimited String
	 */
	public static String toDelimitedString(String[] input, String delimiter, String replaceDelimiter)
	{
		if (input == null || delimiter == null)
		{
			return null;
		}
		StringBuffer sb = new StringBuffer("");
		try
		{
			for (int i = 0; i < input.length; i++)
			{
				if (input[i] == null) input[i] = "";
				if (replaceDelimiter != null && delimiter.length() == 1) input[i] = input[i].replaceAll("[" + delimiter + "]", replaceDelimiter);
				sb.append(input[i]);
				if (i < input.length - 1)
				{
					sb.append(delimiter);
				}
			}
			input = null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		String result = sb.toString();
		sb = null;
		return result;
	}

	/**
	 * Combine the 2 String arrays into 1.
	 * 
	 * @param first array
	 * @param second array
	 * @return first + second
	 */
	public static String[] joinStringArrays(String[] a, String[] b)
	{
		if (a == null && b == null) return null;
		if (a == null) return b;
		if (b == null) return a;
		String[] c = new String[a.length + b.length];
		for (int i = 0; i < a.length; i++)
		{
			c[i] = a[i];
		}
		for (int j = a.length; j < c.length; j++)
		{
			c[j] = b[j - a.length];
		}
		return c;
	}


	/**
	 * Will append the space for remaining characters to achieve the fix length
	 * String
	 * 
	 * @param input
	 * @param length
	 * @return String Fix Length
	 */
	public static String toFixLength(String input, int length)
	{
		if (input != null)
		{
			int inLength = input.length();
			int spaceCount = length - inLength;
			StringBuffer sb = new StringBuffer(input);
			if (spaceCount > 0)
			{
				for (int i = 0; i < spaceCount; i++)
				{
					sb.append(SPACE);
				}
			}
			return sb.toString();
		}
		return input;
	}

	
	/**
	 * Format the array of strings and append them together to one string
	 * 
	 * @param input
	 * @param length
	 * @return String combined field
	 */
	public static String toFixLength(String[] input, int[] length)
	{
		if (input != null)
		{
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < input.length; i++)
			{
				String inp = input[i];
				if (inp == null)
				{
					inp = "";
				}
				sb.append(inp);
				int inLength = inp.length();
				int spaceCount = length[i] - inLength;
				if (spaceCount > 0)
				{
					for (int j = 0; j < spaceCount; j++)
					{
						sb.append(SPACE);
					}
				}
			}
			return sb.toString();
		}
		return null;
	}

	/**
	 * 
	 * @param fixlength
	 * @param colLength
	 * @return
	 */
	public static String[] toStringArrayFromFixLength(String fixlength, int[] colLength)
	{
		String[] data = new String[colLength.length];
		int pointer = 0;
		if (fixlength != null)
		{
			int size = colLength.length;
			int max = fixlength.length();
			int end = 0;
			for (int i = 0; i < size; i++)
			{
				end = pointer + colLength[i];
				if (end > max)
				{
					end = max;
				}
				data[i] = fixlength.substring(pointer, end);
				pointer += colLength[i];
			}
		}
		return data;
	}

	/**
	 * Convert to int. If input is null or not integer will return -1
	 * 
	 * @param input
	 * @return result
	 */
	public static int toInt(String input)
	{
		try
		{
			return Integer.parseInt(input);
		}
		catch (Exception e)
		{
		}
		return -1;
	}

	/**
	 * Convert the String Array to int Array
	 * 
	 * @param input
	 * @return
	 */
	public static int[] toIntArray(String[] input)
	{
		int[] values = new int[input.length];
		for (int i = 0; i < input.length; i++)
		{
			values[i] = toInt(input[i]);
		}
		return values;
	}

	/**
	 * Convert the String input to boolean. 
	 * [ true, TRUE or 1  ] will return true
	 * [ false, FALSE or 0] will return false
	 * @param input
	 * @return
	 */
	public static boolean toBoolean(String input)
	{
		if(StringUtils.isEmpty(input))
			return false;
		if(input.equalsIgnoreCase("TRUE") || input.equalsIgnoreCase("1"))
			return true;
		else if(input.equalsIgnoreCase("FALSE") || input.equalsIgnoreCase("0"))
			return false;
		return false;
		
	}
	/**
	 * build String from a Vector <br>
	 * <B>Example: </B> <BR>
	 * with Vector: 0, 1, 2, 3;<BR>
	 * you will get: <BR>
	 * String: (0,1,2,3)
	 * 
	 * @param value
	 *            A java.util.ArrayList
	 * @param type
	 *            int
	 *            <li>type 0: (0,1,2,3)
	 *            <li>type 1: ('0','1','2','3')
	 * @return String built from ArrayList and split by comma or comma with
	 *         single quotation marks
	 */
	public static String buildStringFromArrayList(ArrayList value, int type)
	{
		if (value == null || value.size() == 0)
		{
			return new String("()");
		}
		StringBuffer sb = new StringBuffer("(");
		for (int i = 0; i < value.size(); i++)
		{
			if (type == 1)
			{
				sb.append("'");
			}
			sb.append((String) value.get(i));
			if (type == 1)
			{
				sb.append("'");
			}
			if (i < value.size() - 1)
			{
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}


	/**
	 * It is date
	 * @param input
	 * @return
	 */
	public static boolean isDate(String input)
	{
		return input.matches(dateFormat);
	}

	/**
	 * Make sure there is not special characters
	 * @param input
	 * @return
	 */
	public static boolean isNonSpecialChar(String input)
	{
		boolean exist = true;
		if (!(input.trim()).matches(noSpecialCharFormat))
		{
			exist = true;
		}
		else
		{
			exist = false;
		}
		return exist;
	}

	/**
	 * Only alpha numeric with under scores
	 * @param input
	 * @return
	 */
	public static boolean isAlphanumericWithUnderscore(String input)
	{
		boolean exist = true;
		if (!(input.trim()).matches(alphanumericWithUnderscoreFormat))
		{
			exist = true;
		}
		else
		{
			exist = false;
		}
		return exist;
	}
	

	/**
	 * Check the input value is decimals
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isMoney(String input)
	{
		return input.matches(moneyFormat);
	}

	/**
	 * Check the input value is decimals
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isDecimal(String input)
	{
		return input.matches(decimalFormat);
	}

	/**
	 * Check the input value is decimals
	 * 
	 * @param input
	 * @return
	 */
	public static boolean is2Decimal(String input)
	{
		return input.matches(decimalFormat2dec);
	}
	
	/**
	 * Check the input value is decimals
	 * 
	 * @param input
	 * @return
	 */
	public static boolean is6Decimal(String input)
	{
		return input.matches(decimalFormat6dec);
	}
	

	
	/**
	 * The value is one of the item inside the container.
	 * @param container String[]
	 * @param value String
	 * @return
	 */
	public static boolean isIn(String[] container, String value)
	{
		if(value == null || container == null)
			return false;
		for(int i=0;i <container.length; i ++)
		{
			if(container[i].trim().equals(value.trim()))
				return true;
		}
		return false;
	}
	/**
	 * Checks for the format of an email address
	 * @param input
	 * @return
	 */
	public static boolean isEmail(String input)
	{
		if(StringUtils.isEmpty(input))
			return false;
		try
		{
			InternetAddress ia = new InternetAddress(input);
			ia.validate();
			return true;
		}
		catch (AddressException e)
		{
			return false;
		}
	}
	
	/**
	 * Checks for existence of special characters
	 * @param input
	 * @return true if the special characters exists
	 */
	public static boolean hasSpecialCharacters(String input)
	{
//		return (input.trim()).matches(specialCharacters);
		return (input.trim()).matches(specialCharactersRegex);
	}
	
	/**
	 * Checks for the max length of 9 digits and 6 decimal places
	 * @param input
	 * @return true if the format is correct
	 */
	public static boolean is96NumericFormat(String input)
	{
		return input.matches(decimalFormat96dec);
	}
	/**
	 * Checks for the max length of 16 digits and 2 decimal places 
	 * @param input
	 * @return true if the format is correct
	 */
	public static boolean is162NumericFormat(String input)
	{
		return input.matches(decimalFormat162dec);	
	}
	
	
	/**
	 * Checks for the max length of 16 digits and 2 decimal places regardless of sign (positive or negative)
	 * @param input
	 * @return true if the format is correct
	 */
	public static boolean is162NumericFormatIgnoredSign(String input)
	{
		return input.matches(decimalFormat162dec);	
	}
	
	
	/**
	 * Checks for the format "http://www.domain.com"  
	 * @param input
	 * @return true if the format is correct
	 */
	public static boolean isURLFormat(String input){
		
		String str = input.trim();
		
		if(str.matches(urlFormat))
		{
			return true;
		}else
			return false;
	}
	
	public static boolean containsSpace(String input){
		
		String str = input.trim();
		
		return Pattern.compile(spaceRegex).matcher(str).find();
		
	}
	
}
