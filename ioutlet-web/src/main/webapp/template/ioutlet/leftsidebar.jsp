<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<!-- Sidebar user panel (optional) -->
<div class="user-panel">
	<div class="pull-left image">
		<img src="<s:property value="%{userProfileImageLink}"/>" class="img-circle"
			alt="User Image">
	</div>
	<div class="pull-left info">
		<p><s:property value="%{userProfile.name}"/></p>
		<!-- Status -->
		<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
	</div>
</div>

<!-- search form (Optional) -->
<%-- <form action="#" method="get" class="sidebar-form">
	<div class="input-group">
		<input type="text" name="q" class="form-control"
			placeholder="Search..."> <span class="input-group-btn">
			<button type="submit" name="search" id="search-btn"
				class="btn btn-flat">
				<i class="fa fa-search"></i>
			</button>
		</span>
	</div>
</form> --%>
<!-- /.search form -->

<!-- Sidebar Menu -->
<ul class="sidebar-menu">
	<li class="header">MAIN NAVIGATION</li>
	<!-- Optionally, you can add icons to the links -->
	
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
		 
	       	<li  class="treeview">
	       	    <a href=""> <i class="<s:property value="%{#menugroup.iconStyle}"/>"></i>
					<span>
					<s:property value="%{#menugroup.title}"/>
					</span><i class="fa fa-angle-left pull-right"></i>
			    </a>
			    
			    <ul class="treeview-menu">
					 <s:iterator value="#menugroup.menus.values" id="menu">
						 <s:url id="linkMenu" namespace="%{#menu.namespace}" action="%{#menu.action}">
						 <s:param name="sfld">true</s:param>
						 </s:url>
							<li><a href="<s:property value="%{linkMenu}"/>">
							<i class="<s:property value="%{#menu.iconStyle}"/>"></i>
								<s:property value="%{#menu.menuText}"/>
							</a></li>
					 </s:iterator>
			     </ul>
			     
			</li>

	   </s:else>
  </s:iterator>
</ul>
<!-- /.sidebar-menu -->
</html>
