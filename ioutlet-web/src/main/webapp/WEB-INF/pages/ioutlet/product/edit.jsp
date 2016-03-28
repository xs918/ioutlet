<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/el"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport"
       content="width=device-width, initial-scale=1">
<title>Spring MVC + Dropzone.js Example</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
 <script src="<%=request.getContextPath()%>/js/plugins/editTable/jquery.edittable.min.js"></script>
 <link href="<%=request.getContextPath()%>/css/plugins/editTable/jquery.edittable.min.css" rel="stylesheet">

 <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.4.1/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.4.1/jsgrid-theme.min.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.4.1/jsgrid.min.js"></script>

<script src="<%=request.getContextPath()%>/js/plugins/jtable/jquery.jtable.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/js/plugins/jtable/themes/jqueryui/jtable_jqueryui.min.css" />


</head>
<body>
<s:url id="discountadd" namespace="/newproduct" includeParams="none" action="discount" />

 <div class="container">
	<display:table name="discounts" class="table" id="txt"  requestURI="" >
	<display:column  title="name" sortable="true">
	 <input type="text" name="name" 
                value="${txt.name}" />
	</display:column>
	<display:column property="quantity" title="quantity" sortable="true"></display:column>
	<display:column property="discountRate" title="discountRate" sortable="true"></display:column>
	<display:column property="discountAmount" title="discountAmount" sortable="true"></display:column>
	</display:table>
	
	
	<div id="edittable2"></div>
	
	<div id="edittable"></div>
	<a href="#" class="sendjson button">Send JSON (check your console)</a> 
    <a href="#" class="loadjson button">Load JSON from textarea</a> 
    <a href="#" class="reset button">Reset Table</a>
	
     <div id="jsGrid"></div>
     <input type="BUTTON" id="add"  value="add" />

<h3>Integrating jTable jQuery plugin and Struts 2 framework</h3>
            <div id="StudentTableContainer"></div>
            

      
</div>
  <script>
  
//Initialize table example 1
  var eTable = $('#edittable').editTable({
  	data: [
  		["Click on the plus symbols on the top and right to add cols or rows"]
  	]
  });
  
  
//Load json data trough an ajax call
  $('.loadjson').click(function () {
  	var _this = $(this),text = $(this).text();
  	$(this).text('Loading...');
  	$.ajax({
  		url: 	'output.php',
  		type: 	'POST',
  		data: 	{
  			ajax: true
  		},
  		complete: function (result) {
  			_this.text(text);
  			eTable.loadJsonData(result.responseText);
  		}
  	});
  	return false;
  });

//Reset table data
  $('.reset').click(function () {
  	eTable.reset();
  	return false;
  });
  
  
//Send JSON data trough an ajax call
  $('.sendjson').click(function () {
  	$.ajax({
  		url: 	'output.php',
  		type: 	'POST',
  		data: 	{
  			ajax: true,
  			data: eTable.getJsonData()
  		},
  		complete: function (result) {
  			console.log(JSON.parse(result.responseText));
  		}
  	});
  	return false;
  });
  
  
  
  
  
  
  
  
  
  
  
// Initialize table example 3
$("#edittable2").editTable({
	data: [
		["01/01/2013","01/30/2013","50,00 €"],
		["02/01/2013","02/28/2013","50,00 €"]
	],
	headerCols: [
		'From',
		'To',
		'Price'
	],
	maxRows: 3
});

// Example of jQuery UI datePicker
$("#edittable2").on("focusin", "td:nth-child(1) input, td:nth-child(2) input", function(){
    $(this).datepicker();
});



$(function() {
	 
	$("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
 
        sorting: true,
        paging: false,
        autoload: true,
        editing: true,
        viewrecords: true,
        controller: {
            loadData: function() {
                var d = $.Deferred();
 
                $.ajax({
                    url: "http://services.odata.org/V3/(S(3mnweai3qldmghnzfshavfok))/OData/OData.svc/Products",
                    dataType: "json"
                }).done(function(response) {
                    d.resolve(response.value);
                });
 
                return d.promise();
            }
        },
 
        fields: [
            { name: "Name", type: "text" },
            { name: "Description", type: "textarea", width: 150 },
            { name: "Rating", type: "number", width: 50, align: "center",
                itemTemplate: function(value) {
                    return $("<div>").addClass("rating").append(Array(value + 1).join("&#9733;"));
                }
            },
            { name: "Price", type: "number", width: 50,
                itemTemplate: function(value) {
                    return value.toFixed(2) + "$"; }
            },
            
            { type: "control" 
             }
        ]
    });
	
	
 
});



	  $('#StudentTableContainer').jtable({
          title : 'Students List',
          actions : {
                  listAction : 'listAction',
                  createAction : 'createAction',
                  updateAction : 'updateAction',
                  deleteAction : 'deleteAction'
          },

          fields : {
                  studentId : {
                          title : 'Student Id',
                          width : '30%',
                          key : true,
                          list : true,
                          edit : false,
                          create : true
                  },
                  name : {
                          title : 'Name',
                          width : '30%',
                          edit : true
                  },
                  department : {
                          title : 'Department',
                          width : '30%',
                          edit : true
                  },
                  emailId : {
                          title : 'Email',
                          width : '20%',
                          edit : true
                  }
          }
  });
  $('#StudentTableContainer').jtable('load');


</script>

</body>
</html>