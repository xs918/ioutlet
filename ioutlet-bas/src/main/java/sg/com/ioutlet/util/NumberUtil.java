package sg.com.ioutlet.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.math.NumberRange;
import org.apache.commons.lang.math.NumberUtils;


public class NumberUtil {
	private static final String FORMAT_NUMBER_TO_162="##,###,###,###,##0.00";
	private static final String FORMAT_NUMBER_TO_96="##0.000000";
	/**To check on the value input is between the range
	 * @param limit1
	 * @param limit2
	 * @param value
	 * @return boolean
	 */
	public static boolean isBetween(Number limit1, Number limit2, Number value)
	{
		NumberRange nr = new NumberRange(limit1, limit2);
		return nr.containsNumber(value);
	}
	
	/**To check that the value input is a valid precision and scale
	 * @param validPrecision
	 * @param validScale
	 * @param value
	 * @return boolean
	 */
	public static boolean isValidPrecisionAndScale(int validPrecision, int validScale, Number value)
	{
		Validate.isTrue(validPrecision > 0, "'validPrecision' must not be non-positive.", validPrecision);
		Validate.isTrue(validScale >= 0, "'validScale' must not be negative.", validScale);
		
		String upperLimitString = StringUtils.repeat("9", validPrecision - validScale) + "." + StringUtils.repeat("9", validScale);
		String lowerLimitString = "-" + upperLimitString;

		BigDecimal lowerLimit = NumberUtils.createBigDecimal(lowerLimitString);
		BigDecimal upperLimit = NumberUtils.createBigDecimal(upperLimitString);

		boolean isValidPrecision = isBetween(lowerLimit, upperLimit, NumberUtils.createBigDecimal(value.toString()));
		boolean isValidScale = validScale > 0 ? ((BigDecimal) value).scale() <= validScale : true;

		return isValidPrecision && isValidScale;
	}
	/**
	 * To compare the value of 2 arguments
	 * @param a
	 * @param b
	 * @return return true if the first argument is bigger than second argument
	 */
	public static boolean isBiggerThan(BigDecimal a, BigDecimal b)
	{
		return a.compareTo(b)==1;
	}
	/**
	 * To compare the value of 2 arguments
	 * @param a
	 * @param b
	 * @return return true if the first argument is small than second argument
	 */
	public static boolean isSmallerThan(BigDecimal a, BigDecimal b)
	{
		return a.compareTo(b)==-1;
	}
	
	/**
	 * To compare the value of 1 arguments
	 * @param beforeFormat
	 * @return return formatted value (##,###,###,###,###.00)
	 */
	public static String formatNumberToStr162(String beforeFormat){
		//		16,2
		BigDecimal number = new BigDecimal(beforeFormat);
		number=number.setScale(2, BigDecimal.ROUND_HALF_UP);		
		DecimalFormat df = new DecimalFormat(FORMAT_NUMBER_TO_162);
		return df.format(number);
	}
	
	/**
	 * To compare the value of 1 arguments
	 * @param beforeFormat
	 * @return return formatted value (###.000000)
	 */
	public static String formatNumberToStr96(String beforeFormat){
		//		9,6
		BigDecimal number = new BigDecimal(beforeFormat);
		number=number.setScale(6, BigDecimal.ROUND_HALF_UP);
		DecimalFormat df = new DecimalFormat(FORMAT_NUMBER_TO_96);

		return df.format(number);
	}
	
	
	/**
	 * Format decimal with no comma
	 * @param value
	 * @return
	 */
	public String formatDecimalWoComma(String value)
	{
		DecimalFormat df = new DecimalFormat("###############0.00");
		if (value != null && !StringUtils.isEmpty(value))
			return df.format(Double.parseDouble(value));
		return value;
	}
	
}
