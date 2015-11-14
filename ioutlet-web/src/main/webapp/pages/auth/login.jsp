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
         
           	    <s:textfield id="login-name" name="username"
							placeholder="%{getText('login.id')}"  class="reauth-email"/>
					
           	    <s:textfield id="login-name" name="username"
							placeholder="%{getText('login.id')}"  class="reauth-email"/>
			
           
             
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
             </s:form>
        </div><!-- /card-container -->
    </div><!-- /container -->