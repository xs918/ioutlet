<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<!-- Home tab content -->
<div class="tab-pane active" id="control-sidebar-home-tab">
	<ul class="control-sidebar-menu">
	 <li>
	   <i class="fa  fa-money"></i>
	   <span>Payments</span>
	  	<ul class="treeview-menu">
			<li><a href="#">Credit card</a></li>
			<li><a href="#">Paypal</a></li>
		</ul>
	 </li>
	 
	 

	 <li>
	   <i class="fa  fa-language"></i>
	   <span>language</span>
	 </li>
	 
	 
	
	
   </ul>
	<!-- /.control-sidebar-menu -->


</div>
<!-- /.tab-pane -->
<!-- Stats tab content -->
<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
	Content</div>
<!-- /.tab-pane -->
<!-- Settings tab content -->
<div class="tab-pane" id="control-sidebar-settings-tab">
	<form method="post">
		<h3 class="control-sidebar-heading">General Settings</h3>
		<div class="form-group">
			<label class="control-sidebar-subheading"> Report panel usage
				<input type="checkbox" class="pull-right" checked>
			</label>
			<p>Some information about this general settings option</p>
		</div>
		<!-- /.form-group -->
	</form>
</div>
<!-- /.tab-pane -->
</html>
