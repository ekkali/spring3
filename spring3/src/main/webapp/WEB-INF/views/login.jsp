<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
   
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>


  
  <c:if test="${param.error}">
  
    <i style="color: red;" >  Invalid UserName/Password  </i>
  
  
  </c:if>



  <div  align="center">
  
  
   <form:form action="process-login"  modelAttribute="user">
   
   
     <label id="username" > UserName    </label>
      <form:input path="username"/>
     
     
     <br>
     
     <label> Password </label>
     <form:password path="password"/>
     
     <br>
     
     <input type="submit" value="Login" >
   
    
         
   
   
   </form:form>
  
  
  
  </div>
  
                 <a  href="/spring3/demo/register"> <span style="color: appworkspace;"> Don't' Have An Account SignUp Here For Free </span>  </a>


</body>
</html>