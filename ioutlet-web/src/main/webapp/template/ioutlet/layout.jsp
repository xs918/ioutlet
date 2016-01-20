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
    
     <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" >
  
  
      <!-- Gritter -->
    <link href="<%=request.getContextPath()%>/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/css/animate.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    
    
    <s:url includeParams="none" id="scripts.main" value="/js/main.js"/>
    <script type="text/javascript" src="<s:property value="%{scripts.main}"/>"></script>
    
     <s:url includeParams="none" id="scripts.moment" value="/js/moment.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.moment}"/>"></script>
     
     
     <s:url includeParams="none" id="scripts.combodate" value="/js/combodate.js"/>
     <script type="text/javascript" src="<s:property value="%{scripts.combodate}"/>"></script>
     
    <!-- Bootstrap 3.3.5 -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
   
    
    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/plugins/dataTables/datatables.min.js">
	</script>
	
	
    <!-- Mainly scripts -->
    <script src="<%=request.getContextPath()%>/js/jquery-2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

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


            var data1 = [
                [0,4],[1,8],[2,5],[3,10],[4,4],[5,16],[6,5],[7,11],[8,6],[9,11],[10,30],[11,10],[12,13],[13,4],[14,3],[15,3],[16,6]
            ];
            var data2 = [
                [0,1],[1,0],[2,2],[3,0],[4,1],[5,3],[6,1],[7,5],[8,2],[9,3],[10,2],[11,1],[12,0],[13,2],[14,8],[15,0],[16,0]
            ];
            $("#flot-dashboard-chart").length && $.plot($("#flot-dashboard-chart"), [
                data1, data2
            ],
                    {
                        series: {
                            lines: {
                                show: false,
                                fill: true
                            },
                            splines: {
                                show: true,
                                tension: 0.4,
                                lineWidth: 1,
                                fill: 0.4
                            },
                            points: {
                                radius: 0,
                                show: true
                            },
                            shadowSize: 2
                        },
                        grid: {
                            hoverable: true,
                            clickable: true,
                            tickColor: "#d5d5d5",
                            borderWidth: 1,
                            color: '#d5d5d5'
                        },
                        colors: ["#1ab394", "#1C84C6"],
                        xaxis:{
                        },
                        yaxis: {
                            ticks: 4
                        },
                        tooltip: false
                    }
            );

            var doughnutData = [
                {
                    value: 300,
                    color: "#a3e1d4",
                    highlight: "#1ab394",
                    label: "App"
                },
                {
                    value: 50,
                    color: "#dedede",
                    highlight: "#1ab394",
                    label: "Software"
                },
                {
                    value: 100,
                    color: "#A4CEE8",
                    highlight: "#1ab394",
                    label: "Laptop"
                }
            ];

            var doughnutOptions = {
                segmentShowStroke: true,
                segmentStrokeColor: "#fff",
                segmentStrokeWidth: 2,
                percentageInnerCutout: 45, // This is 0 for Pie charts
                animationSteps: 100,
                animationEasing: "easeOutBounce",
                animateRotate: true,
                animateScale: false
            };

            var ctx = document.getElementById("doughnutChart").getContext("2d");
            var DoughnutChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);

            var polarData = [
                {
                    value: 300,
                    color: "#a3e1d4",
                    highlight: "#1ab394",
                    label: "App"
                },
                {
                    value: 140,
                    color: "#dedede",
                    highlight: "#1ab394",
                    label: "Software"
                },
                {
                    value: 200,
                    color: "#A4CEE8",
                    highlight: "#1ab394",
                    label: "Laptop"
                }
            ];

            var polarOptions = {
                scaleShowLabelBackdrop: true,
                scaleBackdropColor: "rgba(255,255,255,0.75)",
                scaleBeginAtZero: true,
                scaleBackdropPaddingY: 1,
                scaleBackdropPaddingX: 1,
                scaleShowLine: true,
                segmentShowStroke: true,
                segmentStrokeColor: "#fff",
                segmentStrokeWidth: 2,
                animationSteps: 100,
                animationEasing: "easeOutBounce",
                animateRotate: true,
                animateScale: false
            };
            var ctx = document.getElementById("polarChart").getContext("2d");
            var Polarchart = new Chart(ctx).PolarArea(polarData, polarOptions);

        });
    </script>
   
  </body>
</html>
