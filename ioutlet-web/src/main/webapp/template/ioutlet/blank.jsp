<!DOCTYPE html>
<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Iolt | Starter</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/skins/skin-blue.min.css">
    

     <!-- REQUIRED JS SCRIPTS -->
         
    <s:url includeParams="none" id="scripts.main" value="/js/main.js"/>
    <script type="text/javascript" src="<s:property value="%{scripts.main}"/>"></script>
      
     <s:url includeParams="none" id="scripts.jQuery" value="/plugins/jQuery/jQuery-2.1.4.min.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.jQuery}"/>"></script>
   
    <s:url includeParams="none" id="scripts.moment" value="/js/moment.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.moment}"/>"></script>
   
     <s:url includeParams="none" id="scripts.combodate" value="/js/combodate.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.combodate}"/>"></script>
     
   
    <!-- Bootstrap 3.3.5 -->
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="<%=request.getContextPath()%>/dist/js/app.min.js"></script>
    
    
    <script src="<%=request.getContextPath()%>/js/moment.js"></script>
    
    <script src="<%=request.getContextPath()%>/js/combodate.js"></script>
   
     
  </head>
   <body>
   
   
   
     
     
   
  <s:if test="hasActionErrors()">  
  <div class="alert text-center alert-danger fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong><s:property value="%{getText('error.colon')}"/></strong> 
   
   <s:iterator value="actionErrors">
	<span class="msg"><s:property escape="false" />
	</span>
   </s:iterator>

  </div>
  </s:if>
  
  <s:if test="hasActionMessages()">  
   <div class="alert alert-info fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong><s:property value="%{getText('info')}"/></strong> 
     <s:actionmessage />
  </div>
  </s:if>
  
  
  
      
<%-- 	
			<s:if test="%{getErrorReport()!=null}">
			   <a href="#" class="show_hide">Show/Hide Error Report</a>
			    <div class="slidingDiv">
						<textarea name="address" style="width: 100%; height: 100%" wrap="hard" rows="18" readonly="readonly"><s:property value="%{getErrorReport()}"/></textarea>
				</div>
		    </s:if> --%>
		
    
          
         <section class="content">
           <tiles:insertAttribute name="content" />
         </section>
   
     
      
      

    
  
   
     
     

  </body>
</html>
