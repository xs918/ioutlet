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


	<!-- Start Post Attachments -->
                  <div class="modal fade" id="uploader" tabindex="-1" role="dialog" aria-labelledby="updater" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal">&times;</button>
                          <br>
                          <i class="icon-credit-card"></i>
                          <p class="no-margin">You can upload your product image max 10 files</p>
                        </div>
                   
                          <div id="my-dropzone" class="uploadform modal-body dropzone no-margin dz-clickable" >
                       		  <div class="dz-default dz-message">
	                          <span>Drop your Cover Picture here</span>
	                          </div>
	                          <div class="fallback">
				                 <input type="hidden" value="" id="file" name="file" multiple />
				              </div>
                         </div>
                          <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                        
                          
                      </div>
                      <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                  </div>
                  <!-- /.modal -->
  <!-- End Post Attachments -->
  
  
		<s:form enctype="multipart/form-data" theme="bootstrap" action="form"
			method="post" calss="form-Vertical dropzone" >
			
			
			<div class="col-sm-12">
			<h2>Basic Information</h2>
			</div>
				
               
                        
					<div class="col-sm-4">
						<s:textfield label="%{getText('name')}" name="	" maxLength="50"
							requiredLabel="true"
							placeholder="%{getText('add.a.product.name')}" />
					</div>
        			<div class="col-sm-2">
						<s:textfield label="%{getText('price')}" name="	" maxLength="50"
							requiredLabel="true" placeholder="%{getText('currency.symbol')}" />


					</div>
			       <div class="col-sm-6"></div>
			       
			
			     <div class="col-sm-12">
			    
			      <s:select
				                        tooltip="%{getText('category of your product')}"
				                        label="%{getText('collections')}"
				                        list="catlist"
				                        name="category"
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
		          
		          	<a data-toggle="modal" data-target="#uploader" >
		          	 <span class="fa fa-plus"></span>
		          	</a>
		          	
		          	
       			 </div>
                 <div class="col-sm-12">
                       <img class="thumb" src="" style="width:180px">
                   
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
				<small>Can this product have any discount?</small>
				
				<div id="edittable_discount"></div>
			</div>
			
			 <div class="col-sm-12">
			   <strong><s:property value="%{getText('Custom Text Field')}"/>
		       </strong>
				<small>Can this product be personalized? (Ex: custom text or special request)</small>
			</div>
			
		    <div class="col-sm-12">
			   <button type="button" class="btn btn-default pull-left" id="add_option"><i class="fa fa-plus"></i>Add Product Option</button>
			</div>
	
                                       
                 <s:submit cssClass="btn btn-primary btn-sm pull-right" onclick="isSubmit('regist')" />         
                        
		</s:form>

                     

    <script>
        $(document).ready(function(){
        	
        	
        	
        	var eTable=$("#edittable_discount").editTable({
        		headerCols: [
        			'Name',
        			'discountRate',
        			'discountAmount',
        			'quantity',
        			'startDate',
        			'endDate'
        		],
        		maxRows: 4
        	});
         	
        	$.ajax({
        		url: 	'<s:property value="%{discountadd}"/>',
        		type: 	'POST',
        		data: 	{
        			ajax: true
        		},
        		complete: function (result) {
        			eTable.loadJsonData(result.responseText);
        		}
        	});
         	

          	
          	
    
        	
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
        	
        	
        	
            $("$product_discount").hide();
              
        });
   

        
        
        
    </script>

</body>

</html>

