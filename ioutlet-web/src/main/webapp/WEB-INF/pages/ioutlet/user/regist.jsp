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
}





</script>




<body>
<s:form enctype="multipart/form-data" theme="bootstrap"  method="post"
  cssClass="form-horizontal" label="%{getText('register.a.new.membership')}">
            
            

            
                
                     <s:textfield
                        label="%{getText('login.id')}"
                        name="userId"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your login id here"/>
                           
                           
                      <s:textfield
                       label="%{getText('full.name')}"
                        name="name"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your full name here"/>
                        
                        
                        
                   <s:textfield
                        label="%{getText('email')}"
                        name="emailId"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Name here"/>
                        
                        
                        

                <s:password
                        label="%{getText('password')}"
                        name="password"
                          elementCssClass="col-sm-3"
                          maxLength="25"
                          placeholder="%{getText('login.pwd')}" 
                        tooltip="Enter your Password here"/>



            
            
                 <s:password
                          label="%{getText('retype.password')}"
                        name="retypePassword"
                          elementCssClass="col-sm-3"
                          maxLength="25"
                        tooltip="Enter your Password here"/>


            
            
                 
                        <s:select
                        tooltip="Choose your gender here"
                        label="Gender"
                        list="genderMap"
                        elementCssClass="col-sm-3"
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
                            elementCssClass="col-sm-4"
                        cols="50"
                        rows="4"/>
                
     
                 
                       <s:select
                        tooltip="What language you prefer use"
                        label="language"
                        list="langMap"
                        elementCssClass="col-sm-3"
                        name="langCode"
                 />
                 
                 
                        
                        
                                   
                <s:select
                        tooltip="Where are you from"
                        label="Location"
                        list="locMap"
                        elementCssClass="col-sm-3"
                        name="currLoc"
                 />

              

    
         <s:textfield
                        label="Reg No. Of Company"
                        name="regNoOfCompany"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Company Reg. No. here"/>
           
                <s:textfield
                        label="Name of Company"
                        name="nameOfCompany"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Name here"/>
           
                <s:textfield
                        label="Telephone of Company"
                        name="telephone"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Company Telephone here"/>
           
            
                <s:textfield
                        label="detail address"
                        name="address"
                            elementCssClass="col-sm-4"
                        tooltip="Enter your address here"/>


                <s:textfield
                        label="post code"
                        name="postCode"
                            elementCssClass="col-sm-2"
                        tooltip="Enter your postcode here"/>
                        
         <s:submit cssClass="btn btn-primary pull-right" onclick="return submitForm()" />
         </s:form>

</body>
</html>