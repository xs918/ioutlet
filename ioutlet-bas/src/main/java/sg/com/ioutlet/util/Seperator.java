package sg.com.ioutlet.util;

public enum Seperator {
	FIELD_SEPERATOR("|"),
	FIELD_VALUE_SEPERATOR("~"),
	LINE_SEPERATOR("^"),
	
	AUDIT_OBJECT_START("{"),
	AUDIT_LIST_START("["),
	AUDIT_FIELD_SEPERATOR(","),
	AUDIT_FIELD_VALUE_SEPERATOR(":"),
	AUDIT_EMPTY_VALUE("-"),
	AUDIT_LIST_END("]"),
	AUDIT_OBJECT_END("}"),
	
	
	PROPERTY_SEPERATOR("."),
	EXCEPTION_MESSAGE_SEPERATOR("|"),
	CONSTRAINTS_OPEN_BRACKET("{"),
	CONSTRAINTS_CLOSE_BRACKET("}");
	
	private String s;
	Seperator(String s) {
		this.s = s;
	}
	public String toString()
	{
		return s;
	}
	public String toRegexString()
	{
		return "\\"+s;
	}
}
