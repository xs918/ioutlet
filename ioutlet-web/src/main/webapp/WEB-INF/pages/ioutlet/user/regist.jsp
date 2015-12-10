<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <meta charset="utf-8">
     <title>Advanced Examples - Struts2 Bootstrap Plugin Showcase - 
   </title>
     <meta name="viewport" content="width=device-width, initial-scale=1">
     


    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
     <sj:head jqueryui="false"/>
     <s:head />
</head>

<script type="text/javascript">
function submitForm(myForm)
{
	var myForm = document.getElementsByTagName("form");
	myForm[0].action="form!"
	myForm[0].submit();
};



</script>

<style type="text/css">

.stepwizard-step p {
    margin-top: 10px;
}

.stepwizard-row {
    display: table-row;
}

.stepwizard {
    display: table;
    width: 100%;
    position: relative;
}

.stepwizard-step button[disabled] {
    opacity: 1 !important;
    filter: alpha(opacity=100) !important;
}

.stepwizard-row:before {
    top: 14px;
    bottom: 0;
    position: absolute;
    content: " ";
    width: 100%;
    height: 1px;
    background-color: #ccc;
    z-order: 0;

}

.stepwizard-step {
    display: table-cell;
    text-align: center;
    position: relative;
}

.btn-circle {
  width: 30px;
  height: 30px;
  text-align: center;
  padding: 6px 0;
  font-size: 12px;
  line-height: 1.428571429;
  border-radius: 15px;
}
</style>


<body>
<div class="container">
  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
</div>

 <div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
  
		    <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">User Registration</h4>
		      </div>
    
        <div class="modal-body">
<div class="stepwizard">
    <div class="stepwizard-row setup-panel">
        <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
            <p>Account Info</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle" >2</a>
            <p>Personal Info</p>
        </div>
         
        <div class="stepwizard-step">
            <a href="#step-3" type="button" class="btn btn-default btn-circle" >3</a>
            <p>Company Info</p>
        </div>
        
        <div class="stepwizard-step">
            <a href="#step-4" type="button" class="btn btn-default btn-circle" >4</a>
            <p>Service Tier</p>
        </div>
  
        
        
        
    </div>
</div>


