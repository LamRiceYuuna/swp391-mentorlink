<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : test
    Created on : Jun 24, 2023, 5:08:35 PM
    Author     : Tuan Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${mess}
        <h1>Hello World! </h1>
    <c:forEach var="s" items="${skills}">
        ${s}
    </c:forEach>       
    </body>
</html>
