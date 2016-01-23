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
		 <a  class="btn btn-primary m-b pull-right" href="#"><i class="fa fa-plus"></i>Add a Product</a>
		</div>
		</div>
	
		
			
		
		<table id="datatable-products"  class="table table-hover">
			<thead>
				<tr>
					<th tabindex="0" rowspan="1" colspan="1" id="checkboxall">
					<input
						class="toggle-all" type="checkbox" />
				    </th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_1">Name</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">status</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_3">Unit Price</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_4"></th>
				</tr>	
                    
			</thead>
			<tbody>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$159.99</td>
					
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$1,290.50</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-info">Out of
							stock</span></td>
					<td class="center">$400.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$1,559.99</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$195.99</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$782.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>

				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td class="static-width"><img class="img-responsive product-img-small"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>

			</tbody>
		</table>


	

	<script type="text/javascript">
		$(function() {

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
					
					
				
					
	
					
					
					
					 var new_row = '<th tabindex="0" rowspan="1" colspan="1" id="check_1">Total '+ checkedCount
					  + ' products selected </th> '
					  +'<th  tabindex="0" rowspan="1" colspan="4" id="check_2"><a  class="btn btn-sm btn-white" href="#"><i class="fa fa-trash-o"></i>Delete</a>'
					  +'</th>'
		
					
						
						$("#check_1").remove();
						$("#check_2").remove();
						$("#check_3").remove();
						$("#check_4").remove();
					 
					$("#uncheck_1").remove();
					$("#uncheck_2").remove();
					$("#uncheck_3").remove();
					$("#uncheck_4").remove();
					
					$("#checkboxall").after(new_row);
					
				
				} else {
				
					 var new_row = '<th tabindex="0" rowspan="1" colspan="1" id="uncheck_1">Name</th>'
					+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">status</th>'
					+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_3">Unit Price</th>'
					+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_4"></th>'
			
					 
					$("#uncheck_1").remove();
					$("#uncheck_2").remove();
					$("#uncheck_3").remove();
					$("#uncheck_4").remove();
					
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