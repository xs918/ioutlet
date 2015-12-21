<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>KPMG Framework v2.0</title>
		<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/css/common/tags.css" />
		<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/css/common/struts.css" />
		<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/css<%=request.getContextPath()%>/main.css" />
</head>

<body>
	<br/>
	<br/>
	<center>
		<table id="contentBox" cellpadding="0" cellspacing="0" width="100%" height="100%">
			<tr>
				<td id="logo">
					<table cellpadding="0" cellspacing="0" width="100%" height="100%">
						<tr><td class="grayArea">&nbsp;</td><td class="whiteAreaTop">&nbsp;</td></tr>
						<tr><td class="grayArea" colspan="2" height="150px" align="center"><img src="<%=request.getContextPath()%>/images<%=request.getContextPath()%>/logo.gif" /></td></tr>
						<tr><td class="grayArea">&nbsp;</td><td class="whiteAreaBottom">&nbsp;</td></tr>
					</table>
				</td>
				<td id="content">
					
					<h1>Special Character Contains</h1>
					The request you have entered contains invalid characters. System does not accept ^#$%{}<>.
					Please remove the characters and try again.

				</td>
			</tr>
		</table>
		</center>
	</body>		
</html>