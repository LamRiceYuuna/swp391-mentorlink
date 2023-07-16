<%-- 
    Document   : listrequestbyme
    Created on : Jul 16, 2023, 5:05:05 PM
    Author     : Tuan Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Table Design || Future Web</title>
        <link rel="stylesheet" href="assets/css/listrequestbyme.css"/>
    </head>

    <style>
        .title {
            height: 90px;
            width: 550px;
            color: white;
            background-color: #175E4C;
            text-align: center;
            border-radius: 46px;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 30px;
        }

        .outer {
            display: flex;
            justify-content: center;
        }

        .num {
            margin: 15px 0px;
            height: 31px;
            width: 333px;
            color: white;
            border-radius: 14px;
            background-color: #175E4C;
            text-align: center;
            font-size: 70px;
        }

    </style>

    <body>
        <jsp:include page="../home/header.jsp"/>

        <div class="header_fixed">
            <div class="outer">
                <div class="title">
                    <h1>List Request</h1>
                </div>
            </div>
            <div class="num">
                <h4>Total number of requests: 15</h4>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>S No.</th>
                        <th>Image</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Department</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>
                            <img src=https://drive.google.com/uc?export=view&id=1qw3KUJnYgvnJHQP-yY13u_rXrJO8ZbL_ />
                            <img src=https://drive.google.com/uc?export=view&id=1qw3KUJnYgvnJHQP-yY13u_rXrJO8ZbL_ />
                            <img src=https://drive.google.com/uc?export=view&id=1qw3KUJnYgvnJHQP-yY13u_rXrJO8ZbL_ />
                        </td>
                        <td>Rakhi Gupta</td>
                        <td>rakhigupta@gmail.com</td>
                        <td>Engineering</td>
                        <td>
                            <button>View</button>
                            <button>View</button>
                            <button>View</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1KV8Ob2wXIcobIvayGGDB1qUpQn_iZKIp /></td>
                        <td>Anjali</td>
                        <td>anjali@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1ock7haLmYaAbHe8yn9H8ZGgkaGY9lcB0 /></td>
                        <td>Vejata Gupta</td>
                        <td>Vejata@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1MbkS3AwaCNaKfMTmCQMHD1okQEubCdnt /></td>
                        <td>Shweta</td>
                        <td>Shweta@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1oztRYJUSZ5txDbaAAGg0O8_Ek6nzLAId /></td>
                        <td>Adarsh</td>
                        <td>Adarsh@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1ysB5QChCSLpz3igUoDzalENFsjJEe8H7 /></td>
                        <td>Monti</td>
                        <td>Monti@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1fCtvhYFy1roieanYeXua1jKJyfUhiDS6 /></td>
                        <td>Arpit</td>
                        <td>Arpit@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td><img src=https://drive.google.com/uc?export=view&id=1ZHPBm7fBxfbW2qV8pLTeDvMreXzqcW-x /></td>
                        <td>Priya</td>
                        <td>priya@gmail.com</td>
                        <td>Engineering</td>
                        <td><button>View</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <jsp:include page="../home/footer.jsp"/>
    </body>

</html>