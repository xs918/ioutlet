<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>


<head>
<title>Products</title>
<meta charset="utf-8">
<script type="text/javascript">
	$(document).ready(function(){
	
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
		<table class="table table-hover">
			<tbody>
			<s:iterator value="plist" id="pro">
				<tr>
				  <s:hidden id="%{#counter}" name="%{#counter}" value="%{#counter}"  />
				                
					<td><input type="checkbox" value=""></td>
					<td>	
						<a href="<s:property value="%{userProfileImageLink}"/>">
	          				<img src="<s:property value="%{userProfileImageLink}"/>"  class="img-circle" alt="productimages" style="width:150px;height:150px">
	        			</a>
					</td>
					<td><s:property value="%{#pro.id}"/></td>
					<td><s:property value="%{#pro.description}"/></td>
					<td>in Stoken</td>
					<td>visible</td>
					<td class="edit">
						<i class="fa fa-files-o fa-2x" onclick="popupEdit();return false;"></i>
	    				<i class="fa fa-pencil-square-o fa-2x" onclick='isChoose(this)' ></i>
					    <i class="fa fa-trash-o fa-2x"></i>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		<!-- /.table -->
		
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
      </div>
      <div class="modal-body">
      <!-- modal body below -->
      <table style="width:100%">
          <tr><td><label>Description</label></td></tr>
	      <tr><td><s:textfield name="testing" value="1hao" /></td></tr>
	      <tr><td><label>Stock</label></td></tr>
		  <tr><td><s:textfield name="testing" value="1hao" /></td></tr>
		  <tr><td><label>Visibility</label></td></tr>
		  <tr><td><s:textfield name="testing" value="1hao" /></td></tr>
	  </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>
</s:form>
</div>	<!-- /.box-body -->





</body>
<script type="text/javascript">
	function isChoose(btnObj)
	{
		var rowValue=btnObj.value;
		$("#exampleModal").modal();
	}

</script>
</html>
