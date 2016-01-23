<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Wolf - Bootstrap Admin Theme</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />



</head>
<body>


	

		
		<div class="row">
		<div class="col-xs-6 col-lg-6">
		 <h1>Products</h1>
		</div>
		<div class="col-xs-6 col-lg-6">
		 <a  class="btn btn-primary pull-right" href="#"><i class="fa fa-plus"></i>Add a Product</a>
		</div>
		</div>
	
		
			
		
		<table id="datatable-products"  class="table table-hover">
			<thead>
				<tr>
					<th tabindex="0" rowspan="1" colspan="1" id="checkboxall">
					<input
						class="toggle-all" type="checkbox" />
				    </th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_1">SKU</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">NAME</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_3">status</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_4">Unit Price</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_5"></th>
				</tr>	
                    
			</thead>
			<tbody>
				<tr>
					<td style="vertical-align:middle"><input name="select-product" type="checkbox" /></td>
					<td style="vertical-align:middle" >
					 <img class="img-responsive product-media" src="<s:property value="%{userProfileImageLink}"/>" />0001</td>
			     	<td style="vertical-align:middle"> ANKLE STRAP SANDALS </td>
					<td style="vertical-align:middle"><span class="label label-success">Available</span></td>
					<td style="vertical-align:middle">$159.99</td>
					<td  style="vertical-align:middle">
					<div class="actions">
					
					 <a  class="action-icon pull-right" data-toggle="tooltip"  title="copy" href="#">
					 <i class="fa fa-files-o fa-3x fa-3x"></i></a>
					 
					  <a  class="action-icon pull-right" data-toggle="tooltip"  title="edit" href="#">
					   <i class="fa fa-pencil-square-o fa-3x fa-3x"></i>
					  </a>
					 
					  <a  class="action-icon pull-right" data-toggle="tooltip"  title="delete" href="#">
					   <i class="fa fa-trash-o fa-3x fa-3x"></i>
					  </a>
						
					</div>   
					</td>
					
				</tr>
				<tr>
					<td style="vertical-align:middle"><input name="select-product" type="checkbox" /></td>
					<td style="vertical-align:middle"><img class="img-responsive product-media"
						src="<s:property value="%{userProfileImageLink}"/>" />
						  <span style="vertical-align:middle">0002</span>
						</td>
				    <td style="vertical-align:middle"> SLIVER STRAP HEELS </td>
					<td style="vertical-align:middle"><span class="label label-success">Available</span></td>
					<td style="vertical-align:middle">$1,290.50</td>
				    <td style="vertical-align:middle" >
					 <div class="actions">
				      <a  class="action-icon pull-right" data-toggle="tooltip"  title="copy" href="#">
					 <i class="fa fa-files-o fa-3x"></i></a>
			    	  <a  class="action-icon pull-right" data-toggle="tooltip"  title="edit" href="#">
					   <i class="fa fa-pencil-square-o fa-3x"></i>
					  </a>
					  <a  class="action-icon pull-right" data-toggle="tooltip"  title="delete" href="#">
					   <i class="fa fa-trash-o fa-3x"></i>
					  </a>
					  </div>
					</td>
				</tr>
				<tr>
					<td style="vertical-align:middle"><input name="select-product" type="checkbox" /></td>
					<td style="vertical-align:middle"><img class="img-responsive product-media"
						src="<s:property value="%{userProfileImageLink}"/>" />0303</td>
					 <td style="vertical-align:middle"> 2015SLIVER STRAP HEELS </td>
					<td style="vertical-align:middle"><span class="label label-info">Out of
							stock</span></td>
					<td style="vertical-align:middle">$400.00</td>
				    <td style="vertical-align:middle" >
					 <div class="actions">
				      <a  class="action-icon pull-right" data-toggle="tooltip"  title="copy" href="#">
					 <i class="fa fa-files-o fa-3x"></i></a>
			    	  <a  class="action-icon pull-right" data-toggle="tooltip"  title="edit" href="#">
					   <i class="fa fa-pencil-square-o fa-3x "></i>
					  </a>
					  <a  class="action-icon pull-right" data-toggle="tooltip"  title="delete" href="#">
					   <i class="fa fa-trash-o fa-3x"></i>
					  </a>
					  </div>
					</td>
				</tr>
				<tr>
					<td style="vertical-align:middle"><input name="select-product" type="checkbox" /></td>
					<td style="vertical-align:middle" ><img class="img-responsive product-media"
						src="<s:property value="%{userProfileImageLink}"/>" />>0004</td>
					 <td style="vertical-align:middle"> 2015sssSLIVER STRAP HEELS </td>
					<td style="vertical-align:middle"><span class="label label-success">Available</span></td>
					<td style="vertical-align:middle">$1,559.99</td>
	                 <td style="vertical-align:middle" >
					 <div class="actions">
				      <a  class="action-icon pull-right" data-toggle="tooltip"  title="copy" href="#">
					 <i class="fa fa-files-o fa-3x"></i></a>
			    	  <a  class="action-icon pull-right" data-toggle="tooltip"  title="edit" href="#">
					   <i class="fa fa-pencil-square-o fa-3x"></i>
					  </a>
					  <a  class="action-icon pull-right" data-toggle="tooltip"  title="delete" href="#">
					   <i class="fa fa-trash-o fa-3x"></i>
					  </a>
					  </div>
					</td>
				</tr>
				<tr>
					<td style="vertical-align:middle"><input name="select-product" type="checkbox" /></td>
					<td style="vertical-align:middle" ><img class="img-responsive product-media"
						src="<s:property value="%{userProfileImageLink}"/>" />0005</td>
					 <td style="vertical-align:middle"> 2015ssssssssssssssssssssssssssSLIVER STRAP HEELS </td>
					<td style="vertical-align:middle"><span class="label label-success">Available</span></td>
					<td style="vertical-align:middle">$195.99</td>
				     <td style="vertical-align:middle" >
					 <div class="actions">
				      <a  class="action-icon pull-right" data-toggle="tooltip"  title="copy" href="#">
					 <i class="fa fa-files-o fa-3x"></i></a>
			    	  <a  class="action-icon pull-right" data-toggle="tooltip"  title="edit" href="#">
					   <i class="fa fa-pencil-square-o fa-3x"></i>
					  </a>
					  <a  class="action-icon pull-right" data-toggle="tooltip"  title="delete" href="#">
					   <i class="fa fa-trash-o fa-3x"></i>
					  </a>
					  </div>
					</td>
				</tr>
				
			</tbody>
		</table>


	

	<script type="text/javascript">
		$(function() {
			

			
		
			$('table tr').hover(
				function(){
					$(this).find('.actions').stop().fadeTo('slow',1);
			    },
			    function(){
			    	$(this).find('.actions').stop().fadeTo('slow',0.0);
			    });
			
			
			
			

			$('#datatable-products').dataTable({
				"oLanguage":{
		            "sLengthMenu": "Show _MENU_ items",
		            "sZeroRecords": "Nothing found - sorry",
		            "sInfo": "Showing _START_ to _END_ of _TOTAL_ items",
		            "sInfoEmpty": "Showing 0 to 0 of 0 records",
		            "sInfoFiltered": "(filtered from _MAX_ total records)",
		             "sSearch": "Filter: "
		        },
				"iDisplayLength" : 20,
				"bFilter": true,
				"autoWidth": false,
				"aLengthMenu" : [ [5, 10,20, 50, 100, -1 ], [5,10, 20, 50, 100, "All" ] ]
			
			});
			
			$("#datatable-products_filter").addClass("pull-right");
			// Bulk actions checkboxes

			var $toggle_all = $("input:checkbox.toggle-all");
			var $checkboxes = $("[name='select-product']");
			
			

			
			

			$toggle_all.change(function() {
				var checked = $toggle_all.is(":checked");
				if (checked) {
					$checkboxes.prop("checked", "checked");
					checkboxActions(true,$checkboxes.length);
				} else {
					$checkboxes.prop("checked", "");
					checkboxActions(false,0);
				}
			});

			$checkboxes.change(function() {
				var anyChecked = $("[name='select-product']:checked");
				checkboxActions(anyChecked.length,anyChecked.length);
			});

			function checkboxActions(show,checkedCount) {
				if (show) {
					
					
				
					
	
					
					
					
					 var new_row = '<th tabindex="0" rowspan="1" colspan="6" id="check_1">Total '+ checkedCount
					  + ' products selected <a  class="btn btn-sm btn-white" href="#"><i class="fa fa-trash-o"></i>Delete</a></th> '
					  
		
					
						
						$("#check_1").remove();
						$("#check_2").remove();
						$("#check_3").remove();
						$("#check_4").remove();
						$("#check_5").remove();
					$("#uncheck_1").remove();
					$("#uncheck_2").remove();
					$("#uncheck_3").remove();
					$("#uncheck_4").remove();
					$("#uncheck_5").remove();
					$("#checkboxall").after(new_row);
					
				
				} else {
				
					 var new_row = '<th tabindex="0" rowspan="1" colspan="1" id="uncheck_1">SKU</th>'
						 +'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">Name</th>'
					+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">status</th>'
					+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_3">Unit Price</th>'
					+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_4"></th>'
			
					 
					$("#uncheck_1").remove();
					$("#uncheck_2").remove();
					$("#uncheck_3").remove();
					$("#uncheck_4").remove();
					$("#uncheck_5").remove();
					
					$("#check_1").remove();
					$("#check_2").remove();
					$("#check_3").remove();
					$("#check_4").remove();
					$("#checkboxall").after(new_row);
					
				}
			}
		});
	</script>
</body>
</html>