<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<style type="text/css">
* {
	box-sizing: border-box;
}

*:focus {
	outline: none;
}

body {
	font-family: Arial;
	background-color: #3498DB;
	padding: 50px;
}

.login {
	margin: 20px auto;
	width: 300px;
}

.login-screen {
	background-color: #FFF;
	padding: 20px;
	border-radius: 5px
}

.app-title {
	text-align: center;
	color: #777;
}

.login-form {
	text-align: center;
}

.control-group {
	margin-bottom: 10px;
}

input {
	text-align: center;
	background-color: #ECF0F1;
	border: 2px solid transparent;
	border-radius: 3px;
	font-size: 16px;
	font-weight: 200;
	padding: 10px 0;
	width: 250px;
	transition: border .5s;
}

input:focus {
	border: 2px solid #3498DB;
	box-shadow: none;
}

.btn {
	border: 2px solid transparent;
	background: #3498DB;
	color: #ffffff;
	font-size: 16px;
	line-height: 25px;
	padding: 10px 0;
	text-decoration: none;
	text-shadow: none;
	border-radius: 3px;
	box-shadow: none;
	transition: 0.25s;
	display: block;
	width: 250px;
	margin: 0 auto;
}

.btn:hover {
	background-color: #2980B9;
}

.login-link {
	font-size: 12px;
	color: #444;
	display: block;
	margin-top: 12px;
}
</style>

</head>

<body>






	<form action="login" class="login" method="post">
		<div class="login-screen">

			<div class="app-title">
				<s:property value="getText('welcome.ioutlet')" />
				<h1>
					<s:property value="getText('login')" />
				</h1>
			</div>
			<div class="login-form">

				<div class="control-group">

					<div class="control-group">

						<s:textfield id="login-name" name="username"
							placeholder="%{getText('login.id')}" class="login-field" />
						<label class="login-field-icon fui-user" for="login-name"></label>

					</div>
					<div class="control-group">
						<s:password id="login-pass" name="password"
							placeholder="%{getText('login.pwd')}" class="login-field" />
						<label class="login-field-icon fui-lock" for="login-pass"></label>
					</div>
					<s:submit key="login" name="submit"
						class="btn btn-primary btn-large btn-block" />
					<a class="login-link" href="#">Lost your password?</a>
				</div>
			</div>
		</div>
	</form>

</body>


</body>
</html>