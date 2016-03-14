<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport"
       content="width=device-width, initial-scale=1">
<title>Spring MVC + Dropzone.js Example</title>

<link rel="stylesheet" type="text/css"
       href='<c:url value="/web-resources/libs/bootstrap-3.1.1/css/bootstrap.min.css"/>'>
<link rel="stylesheet" type="text/css"
       href='<c:url value="/web-resources/libs/bootstrap-dialog/css/bootstrap-dialog.min.css"/>'>
<link rel="stylesheet" type="text/css"
       href='<c:url value="/web-resources/css/style.css"/>'>

</head>
<body>
       <div class="container">
              <div class="panel panel-default">
                     <div class="panel-heading text-center">
                           <h3>Spring MVC + Dropzone.js Example</h3>
                     </div>
                     <div class="panel-body">
                           <div>
                                  <form id="dropzone-form" class="dropzone"
                                         enctype="multipart/form-data">

                                         <div class="dz-default dz-message file-dropzone text-center well col-sm-12">
                                                 <span class="glyphicon glyphicon-paperclip"></span> <span>
                                                       To attach files, drag and drop here</span><br>
                                                <span>OR</span><br>
                                                <span>Just Click</span>
                                         </div>

                                         <!-- this is were the previews should be shown. -->
                                         <div class="dropzone-previews"></div>
                                  </form>
                                  <hr>
                                  <button id="upload-button" class="btn btn-primary">
                                         <span class="glyphicon glyphicon-upload"></span> Upload
                                  </button>
                                  <a class="btn btn-primary pull-right" href="list"> <span
                                         class="glyphicon glyphicon-eye-open"></span> View All Uploads
                                  </a>
                           </div>
                     </div>
              </div>
       </div>

        <script>
        $(document).ready(function(){

        	Dropzone.options.dropzoneForm = {

        		      url : "/form/action/url",
        		      autoProcessQueue : false,
        		      uploadMultiple : true,
        		      maxFilesize : 256, // MB
        		      previewsContainer : ".dropzone-previews",
        		      
        		      init : function() {
        		           // handling events
        		      }
        		}

       });
    </script>
</body>
</html>