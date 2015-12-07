<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <meta charset="utf-8">
     <title>Advanced Examples - Struts2 Bootstrap Plugin Showcase - 
     <s:text name="showcase.version"/></title>
     <meta name="viewport" content="width=device-width, initial-scale=1">
     
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
     <sj:head jqueryui="false"/>
</head>
<body>
<s:form enctype="multipart/form-data" theme="bootstrap" 
  cssClass="form-horizontal" label="%{getText('register.a.new.membership')}">
                
                         <s:textfield
                        label="Name"
                        name="name"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Name here"/>
                        
                        
                   <s:textfield
                        label="email"
                        name="email"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Name here"/>
                        
                        
                        

                <s:password
                        label="Password"
                        name="password"
                          elementCssClass="col-sm-3"
                          maxLength="25"
                        tooltip="Enter your Password here"/>

                 <s:password
                        label="Retype Password"
                        name="password"
                          elementCssClass="col-sm-3"
                          maxLength="25"
                        tooltip="Enter your Password here"/>

           

                 
                        <s:select
                        tooltip="Choose your gender here"
                        label="Gender"
                        list="{'Male', 'Female', 'Other'}"
                        elementCssClass="col-sm-3"
                        name="country"
                        />
                 
                      <s:file
                        tooltip="Upload Your Picture"
                        label="Picture"
                        name="Profile"/>
                        
                        
                  <s:textarea
                        tooltip="enter your other descrption"
                        label="Description"
                        name="description"
                        cols="50"
                        rows="4"/>
                
     
                 
                       <s:select
                        tooltip="What lunguage you prefer use"
                        label="Lunguage"
                        list="{'English', 'Chinese', 'Korean'}"
                        elementCssClass="col-sm-3"
                        name="country"
                 />
                 
                 
                        
                        
                                   
                <s:select
                        tooltip="Where are you from"
                        label="Location"
                        list="{'Singapore', 'China', 'USA'}"
                        elementCssClass="col-sm-3"
                        name="country"
                 />

              

    
         <s:textfield
                        label="Reg No. Of Company"
                        name="regNoOfCompany"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Company Reg. No. here"/>
           
                <s:textfield
                        label="Name of Company"
                        name="NameOfCompany"
                        elementCssClass="col-sm-3"
                        maxLength="50"
                        tooltip="Enter your Name here"/>
           
                <s:textfield
                        label="Telephone of Company"
                        name="Telephone"
                        elementCssClass="col-sm-3"
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
                        
         <s:submit cssClass="btn btn-primary pull-right"/>
         </s:form>

</body>
</html>