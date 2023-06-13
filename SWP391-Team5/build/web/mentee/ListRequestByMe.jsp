<%-- 
    Document   : ListRequestByMe
    Created on : Jun 11, 2023, 5:03:53 PM
    Author     : damtu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
            }
            tr:hover {
                background-color: #f5f5f5;
            }
        </style>
        <script>
            window.onload = function () {
                var totalStudyTime = 0;
                var rowCount = 0;
                var timeStudyCells = document.querySelectorAll("td:nth-child(6)"); // Update the cell index to 6 for the "Study Time" column

                timeStudyCells.forEach(function (cell) {
                    var timeStudy = parseInt(cell.textContent);
                    if (!isNaN(timeStudy)) {
                        totalStudyTime += timeStudy;
                    }
                });

                rowCount = document.querySelectorAll("tr").length - 2; // Remove the duplicate variable declaration

                var totalStudyTimeCell = document.getElementById("totalStudyTime");
                totalStudyTimeCell.textContent = totalStudyTime;

                var totalRequestsCell = document.getElementById("totalRequestsCount"); // Update the query selector to target the correct cell
                totalRequestsCell.textContent = rowCount;
            };
        </script>

    </head>
    <body>
        <h1>Request Information</h1>
        <form >
            <table>
                <tr>
                    <th>#</th>
                    <th>Mentor ID</th>
                    <th>Mentee ID</th>
                    <th>Title</th>
                    <th>Nội dung yêu cầu</th>
                    <th>Thời gian học</th>
                    <th>Ngày tạo</th>
                    <th>Ngày hoàn thành</th>
                    <th>Trạng thái</th>
                    <th></th> 
                </tr>

                <c:forEach items="${lista}" var="o" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${o.mentor_id}</td>
                        <td>${o.mentee_id}</td>
                        <td>${o.title}</td>
                        <td>${o.request_content}</td>
                        <td>${o.time_study}</td> 
                        <td>${o.created_date}</td>
                        <td>${o.finish_date}</td>
                        <td>
                            <c:choose>
                                <c:when test="${o.request_status == 1}">Mở</c:when>
                                <c:when test="${o.request_status == 2}">Đang xử lý</c:when>
                                <c:when test="${o.request_status == 3}">Đóng</c:when>
                                <c:when test="${o.request_status == 4}">Đã hoàn thành</c:when>
                                <c:otherwise>Không xác định</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="http://localhost:9999/SWP391-Group5/requestdeleteControl?idDel=${o.request_id}">Xóa</a>
                        </td>
                    
                </c:forEach>

                <tr>
                    <td><strong>Tổng số yêu cầu:</strong></td>
                    <td colspan="5"><strong id="totalRequestsCount"></strong></td>
                    <td><strong>Tổng thời gian học:</strong></td>
                    <td colspan="5"><strong id="totalStudyTime"></strong></td>
                </tr>
            </table>
        </form>

        
    </body>
</html>