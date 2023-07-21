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
        <jsp:useBean id="sk" class="dao.SkillDAO" scope = "request"></jsp:useBean>
        </head>
        <body>
            Hello       

        <c:forEach var="i" items="${sk.getSkillById(2)}">
            <span>${i}</span>
        </c:forEach>  
    </body>
</html>
