<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Product List</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <s:url id="jsonurl" namespace="/product" includeParams="none" action="jsonAct" />
			   

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
				    <th tabindex="0" rowspan="1" colspan="1" id="uncheck_1"></th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">SKU</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_3">NAME</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_4">Quantity</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_5">Unit Price</th>
					<th tabindex="0" rowspan="1" colspan="1" id="uncheck_6"></th>
				</tr>	
                    
			</thead>
			<tbody>
			      <s:iterator value="%{data}" id="p">
			     
				<tr>
					<td ><input name="select-product" type="checkbox" /></td>
					<td  class="static-width">
					 <img class="img-responsive product-media" src="<s:property value="%{userProfileImageLink}"/>" /></td>
					 			<td><s:property value="%{#p.id}"/></td>
			     	<td ><s:property value="%{#p.name}"/></td>
					<td ><s:property value="%{#p.balance}"/></td>
					<td><s:property value="%{#p.unitPrice}"/></td>
					<td  >
					<div class="actions">
					
					 <a  class="action-icon " data-toggle="tooltip"  title="copy" href="#">
					 <i class="fa fa-files-o fa-3x fa-3x"></i></a>
					 
					  <a  class="action-icon " data-toggle="tooltip"  title="edit" href="#">
					   <i class="fa fa-pencil-square-o fa-3x fa-3x"></i>
					  </a>
					 
					  <a  class="action-icon " data-toggle="tooltip"  title="delete" href="#">
					   <i class="fa fa-trash-o fa-3x fa-3x"></i>
					  </a>
						
					</div>   
					</td>
					
				</tr>
				 </s:iterator>
			
				
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
			
			
			
			var sLengthMenuLabel='<s:property value="%{getText('data.table.menu.length.label')}"/>' ;
			var sZeroRecordsLabel='<s:property value="%{getText('data.table.zero.record.label')}"/>' ;
			var sInfoLabel='<s:property value="%{getText('data.table.info.label')}"/>' ;
			var sInfoEmptyLabel='<s:property value="%{getText('data.table.info.empty.label')}"/>' ;
			var sInfoFilteredLabel='<s:property value="%{getText('data.table.info.filtered.label')}"/>' ;
			var sSearchLabel='<s:property value="%{getText('data.table.search.label')}"/>' ;
			var sEmptyTable='<s:property value="%{getText('data.table.empty.table.label')}"/>' ;
			var sAllLabel='<s:property value="%{getText('data.table.all.label')}"/>' ;
			var sFirstLabel='<s:property value="%{getText('data.table.first.label')}"/>' ;
			var sPreviousLabel='<s:property value="%{getText('data.table.previous.label')}"/>' ;
			var sNextLabel='<s:property value="%{getText('data.table.next.label')}"/>' ;
			var sLastLabel='<s:property value="%{getText('data.table.last.label')}"/>' ;
			var sLoadingRecordsLabel='<s:property value="%{getText('data.table.loading.label')}"/>';
			var sSortAscendingLabel='<s:property value="%{getText('data.table.sort.ascending.label')}"/>';
			var sSortAscendingLabel='<s:property value="%{getText('data.table.sort.descending.label')}"/>';
		
			$('#datatable-products').dataTable({
				"oLanguage":{
		            "sLengthMenu": sLengthMenuLabel,
		            "sZeroRecords": sZeroRecordsLabel,
		            "sInfo":sInfoLabel,
		            "sInfoEmpty": sInfoEmptyLabel,
		            "sInfoFiltered": sInfoFilteredLabel,
		             "sSearch": sSearchLabel,
		             "sEmptyTable":    sEmptyTable,
					 "sLoadingRecords":sLoadingRecordsLabel,
					  "sInfoThousands":  ",",
					  "oPaginate": {
							"sFirst":    sFirstLabel,
							"sPrevious": sPreviousLabel,
							"sNext":     sNextLabel,
							"sLast":     sLastLabel
						},
						"oAria": {
							"sSortAscending":  sSortAscendingLabel,
							"sSortDescending": sSortAscendingLabel
						}
						
		        },
				"iDisplayLength" : 20,
				"bFilter": true,
				"autoWidth": false,
				"aLengthMenu" : [ [5, 10,20, 50, 100, -1 ], [5,10, 20, 50, 100, sAllLabel ] ]
				
				
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
					
					
				
					
	
					
					
					
					 var new_row = '<th tabindex="0" rowspan="1" colspan="7" id="check_1">Total '+ checkedCount
					  + ' products selected <a  class="btn btn-sm btn-white" href="#"><i class="fa fa-trash-o"></i>Delete</a></th> '
					  
		
					
						
					$("#check_1").remove();
					$("#uncheck_1").remove();
					$("#uncheck_2").remove();
					$("#uncheck_3").remove();
					$("#uncheck_4").remove();
					$("#uncheck_5").remove();
					$("#uncheck_6").remove();
					$("#checkboxall").after(new_row);
					
				
				} else {
				
					 var new_row =   '<th tabindex="0" rowspan="1" colspan="1" id="uncheck_1"></th>'
									+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_2">SKU</th>'
								    +'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_3">Name</th>'
									+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_4">Quantity</th>'
									+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_5">Unit Price</th>'
									+'<th tabindex="0" rowspan="1" colspan="1" id="uncheck_6"></th>'
					
					 
					$("#uncheck_1").remove();
					$("#uncheck_2").remove();
					$("#uncheck_3").remove();
					$("#uncheck_4").remove();
					$("#uncheck_5").remove();
					$("#uncheck_6").remove();
					
					$("#check_1").remove();
					$("#checkboxall").after(new_row);
					
				}
			}
		});
	</script>
</body>
</html>