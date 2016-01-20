<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<s:url id="logout" value="/logout.jsp"></s:url>   

  <ul class="nav metismenu" id="side-menu">
	  <li class="nav-header">
	                        <div class="dropdown profile-element"> <span>
	                             <img alt="image" class="img-circle" src="<s:property value="%{userProfileImageLink}"/>" style="width:50px;height:50px">
	                             </span>
	                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
	                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
	                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
	                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
	                                <li><a href="profile.html">Profile</a></li>
	                                <li><a href="contacts.html">Contacts</a></li>
	                                <li><a href="mailbox.html">Mailbox</a></li>
	                                <li class="divider"></li>
	                                <li><a href="<s:property value="%{logout}"/>">Logout</a></li>
	                            </ul>
	                        </div>
	                        <div class="logo-element">
	                            ILT
	                        </div>
	   </li>
	   
	   <s:iterator value="menuItems" id="menugroup">
	 
	   <s:if test="%{#menugroup.size == 1 }">
			<s:url id="linkMenu" namespace="%{#menugroup.firstMenu.namespace}" action="%{#menugroup.firstMenu.action}">
			<s:param name="sfld">true</s:param>
	    	</s:url>
			<li><a href="<s:property value="%{linkMenu}"/>"> <i class="<s:property value="%{#menugroup.iconStyle}"/>"></i>
					<span>
					<s:property value="%{#menugroup.title}"/>
					</span>
			    </a>
			</li>

	   </s:if>
	   <s:else>
		 
		 
		   
		  
	       	<li>
		        <a href="#">
			        <i class="<s:property value="%{#menugroup.iconStyle}"/>"></i>
			       	<span class="nav-label"><s:property value="%{#menugroup.title}"/></span>
			       	<span class="fa arrow"></span>
		       	</a>
	       	 
	      
			    <ul class="nav nav-second-level collapse">
					 <s:iterator value="#menugroup.menus.values" id="menu">
						 <s:url id="linkMenu" namespace="%{#menu.namespace}" action="%{#menu.action}">
						 <s:param name="sfld">true</s:param>
						 </s:url>
						 
						    <li>
						        <a href="<s:property value="%{linkMenu}"/>">
						         <i class="<s:property value="%{#menu.iconStyle}"/>"></i>
						         
						         <s:property value="%{#menu.menuText}"/>
						        </a>
						    </li>
						 
					 </s:iterator>
			     </ul>
			     
			</li>

	   </s:else>
  </s:iterator>
  
  
   </ul>    

</html>
