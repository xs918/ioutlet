<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../resources/font-awesome/css/font-awesome.min.css">
<link href="../resources/metisMenue/dist/metisMenu.min.css"
	rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>





	<table class="table  table-hover">
		<tr>
			<td colspan="2">

				<nav class="navbar navbar-inverse navbar-static-top">
					<tiles:insertAttribute name="header" />
				</nav>


			</td>

		</tr>
		<tr>
			<td width="30%"><tiles:insertAttribute name="menu" /></td>
			<td width="70%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>



	<!-- jQuery -->
	<script src="../resources/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../resources/metisMenu/dist/js/metisMenu.min.js"></script>


</body>
</html>