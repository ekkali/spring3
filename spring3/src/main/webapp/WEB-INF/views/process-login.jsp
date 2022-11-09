<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  
   <meta http-equiv="refresh" content="5; url='/spring3/demo/home'">

<title>RedirectPage</title>
</head>
<body>


      <c:if test="${param.invaliderror}">
  
        <i style="color: red;" >  Invalid UserName/Password  </i>
  
  
    </c:if>
  
  
  
     <c:if test="${param.error}">
  
      <i style="color: red;" >  Invalid UserName/Password  </i>
  
  
    </c:if>
     
  
  <h1 style="color: aqua;" >   Processing  </h1>
  
  
  

</body>
</html>