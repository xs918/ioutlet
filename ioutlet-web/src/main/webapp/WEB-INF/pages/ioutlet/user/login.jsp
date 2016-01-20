<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
 <head>

 </head>
<body class="gray-bg">
 <div class="middle-box text-center loginscreen animated fadeInDown">
     <s:url id="regist" namespace="/regist" action="index">
			<s:param name="sfld">true</s:param>
	     </s:url>
	     

       <div>
                <h1 class="logo-name">ILT</h1>
       </div>
 
        <h3>Welcome to IOLT</h3>
            <p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
                <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
            </p>
            <p>Login in. To see sell your product.</p>
        <s:form  theme="bootstrap" action="form" method="post">
         <s:include value="/WEB-INF/pages/common/formparts/common.jsp" />    
		   <div class="form-group has-feedback">
		      <s:textfield id="login-name"  placeholder="%{getText('user.id')}" 
		       name="userId"   maxLength="50"/>
		      <span class="glyphicon glyphicon-user form-control-feedback"></span>
		     </div>
    
          <div class="form-group has-feedback">
           
            <s:password name="password" placeholder="%{getText('password')}"  maxLength="20" />
             <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <s:submit value="%{getText('sign.in')}" cssClass="btn btn-primary block full-width m-b" onclick="isSubmit('form')" />
           
            <a href="#"><small><s:property value="%{getText('i.forgot.my.password')}"/></small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="<s:property value='%{regist}'/>"> <s:property value="%{getText('register.a.new.membership')}"/></a>
            
          </s:form>


 <p class="m-t"> <small>Copyright © 2015 ThreeE pte Ltd.  All Rights Reserved  </small> </p>
 
 
 </div>
   
 </body>
</html>
