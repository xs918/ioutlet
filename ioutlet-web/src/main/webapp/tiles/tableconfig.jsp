<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:bean name="java.util.HashMap" id="strutsIconsConfig">
	<s:param name="customIconsPath" value="%{struts.icons.path}" />
</s:bean>

<s:bean name="java.util.HashMap" id="tableConfig">
	<s:param name="columnCount" value="%{0}" />
	<s:param name="maxColummPerRow" value="%{4}" /> 
</s:bean>