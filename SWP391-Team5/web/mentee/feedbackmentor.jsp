<%-- 
    Document   : feedbackmentor
    Created on : Jul 7, 2023, 3:47:22 PM
    Author     : Tuan Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <title>Form Reviews</title>
        <link rel="stylesheet" href="assets/css/feedback.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    </head>

    <body>
        <jsp:include page="../home/header.jsp"/>
        <div class="containerr">
            <div class="wrapper">
                <div
                    style="height: 50px; width: 500px; background-color: #175E4C; margin-bottom: 20px; color: white; border-radius: 6px;">
                    <h1>Feedback For Mentor</h1>
                </div>
                <div style="height: 2px; width: 520px; background-color: #175E4C; margin-bottom: 20px; border-radius: 6px;">
                </div>
                <h3>Please rate the skills you have learned</h3>
                <div class="row">
                    <div class="row">
                        <div class="col-6">
                            <h3>HTML</h3>
                        </div>
                        <div class="rating rt1 col-6" style="font-size: 1.5rem">
                            <input type="number" name="rating" hidden>
                            <i class='bx bxs-star star skill1 active' style="--i: 0;"></i>
                            <i class='bx bx-star star skill1' style="--i: 1;"></i>
                            <i class='bx bx-star star skill1' style="--i: 2;"></i>
                            <i class='bx bx-star star skill1' style="--i: 3;"></i>
                            <i class='bx bx-star star skill1' style="--i: 4;"></i>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <h3>C#</h3>
                        </div>
                        <div class="rating rt2 col-6" style="font-size: 1.5rem">
                            <input type="number" name="rating" hidden>
                            <i class='bx bxs-star skill2 active' style="--i: 0;"></i>
                            <i class='bx bx-star skill2' style="--i: 1;"></i>
                            <i class='bx bx-star skill2' style="--i: 2;"></i>
                            <i class='bx bx-star skill2' style="--i: 3;"></i>
                            <i class='bx bx-star skill2' style="--i: 4;"></i>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <h3>HTML</h3>
                        </div>
                        <div class="rating rt3 col-6" style="font-size: 1.5rem">
                            <input type="number" name="rating" hidden>
                            <i class='bx bxs-star skill3 active' style="--i: 0;"></i>
                            <i class='bx bx-star skill3' style="--i: 1;"></i>
                            <i class='bx bx-star skill3' style="--i: 2;"></i>
                            <i class='bx bx-star skill3' style="--i: 3;"></i>
                            <i class='bx bx-star skill3' style="--i: 4;"></i>
                        </div>
                    </div>

                </div>
                <div style="margin-top: 20px;">
                    <div
                        style="height: 2px; width: 520px; background-color: #175E4C; margin-bottom: 20px; border-radius: 6px;">
                    </div>
                    <h2>General assessment</h2>
                    <form action="#">
                        <div class="rating rtmain" style="font-size: 3rem;">
                            <input type="number" name="rating" hidden>
                            <i class='bx bxs-star  mainstar active' style="--i: 0;"></i>
                            <i class='bx bx-star  mainstar' style="--i: 1;"></i>
                            <i class='bx bx-star  mainstar' style="--i: 2;"></i>
                            <i class='bx bx-star  mainstar' style="--i: 3;"></i>
                            <i class='bx bx-star  mainstar' style="--i: 4;"></i>
                        </div>
                        <textarea name="opinion" style="outline: none;resize: none;" cols="30" rows="5"
                                  placeholder="Your opinion..."></textarea>
                        <div class="btn-group">
                            <button type="submit" class="btn submit">Submit</button>

                        </div>
                    </form>
                </div>

            </div>
        </div>
        <script src="assets/js/feedback.js"></script>
    </body>
    <jsp:include page="../home/footer.jsp"/>
</html>
