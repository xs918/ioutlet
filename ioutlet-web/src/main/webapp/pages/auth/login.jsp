<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="css/login.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">


<!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="pages/auth/photo.jpg" />
            <p id="profile-name" class="profile-name-card"></p>
            <s:form action="login" class="form-signin">	  
           	    <s:textfield id="login-name" name="username" placeholder="%{getText('login.id')}"  class="form-control" required="" oninvalid="this.setCustomValidity('%{getText('user.validate')}')"
    oninput="setCustomValidity('')" />
                <s:password id="inpuPassword" placeholder="Password" class="form-control" required=""  size="45" />
                <s:submit class="btn btn-lg btn-primary btn-block btn-signin" value="Sign in"></s:submit>
            </s:form>
            <s:url var="url" action="Welcome"></s:url>
        	<s:a href="%{url}" class="forgot-password">Forgot the password?</s:a>
        </div><!-- /card-container -->
    </div><!-- /container -->