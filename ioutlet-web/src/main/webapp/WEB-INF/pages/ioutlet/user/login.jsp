<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
 <head>

 </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="../../index2.html"><b>Iolt</b>login</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        
        <s:form  theme="bootstrap" action="form" method="post">
         <s:include value="/WEB-INF/pages/common/formparts/common.jsp" />    
		   <div class="form-group has-feedback">
		      <s:textfield id="login-name"  placeholder="%{getText('user.id')}" 
		       name="userId"   maxLength="50"/>
		      <span class="glyphicon glyphicon-user form-control-feedback"></span>
		     </div>
    
          <div class="form-group has-feedback">
           
            <s:password name="password" placeholder="%{getText('password')}"  maxLength="25" />
             <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <s:submit value="%{getText('sign.in')}" cssClass="btn btn-primary btn-block btn-flat" onclick="isSubmit()" />
            
            
          </s:form>

        <div class="social-auth-links text-center">
         <a href="#">
        
             <s:property value="%{getText('i.forgot.my.password')}"/>
         </a><br>
        <a href="register" class="text-center">
             <s:property value="%{getText('register.a.new.membership')}"/>
       </a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->
</div>
 </body>
</html>