<s:form enctype="multipart/form-data" theme="bootstrap" action="form" method="post"
  cssClass="form-Vertical">
   <s:include value="/WEB-INF/pages/common/formparts/common.jsp" />           
   <div class="row setup-content" id="step-1">
      <div class="col-xs-2">
			          </div>
			          
		  <div class="col-xs-8">
		  <h3> Account Info</h3>
		                   <s:textfield
		                        label="%{getText('login.id')}"
		                        name="userId"
		                          maxLength="50"
		                        tooltip="Enter your login id here"/>
		                           
		                           
		                         <s:textfield
		                        label="%{getText('email')}"
		                        name="emailId"
		                         maxLength="50"
		                        tooltip="Enter your Name here"/>
		                        
		                        
		
		                <s:password
		                        label="%{getText('password')}"
		                        name="password"
		                           maxLength="25"
		                          placeholder="%{getText('login.pwd')}" 
		                        tooltip="Enter your Password here"/>
		
		
		
		            
		            
		                 <s:password
		                          label="%{getText('retype.password')}"
		                        name="retypePassword"
		                            maxLength="25"
		                        tooltip="Enter your Password here"/>
		                        
                
		                <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
			          </div>
			          
			          <div class="col-xs-2">
			          </div>
   </div>     
            
   <div class="row setup-content" id="step-2">
          <div class="col-xs-12">
            <h3>User Information</h3>
            
                <s:textfield
		                       label="%{getText('full.name')}"
		                        name="name"
		                          maxLength="50"
		                        tooltip="Enter your full name here"/>
		                        
		                        
		                        
		            
		                        
		                        
                        <s:select
                        tooltip="Choose your gender here"
                        label="Gender"
                        list="genderMap"
                          name="gender"
                        />
                 
                      <s:file
                        tooltip="Upload Your Picture"
                        label="Picture"
                        name="profileImg"/>
                        
                        
                  <s:textarea
                        tooltip="enter your other descrption"
                        label="Description"
                        name="description"
                         cols="50"
                        rows="4"/>
                
     
                 
                       <s:select
                        tooltip="What language you prefer use"
                        label="language"
                        list="langMap"
                         name="langCode"
                 />
                 
                 
                        
                        
                                   
                <s:select
                        tooltip="Where are you from"
                        label="Location"
                        list="locMap"
                         name="currLoc"
                 />
  <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
          </div>
    </div>
              

    <div class="row setup-content" id="step-3">
          <div class="col-xs-12">
            <h3> Company Information</h3>
		         <s:textfield
		                        label="Reg No. Of Company"
		                        name="regNoOfCompany"
		                        elementCssClass="col-sm-3"
		                        maxLength="50"
		                        tooltip="Enter your Company Reg. No. here"/>
		           
		                <s:textfield
		                        label="Name of Company"
		                        name="nameOfCompany"
		                         maxLength="50"
		                        tooltip="Enter your Name here"/>
		           
		                <s:textfield
		                        label="Telephone of Company"
		                        name="telephone"
		                         maxLength="50"
		                        tooltip="Enter your Company Telephone here"/>
		           
		            
		                <s:textfield
		                        label="detail address"
		                        name="address"
		                          tooltip="Enter your address here"/>
		
		
		                <s:textfield
		                        label="post code"
		                        name="postCode"
		                          tooltip="Enter your postcode here"/>
		                <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
		                
		   </div>
	</div>                     
       
       
       <div class="row setup-content" id="step-4">
          <div class="col-xs-12">
            <h3>Choose your plan</h3>
            
             <div class="col-xs-6">
             
      <table class="table">
    <thead>
      <tr>
        <th>Plan</th>
        <th>Cost</th>
        <th colspan="2">Benifit</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Free</td>
        <td>$0/month</td>
        <td>free add 5 
</td>
<td>
  <button class="btn btn-default" type="button" >Choose</button>
</td>
      </tr>
      <tr>
        <td>Basic</td>
        <td>$5/mth</td>
        <td>free add 10 product</td>
       <td>
  <button class="btn btn-default" type="button" >Choose</button>
</td>
      </tr>
      <tr>
        <td>Advance</td>
        <td>$10/month</td>
        <td>ulitmiate add product and view the product review,customer report</td>
        <td>
  <button class="btn btn-default" type="button" >Choose</button>
</td>
      </tr>
    </tbody>
  </table>
  </div>
    <div class="col-xs-6">
    
    <div class="panel panel-default">
	  <div class="panel-heading">Each plan includes:</div>
	  <div class="panel-body">Free setup</div>
	   <div class="panel-body">Custome reminder</div>
	    <div class="panel-body">Email support</div>
	</div>


    </div>
             <s:submit cssClass="btn btn-success btn-lg pull-right" onclick="isSubmit()" />
    	   </div>
	</div>                     
               
         </s:form>
         </div> <!--  modal body -->
         
           
        
         </div>
         </div>
</div>
<script src="<%=request.getContextPath()%>/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script>
$(document).ready(function () {
	    var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
                $item = $(this);

        if (!$item.hasClass('disabled')) {
            navListItems.removeClass('btn-primary').addClass('btn-default');
            $item.addClass('btn-primary');
            allWells.hide();
            $target.show();
            $target.find('input:eq(0)').focus();
        }
    });

    allNextBtn.click(function(){
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
            curInputs = curStep.find("input[type='text'],input[type='url']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for(var i=0; i<curInputs.length; i++){
            if (!curInputs[i].validity.valid){
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid)
            nextStepWizard.removeAttr('disabled').trigger('click');
    });

    $('div.setup-panel div a.btn-primary').trigger('click');
});
</script>

</body>
</html>