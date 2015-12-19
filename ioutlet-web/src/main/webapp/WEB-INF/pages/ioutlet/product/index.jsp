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
		$('.fa').css("padding-right",20);
		$('.edit').css("vertical-align","bottom");
		$('.edit').css("text-align","right");
		$('.edit').css('opacity',0.0);
		$('table tr').hover(
			function(){
				$(this).find('.edit').stop().fadeTo('slow',1);
		    },
		    function(){
		    	$(this).find('.edit').stop().fadeTo('slow',0.0);
		    });
	});
</script>

</head>
<body>
<div class="box box-primary">
<s:form enctype="multipart/form-data" theme="bootstrap" action="form" method="post">
<s:include value="/WEB-INF/pages/common/formparts/common.jsp" />        
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
					   <s:submit cssClass="btn btn-lg btn-default btn-flat pull-right" onclick="isCustomSubmit('form','addButton')" />
			</div>
		</div>

</div>
	<!-- /.box-header -->
	<div class="table-responsive">
		<table class="table table-hover">
			<tbody>
			<s:iterator value="plist" id="pro">
				<tr>
				  <s:hidden id="%{#counter}" name="%{#counter}" value="%{#counter}"  />
				                
					<td><input type="checkbox" value=""></td>
					<td>
						<!-- User Image --> <img
						src="<s:property value="%{userProfileImageLink}"/>"
						class="img-circle" alt="User Image">

					</td>
					<td><s:property value="%{#pro.id}"/></td>
					<td><s:property value="%{#pro.description}"/></td>
					<td>in Stoken</td>
					<td>visible</td>
					<td class="edit">
						<i class="fa fa-files-o fa-2x"></i>
	    				<i class="fa fa-pencil-square-o fa-2x"></i>
					    <i class="fa fa-trash-o fa-2x"></i>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		<!-- /.table -->
	</div>
</s:form>
</div>	<!-- /.box-body -->





</body>
</html>
