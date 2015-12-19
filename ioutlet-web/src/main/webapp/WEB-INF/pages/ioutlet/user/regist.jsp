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


  		
		        
		        <h4>User Registration
		
		           <a href="login"><span class="fa fa-sign-in"></span>Login</a>
		           
			 </h4>
		     
		 
		 
		        

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
		                        label="%{getText('user.id')}"
		                        name="userId"
		                        maxLength="50"
		                        placeholder="%{getText('only.allow.letters.numbers.and.underscore')}"
		                     />
		                           
		                           
		                        <s:textfield
		                        label="%{getText('email')}"
		                        name="emailId"
		                        maxLength="50"
		                        placeholder="sample@gmail.com"
		                         />
		                        
		                        
		
		                <s:password
		                        label="%{getText('password')}"
		                        name="password"
		                        placeholder="%{getText('at.least.6.characters')}"
		                        maxLength="25"
		                 />
		
		
		            
		            
		                 <s:password
		                          label="%{getText('retype.password')}"
		                        name="retypePassword"
		                          required = "true"
		                            maxLength="25"
		                       placeholder="%{getText('retype.your.password.here')}"/>
		                        
                
		                <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >
		                  <s:property value="%{getText('next')}"/>
		                </button>
			          </div>
			          
			          <div class="col-xs-2">
			          </div>
   </div>     
            
   <div class="row setup-content" id="step-2">
         <div class="col-xs-2">
			          </div>
			          
		  <div class="col-xs-8">
		  
        
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
                 
  
                  				 <s:file name="userImgFiles"  label="%{getText('update.profile.picture')}" multiple="true"/>
                    
  
				                  <s:textarea
				                        tooltip="%{getText('enter.your.details.here')}"
				                        label="%{getText('description')}"
				                        name="description"
				                         cols="50"
				                        rows="4"/>
				                
     
				                 
				                  <s:select
				                        tooltip="%{getText('What.default.language.you.prefer.use')}"
				                        label="%{getText('default.language')}"
				                        list="langMap"
				                         name="langCode"
				                 />
				                 
                 
                        
                        
                                   
			                <s:select
			                        tooltip="%{getText('location')}"
			                        label="%{getText('location')}"
			                        list="locMap"
			                         name="currLoc"
			                 />
			                 
			          
  <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >  
   <s:property value="%{getText('next')}"/>
  </button>
          </div>
          		  <div class="col-xs-2">
          		  </div>
    </div>
              

    <div class="row setup-content" id="step-3">
      <div class="col-xs-2">
          		  </div>
          <div class="col-xs-8">
            <h3> Company Information</h3>
		         <s:textfield
		          label="%{getText('reg.no.of.company')}"
		                        name="regNoOfCompany"
		                        maxLength="50"
		                        tooltip="%{getText('enter.your.regist.no.of.company')}"/>
		           
		           
		          <s:textfield
		          label="%{getText('name.of.company')}"
		                        name="nameOfCompany"
		                        maxLength="150"
		                        tooltip="%{getText('enter.your.name.of.company')}"/>
		             
		                      <s:textfield
		                       label="%{getText('telephone')}"
		                       name="telephone"
		                       maxLength="20"
		                       tooltip="%{getText('enter.your.telephone.no.here')}"
		                       
		                       />
		                                  
		                        
		                              <s:textfield
		                       label="%{getText('detail.address')}"
		                       name="address1"
		                       maxLength="50"
		                       tooltip="%{getText('enter.your.detail.address')}"
		                       
		                       />
		                       
		                        <s:textfield
		                       name="address2"
		                       maxLength="50"
		                       
		                       />
		                       <s:textfield
		                       name="address3"
		                       maxLength="50"
		                       
		                       />
		                       
		                      <s:textfield
		                        label="%{getText('post.code')}"
		                        name="postCode"
		                        tooltip="%{getText('enter.your.post.code')}"
		                       />
		                       
			         	             <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
		                
		   </div>
		     <div class="col-xs-2">
          		  </div>
          		  
	</div>                     
       
       
       <div class="row setup-content" id="step-4">
         <div class="col-xs-2">
          		  </div>
          		  
          <div class="col-xs-8">
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
    	     <div class="col-xs-2">
          		  </div>
	</div>                     
               
         </s:form>
         </div> <!--  modal body -->
         
           
        

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