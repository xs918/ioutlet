<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>INSPINIA | E-commerce</title>

</head>

<body>
<s:url id="imageupload" namespace="/product" includeParams="none" action="productimageupload" />
		<s:form enctype="multipart/form-data" theme="bootstrap" action="form"
			method="post" calss="form-Vertical dropzone" id="myAwesomeDropzone">
			
			
			
			
                 	<div class="col-sm-2">
						<s:textfield label="%{getText('sku')}" name="	" maxLength="50"
							requiredLabel="true"
							placeholder="%{getText('pls key sku')}" />
					</div>       
                        
					<div class="col-sm-4">
						<s:textfield label="%{getText('Name')}" name="	" maxLength="50"
							requiredLabel="true"
							placeholder="%{getText('add.a.product.name')}" />
					</div>
        			<div class="col-sm-2">
						<s:textfield label="%{getText('Price')}" name="	" maxLength="50"
							requiredLabel="true" placeholder="%{getText('$')}" />


					</div>
			       <div class="col-sm-4"></div>

			
				<div class="col-sm-12">
						<s:textarea label="%{getText('description')}" name="description"
							cols="50"
							placeholder="%{getText('add short description of your product')}"
							rows="4" />
	
				</div>
                      

                 <div id="my-dropzone" class="dropzone col-sm-12" >
                <button id="submit-all">Submit all files</button>
                 </div>
                  <div class="fallback">
                 <input type="hidden" value="" id="file" name="file" multiple />
                 </div>
                        
                 <s:submit cssClass="btn btn-primary btn-sm pull-right" onclick="isSubmit('regist')" />         
                        
		</s:form>

                     

    <script>
        $(document).ready(function(){


        	$("#my-dropzone").dropzone({
        		 url:'<s:property value="%{imageupload}"/>',
        	     maxFiles: 10,
        	     maxFilesize: 15,
        	     acceptedFiles: "image/*",
        	     parallelUploads: 20,
        	   init: function() {
        	    	 var submitButton = document.querySelector("#submit-all")
        	         myDropzone = this; // closure

        	     submitButton.addEventListener("click", function() {
        	       myDropzone.processQueue(); // Tell Dropzone to process all queued files.
        	     });

        	     
        	        this.on("addedfile", function(file) {
        	        	var removeButton = Dropzone.createElement("<button>delete</button>");
        	        	  var _this = this;
        	        	  removeButton.addEventListener("click", function(e) {
        	                  // Make sure the button click doesn't submit the form:
        	                  e.preventDefault();
        	                  e.stopPropagation();
        	                  alert("rremove");

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
            
        });


      
    </script>

</body>

</html>

