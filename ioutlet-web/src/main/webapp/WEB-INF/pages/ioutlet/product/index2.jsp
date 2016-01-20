<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Wolf - Bootstrap Admin Theme</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- stylesheets -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/compiled/theme.css" />

</head>
<body id="search">


	<div class="results">
	
	
	

		<!-- bulk actions -->
		<div class="btn-group bulk-actions">
			<button type="button"
				class="btn btn-default dropdown-toggle disabled"
				data-toggle="dropdown">
				Bulk actions <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#">Edit tags</a></li>
				<li><a href="#">Delete products</a></li>
				<li><a href="#">Export to CSV</a></li>
			</ul>
		</div>

		<table id="datatable-products"  class="table table-hover">
			<thead>
				<tr>
					<th tabindex="0" rowspan="1" colspan="1"><input
						class="toggle-all" type="checkbox" /></th>
					<th tabindex="0" rowspan="1" colspan="1" >Name</th>
					<th tabindex="0" rowspan="1" colspan="1">status</th>
					<th tabindex="0" rowspan="1" colspan="1">Unit Price</th>
					<th tabindex="0" rowspan="1" colspan="1"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$159.99</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$1,290.50</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-info">Out of
							stock</span></td>
					<td class="center">$400.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$1,559.99</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$195.99</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$782.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
					<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>	<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>

				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>
				<tr>
					<td><input name="select-product" type="checkbox" /></td>
					<td><img class="img-responsive product-img"
						src="<s:property value="%{userProfileImageLink}"/>" /></td>
					<td>Some product name</td>
					<td class=""><span class="label label-success">Available</span></td>
					<td class="center">$2,890.00</td>
				</tr>

			</tbody>
		</table>
	</div>



	<div class="skin-switcher hide">
		<div class="toggler">
			<span class="brankic-brush"></span>
		</div>
		<ul class="menu">
			<li><a class="active" data-skin="sidebar-default" href="#">
					<span class="color default"></span> Default <i class="fa fa-check"></i>
			</a></li>
			<li><a data-skin="sidebar-clear" href="#"> <span
					class="color clear"></span> Clear <i class="fa fa-check"></i>
			</a></li>
			<li><a data-skin="sidebar-black" href="#"> <span
					class="color black"></span> Black <i class="fa fa-check"></i>
			</a></li>
			<li><a data-skin="sidebar-dark" href="#"> <span
					class="color dark"></span> Dark <i class="fa fa-check"></i>
			</a></li>
			<li><a data-skin="sidebar-flat" href="#"> <span
					class="color flat"></span> Flat <i class="fa fa-check"></i>
			</a></li>
			<li><a data-skin="sidebar-flat-dark" href="#"> <span
					class="color flat-dark"></span> Flat dark <i class="fa fa-check"></i>
			</a></li>
		</ul>
	</div>

	<script type="text/javascript">
		$(function() {

			$('#datatable-products').dataTable({
				"sPaginationType" : "full_numbers",
				"iDisplayLength" : 20,
				"aLengthMenu" : [ [ 20, 50, 100, -1 ], [ 20, 50, 100, "All" ] ]
			});

			// Bulk actions checkboxes

			var $toggle_all = $("input:checkbox.toggle-all");
			var $checkboxes = $("[name='select-product']");
			var $bulk_actions_btn = $(".bulk-actions .dropdown-toggle");

			$toggle_all.change(function() {
				var checked = $toggle_all.is(":checked");
				if (checked) {
					$checkboxes.prop("checked", "checked");
					toggleBulkActions(true);
				} else {
					$checkboxes.prop("checked", "");
					toggleBulkActions(false);
				}
			});

			$checkboxes.change(function() {
				var anyChecked = $("[name='select-product']:checked");
				toggleBulkActions(anyChecked.length);
			});

			function toggleBulkActions(show) {
				if (show) {
					$bulk_actions_btn.removeClass("disabled");
				} else {
					$bulk_actions_btn.addClass("disabled");
				}
			}
		});
	</script>
</body>
</html>