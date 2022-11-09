<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChangePassword</title>
</head>
<body>

      <c:if test="${param.invalidoldpassword}">

          <i style="color: red">  Invalid Old Password </i>

      </c:if>


  <div  align="Center">


      <form:form action="processchange"  modelAttribute="changepassword">


          <label> OldPassword </label>
          <form:password path="oldpassword"></form:password>
          <br>

          <label> NewPassword </label>
          <form:password path="newpassword"></form:password>
          <br>

          <label>confirmpassword</label>
          <form:password path="confirmpassword"></form:password>
          <br>

          <input type="submit" value="change" >

      </form:form>


  </div>


</body>
</html>