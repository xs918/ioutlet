<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Wolf - Bootstrap Admin Theme</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <s:url id="jsonurl" namespace="/product" includeParams="none" action="jsonAct!json" />
  
  <s:url id="dtlurl" namespace="/product" includeParams="none" action="detail" />
    

</head>
<body>


	

		
		<div class="row">
		<div class="col-xs-6 col-lg-6">
		 <h1>Products</h1>
		</div>
		<div class="col-xs-6 col-lg-6">
		 <a  class="btn btn-primary pull-right" href="<s:property value="%{dtlurl}"/>"><i class="fa fa-plus"></i>Add a Product</a>
		</div>
		</div>
	
		
			
		
		<table id="table-products"  class="table table-hover">
			<thead>
				<tr>
					<th tabindex="0" rowspan="1" colspan="1" id="checkboxall">
					<input name="select_all"
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
			
		</table>


	

	<script type="text/javascript">
	
	   var rows_selected = [];
	   
	   
		
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
		
		
		function updateDataTableSelectAllCtrl(table){
			   var $table             = table.table().node();
			   var $chkbox_all        = $('tbody input[type="checkbox"]', $table);
			   var $chkbox_checked    = $('tbody input[type="checkbox"]:checked', $table);
			   var chkbox_select_all  = $('thead input[name="select_all"]', $table).get(0);

			   // If none of the checkboxes are checked
			   if($chkbox_checked.length === 0){
			      chkbox_select_all.checked = false;
			      checkboxActions(false,0);
			      if('indeterminate' in chkbox_select_all){
			         chkbox_select_all.indeterminate = false;
			      }

			   // If all of the checkboxes are checked
			   } else if ($chkbox_checked.length === $chkbox_all.length){
			      chkbox_select_all.checked = true;
			      checkboxActions(true,$chkbox_checked.length);
			      if('indeterminate' in chkbox_select_all){
			         chkbox_select_all.indeterminate = false;
			      }

			   // If some of the checkboxes are checked
			   } else {
			      chkbox_select_all.checked = true;
			      checkboxActions(true,$chkbox_checked.length);
			      if('indeterminate' in chkbox_select_all){
			         chkbox_select_all.indeterminate = true;
			      }
			   }
		}
	   
		$(document).ready(function (){
	
			jsoncall='<s:property value="%{jsonurl}"/>'
			var table=$('#table-products').DataTable({
				 "ajax": jsoncall,
				   "type": "POST",
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
					"aLengthMenu" : [ [5, 10,20, 50, 100, -1 ], [5,10, 20, 50, 100, sAllLabel ] ],
					
	
			     "columns": [
							  {
								"mData": null,
				              },
				              { 
				            	 "mData": null,
				            	 "className": "static-width"
				            	
				              },
				              { 
					              "mData": "id",
					            	
					          },
				              { 
				            	  "mData": "name"
				              },
				              { 
				            	  "mData": "balance"
				              }
				              ,
				              { 
				            	  "mData": "unitPrice"
				              }
				              ,
				              { 
				            	  "mData": null,
				            	  "className": "actions"
				               	   
				               }
				           ],
	              
	              "columnDefs":[ 
	                              {
				            	     "targets": 0,
				            	     "render": function ( data, type, full, meta ) 
				            	     {
				            	      return '<input name="select-product" type="checkbox" />';
				            	     }
	            	              },
					              {
					            	    "targets": 1,
					            	    "render": function ( data, type, full, meta ) 
					            	    {
					            	      return  '<img class="img-responsive product-media" src="<s:property value="%{userProfileImageLink}"/>" />' 
					            	      /* + data.id */
					            	    }
					              },   
				            	  {
					            	    "targets": 6,
					            	    "render": function ( data, type, full, meta ) 
					            	    {
					            	    	
					            	   	  actionButton='<a class="action-icon" data-toggle="tooltip"  title="copy" href="#"><i class="fa fa-files-o  fa-3x"></i></a>'
					  		         	    + '<a  class="action-icon" data-toggle="tooltip"  title="edit" href="#"><i class="fa fa-pencil-square-o fa-3x"></i></a>'
					  			     	  +'<a  class="action-icon " data-toggle="tooltip" title="delete" href="#"> <i class="fa fa-trash-o fa-3x fa-3x"></i></a>';
					  	          	     return  actionButton
					            	    }
					              }
	            	  
	             			 ],
	             			'order': [[1, 'asc']],
	             			 'rowCallback': function(row, data, dataIndex){
	             		         // Get row ID
	             		         var rowId = data[0];

	             		         // If row ID is in the list of selected row IDs
	             		         if($.inArray(rowId, rows_selected) !== -1){
	             		            $(row).find('input[type="checkbox"]').prop('checked', true);
	             		            $(row).addClass('selected');
	             		         }
	             		      }
			
	        	
			});
			
			
			
			// Handle click on checkbox
			   $('#table-products tbody').on('click', 'input[type="checkbox"]', function(e){
				   var $row = $(this).closest('tr');

				      // Get row data
				      var data = table.row($row).data();

				      // Get row ID
				      var rowId = data[0];

				      // Determine whether row ID is in the list of selected row IDs 
				      var index = $.inArray(rowId, rows_selected);

				      // If checkbox is checked and row ID is not in list of selected row IDs
				      if(this.checked && index === -1){
				         rows_selected.push(rowId);

				      // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
				      } else if (!this.checked && index !== -1){
				         rows_selected.splice(index, 1);
				      }

				      if(this.checked){
				         $row.addClass('selected');
				      } else {
				         $row.removeClass('selected');
				      }

				      // Update state of "Select all" control
				      updateDataTableSelectAllCtrl(table);

				      // Prevent click event from propagating to parent
				      e.stopPropagation();
			   });

			   // Handle click on table cells with checkboxes
			/*    $('#table-products').on('click', 'tbody td, thead th:first-child', function(e){
				   $(this).parent().find('input[type="checkbox"]').trigger('click');
			   });
 */
			   
				 
				 
			   // Handle click on "Select all" control
			   $('thead input[name="select_all"]', table.table().container()).on('click', function(e){
			      if(this.checked){
			         $('#table-products tbody input[type="checkbox"]:not(:checked)').trigger('click');
			      } else {
			         $('#table-products tbody input[type="checkbox"]:checked').trigger('click');
			      }

			      // Prevent click event from propagating to parent
			      e.stopPropagation();
			   });

			   // Handle table draw event
			   table.on('draw', function(){
			      // Update state of "Select all" control
			      updateDataTableSelectAllCtrl(table);
			   });

	
			
			 $('#table-products tbody').on( 'mouseenter', 'tr', function () {
				
						$(this).find('.actions').stop().fadeTo('slow',1);
				
					} );
			   
			 $('#table-products tbody').on( 'mouseleave', 'tr', function () {
					
					$(this).find('.actions').stop().fadeTo('slow',0);
			
				} );
			 
			
			
			$("#table-products_filter").addClass("pull-right");
			// Bulk actions checkboxes

			var $toggle_all = $("input:checkbox.toggle-all");
			var $checkboxes = $("[name='select-product']");
			
			

			
			

	
		});
		
		
	</script>
</body>
</html>