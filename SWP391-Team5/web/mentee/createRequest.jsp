<%-- 
    Document   : createRequest
    Created on : Jun 12, 2023, 9:08:48 PM
    Author     : Tuan Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!---Coding By CodingLab | www.codinglabweb.com--->
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />

        <link rel="stylesheet" href="assets/css/request.css" />
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">
    </head>

    <body>
        <jsp:include page="../home/header.jsp"/>
        <div class="body_temp">
            <section class="container1">    
                <div class="header_title">
                    <div class="header_tmp">
                        <header>Create Request</header>  
                    </div>
                </div>
                <form action="#" class="formm">
                    <div class="input-boxx">
                        <label>Title</label>
                        <input type="text" placeholder="Enter the title" required />
                    </div>

                    <div class="columnn">
                        <div class="input-boxx">
                            <label>Start Time</label>
                            <input type="date" placeholder="Enter start time" required />
                        </div>
                        <div class="input-boxx">
                            <label>End Time</label>
                            <input type="date" placeholder="Enter end time" required />
                        </div>
                    </div>

                    <div class="gender-boxx">
                        <label style="font-size: 15px; font-weight: bold;">Skill</label>
                        <div class="gender-option ">
                            <select name="skills" id="skills">
                                <option value="1">C#</option>
                                <option value="2">Java</option>
                                <option value="3">Python</option>
                                <option value="4">Ruby</option>
                                <option value="5">C++</option>
                                <option value="6">HMLT</option>
                                <option value="7">CSS</option>
                                <option value="8">JavaScript</option>
                                <option value="9">NodeJs</option>
                                <option value="10">Angular</option>
                            </select>
                        </div>
                    </div>

                    <div class="input-boxx">
                        <label>Duration of the request</label>
                        <div class="select-boxx">
                            <select>
                                <option hidden>Choose time</option>
                                <option>1h</option>
                                <option>2h</option>
                                <option>3h</option>
                                <option>4h</option>
                                <option>5h</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-boxx ">
                        <label>Framework</label>
                        <textarea placeholder="Framework you want to be trained"></textarea>
                    </div>

                    <div class="input-boxx">
                        <label>Content</label><br>
                        <textarea placeholder="Content required"></textarea>
                    </div>


                    <button style="border: 30px; background: #175E4C">Request</button>
                </form>
            </section>
        </div>
        <script src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/js/multi-select-tag.js"></script>
        <script>
            new MultiSelectTag('skills')
        </script>

    </body>
    <jsp:include page="../home/footer.jsp"/>
</html>