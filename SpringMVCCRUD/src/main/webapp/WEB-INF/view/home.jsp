<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <spring:url var="url_style" value="resource/style.css"/>
        <link rel="stylesheet" href="${url_style}"/>
        <style>
       
    /*<link rel="stylesheet" href="${url_style}"/>*/
     </style>   
    </head>
<img src="resource/banner.jpg" />
        
        <h1 class="reding">Hello</h1>
                

        <spring:url value="register/form1" var="loginUrl" />
        <spring:url value="/login/form" var="RegUrl" />
        <spring:url value="/userList" var="userList" />
        <spring:url value="/userList1" var="userList1" />
        <a href="${loginUrl}">Click for Registration</a>
        <a href="${RegUrl}">Click for Login</a>
        <a href="${userList}">Click to show Student Information</a>
        <a href="${userList1}">Click to show Student Information in Json</a>
    </body>
</html>