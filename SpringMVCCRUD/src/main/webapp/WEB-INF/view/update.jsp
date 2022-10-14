<%-- 
    Document   : Register
    Created on : Aug 11, 2016, 10:45:53 AM
    Author     : irfan
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<spring:url var="user_Update" value="/register/update"/>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="<%=request.getContextPath()%>/https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration Page</title>
        <script>
           function checkEmail(id, mail, studentId) {
                $.post('<spring:url value="/checkEmail" />', {mail: mail, studentId: studentId}, function(data) {
                    alert(data);
                    if (data != null && data != '' && data == true) {
                        alert("WARNING:\nYou cannot use this email-Id, This is already in use.");
                        $('#').val('');
                        $('#' + id).focus();
                    }
                });
            }  
            
            
        </script>
    </head>
    <body>
        <h1>${msg}</h1>
        <f:form action="${user_Update}" modelAttribute="cmd">
            Name:<f:input path="name" required="true" />
            <f:hidden path="id"  /><br>
            password:<f:password path="password" required="true" /><br>
            Email:<f:input path="email" required="true" onblur="checkEmail(this.id,this.value,'${cmd.id}');" autocomplete="off" /><br>
            Salary:<f:input path="salary" required="true" /><br>
            <f:button>Register</f:button>
    </f:form>
        </body>
</html>
