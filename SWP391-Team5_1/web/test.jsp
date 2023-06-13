<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : test
    Created on : Jun 11, 2023, 3:38:03 PM
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
        Hello ${m}
        
        ${fullName}
        ${gender}
        ${address}
        ${date}
    <c:forEach var="s" items="${skillId}">
        ${s}
    </c:forEach>
        
    </body>
</html>
