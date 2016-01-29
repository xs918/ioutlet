<!DOCTYPE html>
<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>IOLT | Dashboard</title>

   
    <!-- Toastr style -->
    <link href="<%=request.getContextPath()%>/css/plugins/toastr/toastr.min.css" rel="stylesheet">
     
     <link rel="stylesheet" href="<%=request.getContextPath()%>/font-awesome/css/font-awesome.min.css">
    
     
     <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" >
  
      <!-- Gritter -->
    <link href="<%=request.getContextPath()%>/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/css/animate.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">
    
    

	
    <!-- Mainly scripts -->
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    
    
    <script>
    var skinurl="<%=request.getContextPath()%>/skin-config.html";
     </script>
    
    
     <s:url includeParams="none" id="scripts.main" value="/js/main.js"/>
    <script type="text/javascript" src="<s:property value="%{scripts.main}"/>"></script>
    
     <s:url includeParams="none" id="scripts.moment" value="/js/moment.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.moment}"/>"></script>
     
     
     <s:url includeParams="none" id="scripts.combodate" value="/js/combodate.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.combodate}"/>"></script>
     

    
    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/plugins/dataTables/datatables.min.js">
	</script>
	

    <!-- Flot -->
    <script src="<%=request.getContextPath()%>/js/plugins/flot/jquery.flot.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/flot/jquery.flot.pie.js"></script>

    <!-- Peity -->
    <script src="<%=request.getContextPath()%>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="<%=request.getContextPath()%>/js/inspinia.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/pace/pace.min.js"></script>

    <!-- jQuery UI -->
    <script src="<%=request.getContextPath()%>/js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- GITTER -->
    <script src="<%=request.getContextPath()%>/js/plugins/gritter/jquery.gritter.min.js"></script>

    <!-- Sparkline -->
    <script src="<%=request.getContextPath()%>/js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Sparkline demo data  -->
    <script src="<%=request.getContextPath()%>/js/demo/sparkline-demo.js"></script>

    <!-- ChartJS-->
    <script src="<%=request.getContextPath()%>/js/plugins/chartJs/Chart.min.js"></script>

    <!-- Toastr -->
    <script src="<%=request.getContextPath()%>/js/plugins/toastr/toastr.min.js"></script>
	
	
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.0/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>

 <link href="<%=request.getContextPath()%>/css/plugins/dropzone/basic.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/plugins/dropzone/dropzone.css" rel="stylesheet">
      <script src="<%=request.getContextPath()%>/js/plugins/pace/pace.min.js"></script>

    <!-- DROPZONE -->
    <script src="<%=request.getContextPath()%>/js/plugins/dropzone/dropzone.js"></script>
     </head>
  
  
<body>
  
    
	    <nav class="navbar-default navbar-static-side" role="navigation">
	      <div class="sidebar-collapse">
	        <tiles:insertAttribute name="leftsidebar" />
	       </div>
	    </nav>
	   <div id="page-wrapper" class="gray-bg">
	        <div class="row border-bottom">
	          <tiles:insertAttribute name="header" />
	       </div>
		    
		


		    
		
		   <div class="row wrapper border-bottom white-bg page-heading">
		     <div class="col-lg-10">
		        <h2>Layouts</h2>
		        <ol class="breadcrumb">
		            <li>
		                <a href="index.html">Home</a>
		            </li>
		            <li class="active">
		                <strong>Layouts</strong>
		            </li>
		        </ol>
		     </div>
		     <div class="col-lg-2">
		     </div>
		 </div>
		
		 <div class="wrapper wrapper-content  animated fadeInRight">
		 
		    <s:if test="hasActionErrors()">  
			    <div class="alert text-center alert-danger fade in">
				    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				    <strong><s:property value="%{getText('error.colon')}"/></strong> 
				   
					 <s:iterator value="actionErrors">
						<span class="msg"><s:property escape="false" />
						</span>
					 </s:iterator>
			   	</div>
		 	 </s:if>
		  
		    <s:if test="hasActionMessages()">  
			    <div class="alert text-center alert-info fade in">
			    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    <strong><s:property value="%{getText('info.colon')}"/></strong> 
			    <s:iterator value="actionMessages">
			    	<span class="msg"><s:property escape="false" />
				</span>
		        </s:iterator>
		        </div>
		  	</s:if>

           <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                     <div class="ibox-content">
 
		
  					     <tiles:insertAttribute name="content" />
        			 </div>
        		     </div>
		  		</div>
		  </div>
		  
		</div>
		
		<div class="footer" >
 			<tiles:insertAttribute name="footer" />
		</div>

	</div>



    <script>
        $(document).ready(function() {
            setTimeout(function() {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 4000
                };
                toastr.success('Responsive Admin Theme', 'Welcome to INSPINIA');

            }, 1300);


        }

         );
    </script>
   
  </body>
</html>
