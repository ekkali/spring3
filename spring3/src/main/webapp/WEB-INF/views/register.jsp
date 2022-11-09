<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>

   <form:form action="processregister" modelAttribute="user" >
   
   
     <label>UserName</label>
     <form:input path="username"/>
     
     <br>
     
     
     <label>Password</label>
     <form:password path="password"/>
     <br>
     
     <input type="submit" value="signup" >
   
   
   
   </form:form>




  


</body>
</html>