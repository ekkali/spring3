<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>


    <c:if test="${param.error}">
    
      <i style="color: red;">  Invalid Credentials   </i>
    
    </c:if>

   <h1 style="color: black;">  HomePage </h1>
   
   
     <h2>  Hi  ${username}  </h2>
     <br>
     
     


   <a  href="/spring3/demo/changepassword">  ChangePassword </a>


         <br>

      <a href="/spring3/demo/admin" >  AdminDashBoard </a>
      
      <br>
      

         <a   href="/spring3/demo/logout">  Logout </a>
         
         
         
         
         


</body>
</html>