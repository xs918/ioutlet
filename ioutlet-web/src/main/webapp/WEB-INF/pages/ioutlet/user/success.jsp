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




<body>
<s:form  theme="bootstrap" action="form"  method="post"
  cssClass="form-horizontal" label="%{getText('register.a.new.membership')}">
            
            

            
                
                     <s:label value="%{getText('login.id')}"
                      />
                       
                     <s:label value="%{userId}"
                      />
         
                      <s:label value="%{getText('full.name')}"/>
                      <s:label value="%{name}"/>
                      
                      
                      
                      
                        
                        
                   <s:label
                        value="%{getText('email')}"
                        />
                        <s:label
                        value="%{emailId}"
                        />
                        
                        
                               <s:label
                        value="%{getText('password')}"
                        />
                        <s:label
                        value="%{password}"
                        />
                        
     
                               <s:label
                        value="%{getText('gender')}"
                        />
                        <s:label
                        value="%{gender}"
                        />
                        




             <s:label
                        value="%{getText('description')}"
                        />
                        <s:label
                        value="%{description}"
                        />
                        
                        
                                <s:label
                        value="%{getText('language')}"
                        />
                        <s:label
                        value="%{langCode}"
                        />
                        
                        
                        
                      
                       <s:label
                        value="%{getText('location')}"
                        />
                        <s:label
                        value="%{currLoc}"
                        />
                        
                        
                        
               
               
                 
                   
                 
                 
                        
                        <s:label
                        value="%{getText('reg.no.of.company')}"
                        />
                        <s:label
                        value="%{regNoOfCompany}"
                        />
                        
                        
                               
                        <s:label
                        value="%{getText('name.of.company')}"
                        />
                        <s:label
                        value="%{nameOfCompany}"
                        />
                        
                        
                                                   
                  <s:label
                        value="%{getText('telephone.of.Company')}"
                        />
                        <s:label
                        value="%{telephone}"
                        />
                        
                        
                                                   
               <s:label
                        value="%{getText('address')}"
                        />
                        <s:label
                        value="%{address}"
                        />
                                                             
               <s:label
                        value="%{getText('postCode')}"
                        />
                        <s:label
                        value="%{postCode}"
                        />
                        
                        
                                     
         
                       <s:label
                        value="%{getText('actionType')}"
                        />
                        <s:label
                        value="%{actionType}"
                        />
                        
                        
                                     
               
                                     
      <s:include value="/WEB-INF/pages/common/formparts/common.jsp" />     
   
       	<s:submit value="%{getText('previous')}" cssClass="btn btn-primary pull-right" onclick="return isBack('form')">
		</s:submit>
         
         
         <s:submit cssClass="btn btn-primary pull-right" onclick="return submitForm()" />
         </s:form>

</body>
</html>