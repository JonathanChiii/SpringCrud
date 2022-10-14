<%-- 
    Document   : userList
    Created on : Aug 12, 2016, 8:41:52 PM
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td> Serial No </td>
                <td> Student Id </td>
                <td> Employee Name</td>
                <td> Employee Email</td>
                <td>Employee Password</td>
                <td> Employee Salary</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${empList}" var="user" varStatus="st">
            <tr>
            <!-- st for indexing, user refer to the current row-->
                <td> ${st.count} </td>
                <td> ${user.id} </td>
                <td> ${user.name}</td>
                <td> ${user.email}</td>
                <td>${user.password}</td>
                <td>${user.salary}</td>
                <td>
                    <a href="<spring:url value="/edit?id=${user.id}"/>">Edit</a> |
                    <a href="<spring:url value="/delete?id=${user.id}"/>">Delete</a> |
                    <a href="" >show-Password</a> |
                   </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
