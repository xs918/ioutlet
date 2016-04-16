<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/el"%>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>INSPINIA | E-commerce</title>

<style>
#dropzone { margin-bottom: 3rem; }

.dropzone { border: 2px dashed #0087F7; border-radius: 5px; background: white; }
.dropzone .dz-message { font-weight: 400; }
.dropzone .dz-message .note { font-size: 0.8em; font-weight: 200; display: block; margin-top: 1.4rem; }

</style>


 <script src="<%=request.getContextPath()%>/js/plugins/editTable/jquery.edittable.min.js"></script>
 <link href="<%=request.getContextPath()%>/css/plugins/editTable/jquery.edittable.min.css" rel="stylesheet">
  
</head>

<body>
<s:url id="imageupload" namespace="/newproduct" includeParams="none" action="imageupload" />
<s:url id="discountadd" namespace="/newproduct" includeParams="none" action="discount" />


		<s:form enctype="multipart/form-data" theme="bootstrap" action="form"
			method="post" calss="form-Vertical dropzone" >
			
			
			<div class="col-sm-12">
			<h2>Basic Information</h2>
			</div>
				
               
                        
					<div class="col-sm-4">
						<s:textfield label="%{getText('name')}" name="	" maxLength="50"
							requiredLabel="true"
							placeholder="max 50 characters" 
							title="%{getText('add.your.product.name')}"
							/>
					</div>
        			<div class="col-sm-2">
						<s:textfield label="%{getText('price')}" name="	" maxLength="50"
							requiredLabel="true" placeholder="%{getText('currency.symbol')}" 
							
						   title="%{getText('How much price you want to sell')}"
							/>


					</div>
			       <div class="col-sm-6"></div>
			       
			
			     <div class="col-sm-12">
			    
			      <s:select
				                        tooltip="%{getText('category of your product')}"
				                        label="%{getText('collections')}"
				                        list="catlist"
				                        name="category"
				                        
				                        title="%{getText('Choose the category your product belong to')}"
				  />
				                 
			   </div>
			
				<div class="col-sm-12">
						<s:textarea label="%{getText('description')}" name="description"
							cols="50"
							placeholder="%{getText('add short description of your product')}"
							rows="4" />
	
				</div>
                      
              	<div class="col-sm-12">
                  <strong><s:property value="%{getText('product.image')}"/>
		          </strong>
		   	    </div>
                 <div class="col-sm-12">
                     <div id="my-dropzone" class="modal-body dropzone no-margin dz-clickable" >
                       		  <div class="fallback">
				                 <input type="hidden" value="" id="file" name="file" multiple />
				              </div>
                      </div>
                  </div>              
                  
               	<div class="col-sm-12">
				<h2>Product Attributes</h2>
				</div>
				
						
				  	<div class="col-sm-4">
						<s:textfield label="%{getText('sku')}" name="	" maxLength="50"
							requiredLabel="true"
							placeholder="%{getText('pls key sku')}" />
					</div>       
						  	<div class="col-sm-4">
	                  <s:select
				                        tooltip="%{getText('Inventory Policy')}"
				                        label="%{getText('Inventory Policy')}"
				                        list="catlist"
				                        name="category"
				  />
				  </div>
				 
				 <div class="col-sm-4">
                 <s:select
				                        tooltip="%{getText('Status')}"
				                        label="%{getText('Status')}"
				                        list="catlist"
				                        name="category"
				  />
				  </div>
				  
				  
			<div class="col-sm-12">
			   <strong><s:property value="%{getText('Discount')}"/>
		       </strong>
		      	<p><small>Can this product have any discount?</small></p>
				
			</div>
			
			 <div class="col-sm-12">
				<button type="button" class="btn btn-default pull-left" id="add_discount"><i class="fa fa-plus"></i>Add Product Discount</button>
		    	
			</div>
			 <div class="col-sm-12 table-responsive">
			<table id="edittable_discount" class="table table-bordered">
			</table>
			<button type="button" class="btn btn-info pull-left btn-xs" id="add_more_discount"><i class="fa fa-plus"></i>more discount</button>
			</div>
			
	
			
			
			
			 <div class="col-sm-12">
			   <strong><s:property value="%{getText('Custom Text Field')}"/>
		       </strong>
				<small>Can this product be personalized? (Ex: custom text or special request)</small>
			</div>
			
		    <div class="col-sm-12">
			   <button type="button" class="btn btn-default pull-left" id="add_option"><i class="fa fa-plus"></i>Add Product Option</button>
			</div>
		   <div class="col-sm-12 table-responsive">
			<table id="edittable_option" class="table table-bordered">
		   </table>
		   <button type="button" class="btn btn-info pull-left btn-xs" id="add_more_option"><i class="fa fa-plus"></i>more option</button>
		  </div>
			
			  <div class="col-sm-10"> 
			  </div>
			
			  <div class="col-sm-2"> 
			     <div class="btn-group " role="group">
                 <s:submit cssClass="btn btn-primary btn-sm" value="previous" onclick="isSubmit('regist')" />     
                  </div>
                  <div class="btn-group  ">
                    <s:submit cssClass="btn btn-primary btn-sm " onclick="isSubmit('regist')" />   
                 </div>       
                </div>
                        
	       
                 
		</s:form>

                     

    <script>
        $(document).ready(function(){
        	
        	$("#add_more_discount").hide();
        
        	
        	$("#add_discount").click(function(){
        		
        		$("#add_more_discount").show();
        		
        		
        	$("#add_discount").hide();
        	
        
        		
        		var table = $('#edittable_discount');
        		
        		var thtd= $('<th>Discount name</th><th>Discount quantity</th><th>Discount percentage</th><th>Discount amount</th><th>Discount start time</th><th>Discount end time</th><th></th>');
        	    var rowth=$('<tr></tr>')
        	    rowth.append(thtd);
        		table.append(rowth);
        	
        		discount_i=1;
        		var row = $('<tr id=discount_row>'+discount_i+'</tr>');
        		
        	

        	    var data ="<td><input type='text' id='discount_name"+discount_i+"' name='discountName[]'/></td>";
        	    data +=" <td><input type='text' id='discount_quantity"+discount_i+"' name='discountQty[]'/></td>";
        	    data +=" <td><input type='text' id='discount_per"+discount_i+"' name='discountPercentage[]'/></td>";
        	    data +=" <td><input type='text' id='discount_amt"+discount_i+"' name='discount_amt[]'/></td>";
        	    data += "<td><input type='text' id='discount_start_time"+discount_i+"' name='startTime[]'/></td>";
        	    data+="<td><input type='text' id='discount_end_time"+discount_i+"' name='endTime[]'/></td>";
        	    data+="<td>   <a href='javascript:void(0);'  class='btn btn-danger pull-left btn-xs remCF '><i class='fa fa-trash-o'></i></a>	</td>";
        	          
        	    
        	  
        	    
        		table.append(row);
        		row.append(data);
        		
        		
        		
        	
        		
        	
        		 
        		 
        	
        			
        	
        	}
        	);
        	
        	
        	$("#add_more_discount").click(function(){
        		
     
        		discount_i=discount_i+1;
        		var table = $('#edittable_discount');
        	
        		var row = $('<tr id=discount_row>'+discount_i+'</tr>');
        		
        	  

        	    var data ="<td><input type='text' id='discount_name"+discount_i+"' name='discountName[]'/></td>";
        	    data +=" <td><input type='text' id='discount_quantity"+discount_i+"' name='discountQty[]'/></td>";
        	    data +=" <td><input type='text' id='discount_per"+discount_i+"' name='discountPercentage[]'/></td>";
        	    data +=" <td><input type='text' id='discount_amt"+discount_i+"' name='discount_amt[]'/></td>";
        	    data += "<td><input type='text' id='discount_start_time"+discount_i+"' name='startTime[]'/></td>";
        	    data+="<td><input type='text' id='discount_end_time"+discount_i+"' name='endTime[]'/></td>";
        	    data+="<td>   <a href='javascript:void(0);'  class='btn btn-danger pull-left btn-xs remCF '><i class='fa fa-trash-o'></i></a>	</td>";
        	    
        	  
        	    
        		table.append(row);
        		row.append(data);
        		if(discount_i>=4)
        		{
        		 	$("#add_more_discount").hide();	
        		}
        		
           	  
        	}
        	);
        	
        	
         	$("#edittable_discount").on('click', '.remCF', function(){
         		  
         		  
        		  
         		if(discount_i==1)
      	        {
      	        	$(this).parent().parent().parent().remove();
      	        	
      	        	$("#add_discount").show();
      	        	$("#add_more_discount").hide();
      	        	
      	        }
      	        else
      	        {
      	        	$("#add_more_discount").show();
      	        	
      	        }
         		 discount_i=discount_i-1;
         		  
        	      $(this).parent().parent().remove();
        	    
        	     
        	      
        	        	
        	        	
        	    });
        	  
        	// product option start 
        	
        	
             $("#add_more_option").hide();
        
        	
        	$("#add_option").click(function(){
        		
        		$("#add_more_option").show();
        		
        		
        	$("#add_option").hide();
        	
        
        		
        		var table = $('#edittable_option');
        		
        		var thtd= $('<th>Type</th><th>Title</th><th>Value</th><th></th>');
        	    var rowth=$('<tr></tr>')
        	    rowth.append(thtd);
        		table.append(rowth);
        	
        		option_i=1;
        		var row = $('<tr id=option>'+option_i+'</tr>');
        		
        	

        		 var data ="<td><select name name='option[]'>"
          	    	+"<option value='Number'>Number</option>"
          	    	+"<option value='Color'>Color</option>"
          	    	+"<option value='Image'>Image</option>"
          	    	+"<option value='Text'>Text</option>"
          	    +"</select> </td>";
        	    
        		
        		
        		
        	    data +=" <td><input type='text' id='discount_quantity"+option_i+"' name='discountQty[]'/></td>";
        	    data +=" <td><input type='text' id='discount_per"+option_i+"' name='discountPercentage[]'/></td>";
        	    data+="<td>   <a href='javascript:void(0);'  class='btn btn-danger pull-left btn-xs remCF '><i class='fa fa-trash-o'></i></a>	</td>";
        	          
        	    
        	  
        	    
        		table.append(row);
        		row.append(data);
        		
        		
        		
        	
        		
        	
        		 
        		 
        	
        			
        	
        	}
        	);
        	
        	
        	$("#add_more_option").click(function(){
        		
     
        		option_i=option_i+1;
        		var table = $('#edittable_option');
        	
         		var row = $('<tr id=option>'+option_i+'</tr>');
        		
            	

         		 var data ="<td><select name name='option[]'>"
         	    	+"<option value='Number'>Number</option>"
         	    	+"<option value='Color'>Color</option>"
         	    	+"<option value='Image'>Image</option>"
         	    	+"<option value='Text'>Text</option>"
         	    +"</select> </td>";
         	    
        	    data +=" <td><input type='text' id='discount_quantity"+option_i+"' name='discountQty[]'/></td>";
        	    data +=" <td><input type='text' id='discount_per"+option_i+"' name='discountPercentage[]'/></td>";
        	    data+="<td>   <a href='javascript:void(0);'  class='btn btn-danger pull-left btn-xs remCF '><i class='fa fa-trash-o'></i></a>	</td>";
        	          
        	    
        	  
        	    
        		table.append(row);
        		row.append(data);
        		if(option_i>=4)
        		{
        		 	$("#add_more_option").hide();	
        		}
        		
           	  
        	}
        	);
        	
        	
         	$("#edittable_option").on('click', '.remCF', function(){
         		  
         		  
        		  
         		if(option_i==1)
      	        {
      	        	$(this).parent().parent().parent().remove();
      	        	
      	        	$("#add_option").show();
      	        	$("#add_more_option").hide();
      	        	
      	        }
      	        else
      	        {
      	        	$("#add_more_option").show();
      	        	
      	        }
         		 option_i=option_i-1;
         		  
        	      $(this).parent().parent().remove();
        	    
        	     
        	      
        	        	
        	        	
        	    });
        	  
        	
         	
         	//--- end 
        
          	
          	
    
        	
        	Dropzone.autoDiscover = false; // keep this line if you have multiple dropzones in the same page
        	$(".uploadform").dropzone({	
        	acceptedFiles: "image/*",
            url: '<s:property value="%{imageupload}"/>',
            maxFiles: 1, // Number of files at a time
        	maxFilesize: 10, //in MB
            maxfilesexceeded: function(file) {
                alert('You have uploaded more than 10 Image. Only the first file will be uploaded!');
            },
        	success: function (file,response) {
        		var x = JSON.parse(response.xhr.responseText);
        		$('.icon').hide();
        		$('#uploader').modal('hide');
        		$('.img').attr('src',file.img);
        		$('.thumb').attr('src',file.thumb);
        		$('img').addClass('imgdecoration');
            	},	
            	
      
            	
        	addRemoveLinks: true,
        	removedfile: function(file) {
           	var _ref;
        			 return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;  
             }	
        	
        	});
        	
        	
        	
        	
        	
        	
           	$("#my-dropzone").dropzone({
        		 url:'<s:property value="%{imageupload}"/>',
        	     maxFiles: 10,
        	     maxFilesize: 15,
        	     acceptedFiles: "image/*",
        	     parallelUploads: 20,
        	   /*   autoProcessQueue: false, */
        	  /*    uploadMultiple: true, */
        	      init: function() {
        	    	     myDropzone = this; // closure
                       
        	            this.on("addedfile", function(file) {
        	              
        	        	var removeButton = Dropzone.createElement('<a data-dz-remove href="#">  <i class="glyphicon glyphicon-trash"></i> </a>');
        	        	  var _this = this;
        	        	  removeButton.addEventListener("click", function(e) {
        	                  // Make sure the button click doesn't submit the form:
        	                  e.preventDefault();
        	                  e.stopPropagation();
        	                      	                  // Remove the file preview.
        	                  _this.removeFile(file);
        	        });
        	        file.previewElement.appendChild(removeButton);

        	        	  for (i = 0, len = this.files.length; i < len - 1; i++)
        	        	    {
        	        	         if (this.files[i].name == file.name && this.files[i].size == file.size && this.files[i].lastModifiedDate.toString() == file.lastModifiedDate.toString()) {

        	        	             alert("The digital document: " + file.name + " already exists.")
        	        	             return (pre = file.previewElement) != null ? pre.parentNode.removeChild(file.previewElement) : void 0;

        	        	       }
        	        	     }
        	        });  
        	        
        	    }
        	});


        	this.on("removedfile", function(file) {  
               alert("remove file:"+file.val());
             
            		   
            });  
        	
        	
        	this.on("success", function(file, responseText) {
        	      // Handle the responseText here. For example, add the text to the preview element:
        	      file.previewTemplate.appendChild(document.createTextNode(responseText));
        	 });
        	this.on("maxfilesexceeded", function(file) { this.removeFile(file); });
        	
  
              
        });
   

        
        
     
        
  
    </script>
    
    

</body>

</html>

