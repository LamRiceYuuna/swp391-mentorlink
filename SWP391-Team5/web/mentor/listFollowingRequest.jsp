<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : listFollowingRequest
    Created on : Jun 14, 2023, 1:06:39 AM
    Author     : Tuan Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance Dashboard | By Code Info</title>
        <link rel="stylesheet" href="assets/css/listFollowing.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <jsp:include page="../home/header.jsp"/>


        <div class="container3">

            <section class="main">
                <section class="attendance">
                    <div class="attendance-list">
                        <h1 style="text-align: center;">Attendance List</h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Title</th>
                                    <th>Content</th>
                                    <th>Start Time</th>
                                    <th>End Time</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" begin="0" end="${listR.size() - 1}" step="1">
                                    <tr>
                                        <td>${i + 1}</td>
                                        <td>${listR.get(i).getTitle()}</td>
                                        <td>${listR.get(i).getRequest_content()}</td>
                                        <td>${listR.get(i).getCreated_date()}</td>
                                        <td>${listR.get(i).getFinish_date()}</td>
                                        <td>
                                            <div>
                                                <button>Accept</button>
                                                <button>Reject</button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>                                         
                            </tbody>
                        </table>
                    </div>
                </section>
            </section>
        </div>
        <div id="footer">
            <jsp:include page="../home/footer.jsp"/>
        </div>
        <style>
            #footer {
                position: absolute;
                left: 0;
                bottom: 0;
                width: 100%;
            }
        </style>

    </body>
</html>
