<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h2><s:property value="message"/></h2>

<h3>Languages</h3>
<ul>
    <li>
        <s:url id="url" action="index">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="index">
            <s:param name="request_locale">cn</s:param>
        </s:url>
        <s:a href="%{url}">中文</s:a>
    </li>
</ul>
