 <html>
	<head>
		<title>Unauthorized</title>
		
		 <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/skins/skin-blue.min.css">
		
		
	</head>
    <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
         <header class="main-header">
        <!-- Logo -->
        <a href="../../index2.html" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>A</b>LT</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Admin</b>LTE</span>
        </a>
         <nav class="navbar navbar-static-top" role="navigation">
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
         </nav>
        </header>
        <div class="content-wrapper">
           <section class="content">
              <div class="error-page">
               <h2 class="headline text-yellow">403</h2>
              </div>
              <div class="error-content">
              <h3><i class="fa fa-warning text-yellow"></i>Unauthorized page</h3>
                <p>You do not have sufficient priviledge to view the page.
              </div>
          </section>
         
        </div>
     </div> 
    <!-- REQUIRED JS SCRIPTS -->
    <!-- jQuery 2.1.4 -->
    <script src="<%=request.getContextPath()%>/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="<%=request.getContextPath()%>/dist/js/app.min.js"></script>

</body>
</html>