<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>


<head>
<title>Products</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/plugins/datatables/dataTables.bootstrap.css">

</head>
<body>
<div class="box box-primary">
<div class="box-header with-border">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<input type="checkbox" value=""> Check All
			</div>
			<div class="col-md-6">
                  <div class="has-feedback">
                      <input type="text" class="form-control input-sm" placeholder="Search product by name,sno">
                      <span class="glyphicon glyphicon-search form-control-feedback"></span>
                  </div>
			</div>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary">Add A Product</button>
			</div>
		</div>
	</div>
</div>
	<!-- /.box-header -->
	<div class="table-responsive">
		<table class="table table-hover">
			<tbody>
				<tr>
					<td><input type="checkbox" value=""></td>


					<td>
						<!-- User Image --> <img
						src="<s:property value="%{userProfileImageLink}"/>"
						class="img-circle" alt="User Image">

					</td>
					<td>SUEDE PEEP TOES</td>
					<td>$159.23</td>
					<td>in Stoken</td>
					<td>visible</td>
				</tr>

				<tr>
					<td><input type="checkbox" value=""></td>


					<td>
						<!-- User Image --> <img
						src="<s:property value="%{userProfileImageLink}"/>"
						class="img-circle" alt="User Image">

					</td>
					<td>SUEDE PEEP TOES</td>
					<td>$159.23</td>
					<td>in Stoken</td>
					<td>visible</td>
				</tr>

				<tr>
					<td><input type="checkbox" value=""></td>


					<td>
						<!-- User Image --> <img
						src="<s:property value="%{userProfileImageLink}"/>"
						class="img-circle" alt="User Image">

					</td>
					<td>SUEDE PEEP TOES</td>
					<td>$159.23</td>
					<td>in Stoken</td>
					<td>visible</td>
				</tr>


			</tbody>
		</table>
		<!-- /.table -->
	</div>
</div>	<!-- /.box-body -->





</body>
</html>
