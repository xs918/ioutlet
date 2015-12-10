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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ioutlet.css">

<script type="text/javascript">
	$(document).ready(function(){
		$('.edit').css('opacity',0.0);
		$('tr').hover(
			function(){
				$('.edit').stop().fadeTo('slow',1);
		    },
		    function(){
		    	$('.edit').stop().fadeTo('slow',0.0);
		    });
	});


</script>
</head>
<body>
<div class="box box-primary">
<div class="box-header with-border">
	
		<div class="row">
			<div class="col-md-2 input-lg">
				<input type="checkbox" value=""> Check All
			</div>
			<div class="col-md-5">
                  <div class="has-feedback">
                      <input type="text" class="form-control input-lg" placeholder="Search product by name,sno">
                      <span class="glyphicon glyphicon-search form-control-feedback"></span>
                  </div>
			</div>
			<div class="col-md-5">
				<button type="button" class="btn btn-lg btn-default btn-flat pull-right">Add A Product</button>
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
					<td>Testing</td>
					<td>$159.23</td>
					<td>in Stoken</td>
					<td>visible</td>
					<td class="edit">
						<i class="fa fa-files-o fa-2x"></i>
	    				<i class="fa fa-pencil-square-o fa-2x"></i>
					    <i class="fa fa-recycle fa-2x"></i>
					</td>
				</tr>
			</tbody>
		</table>
		<!-- /.table -->
	</div>
</div>	<!-- /.box-body -->





</body>
</html>
