<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : home
    Created on : Jun 11, 2023, 1:00:46 PM
    Author     : lamNB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="temp/logo2.png">
        <link rel="stylesheet" href="assets/popup.css"/>
        <title>MentorLink</title>   
    </head>

    <body>
        <jsp:include page="../home/header.jsp"/>
        <div id="wrapper"> <!--header-->      
            <!--end header-->
            <section class="slider">
                <video width="100%" height="auto" autoplay="autoplay" loop="" muted="" poster="temp/cover.jpg">
                    <source src="temp/background.mp4" type="video/mp4">
                </video>

                <div class="slider_content">
                    <div class="row">
                        <div class="col-md-6 col-sm-12">
                            <h1 style="color: #fff;">MentorLink - Nền tảng Kết nối Cố vấn và Học cùng Chuyên gia</h1>
                            <p style="color: #fff; font-size: 18px;">Với sứ mệnh là nâng cao chất lượng nguồn nhân lực, giúp
                                thanh niên Việt Nam định vị nghề nghiệp và tạo cơ hội phát triển</p>
                            <p>Các dịch vụ đến từ Vietnam:</p>
                            <div class="row">
                                <div>
                                    <button class="btn btn-info btn_search pt-2 pb-2 btn-section">Tìm kiếm Chuyên
                                        gia</button>
                                    <button class="pt-2 pb-2 btn btn-info btn_search ml-4 btn-section2">Nền
                                        tảng Mentoring</button>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12">
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <section id="content" style="margin-bottom: 0px;">
            <div class="content-wrap nopadding">
                <section class="container-md">
                    <div class="mobile-none">
                        <img src="temp/3stepmentoring.jpeg" class="w-100">
                    </div>
                    <div class="desktop-none">
                        <img src="temp/3stepmobile.jpeg" class="w-100">
                    </div>
                </section>
                <div class="mentor_team mt-5 pt-5">
                    <div class="container-md">
                        <div class="">
                            <h2 class="text-uppercase text-center main-color bolder-weight">Cố vấn nổi bật</h2>
                        </div>
                        <div class="row">
                            <c:forEach var="p" items="${listT}">

                                <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 mb-3 mt-3">
                                    <div class="mentor_item mentor_item_custom wow fadeInUp">
                                        <a href="ViewCvMentor?mentor_id=${p.mentor_id}">
                                            <div class="mentor_avatar">
                                                <img src="${p.getInfor().getAvatar()}" alt="${p.getInfor().getFull_name()}">
                                            </div>
                                            <div class="mentor_info">
                                                <div style="min-height: 100px;">
                                                    <div class="name">${p.getInfor().getFull_name()} </div>
                                                    <div class="">
                                                        <span class="jobs">
                                                            ${p.profession} <span
                                                                class="field"></span> </span>
                                                    </div>
                                                </div>
                                                <div class="row mt-1">
                                                    <div class="user-rate col-6">
                                                        <div class="wrap-star">
                                                            <img src="temp/ic-mentee.png"
                                                                 style="width: auto; height: 18px; margin-bottom: 2px;"
                                                                 data-toggle="tooltip" data-placement="bottom" title=""
                                                                 data-original-title="Số Mentee"> <span class="wrap-number">
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="user-favorite col-6">
                                                        <div class="wrap-star">
                                                            <!--                                                    <img src="temp/followed.png"
                                                                                                                    style="width: auto; height: 18px; margin-bottom: 2px;"
                                                                                                                    data-toggle="tooltip" data-placement="bottom" title=""
                                                                                                                    data-original-title="Số người Theo dõi">-->
                                                            <span class="wrap-number" style="padding-bottom: 2px;"></span>
                                                        </div>
                                                        <div></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                        <div class="mentor_item_info_box1">
                                            <a href="#" class="mentor_item_info_box_ref"
                                               title="${p.getInfor().getFull_name()}">
                                                <div class="span_title"><span>Giới thiệu bản thân</span>
                                                </div>
                                                <div class="line"></div>
                                                <p>${p.profession_introduction}</p>
                                                <span class="span_title">Chủ đề MentorLink</span>
                                                <div class="line"></div>
                                                <p><i class="fa fa-circle" style="font-size: 11px !important;"
                                                      aria-hidden="true"></i>
                                                    <strong>Service description: </strong>${p.service_description}
                                                </p>
                                                <p><i class="fa fa-circle" style="font-size: 11px !important;"
                                                      aria-hidden="true"></i>
                                                    <strong>Achievements: </strong>${p.achievements}
                                                </p>
                                                <div class="line line2"></div>
                                                <div class="text-center">
                                                    <span class="mentor_detail_link notopmargin mb-1">Xem chi tiết</span>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>    


                        </div>
                        <div class="home_title mentor_team_title text-center mt-3">
                            <a href="viewListMentor">
                                <button class="btn btn-info btn_search">Xem thêm</button>
                            </a>
                        </div>
                    </div>
                </div>


                <section class="pb-5 pt-5" style="background-color: #eee;">
                    <div class="container">
                        <div>
                            <div>
                                <h4 class="primary-color mb-2">Các ngôn ngữ cơ bản phổ biến nhất</h4>

                            </div>
                            <div class="row">
                                <c:forEach var="s" items="${listS}">

                                    <div class="col-md-4 col-sm-12 mb-4">
                                        <div class="p-3"
                                             style="background-color: #fff; border-radius: 20px; min-height: 370px;">
                                            <a href="#" target="_blank">
                                                <img src="${s.skill_img}" class="w-100 image_fade">
                                                <div class="row" style="padding-left: 8px; ">

                                                </div>
                                                <h4 class="t600 mb-3 mt-3">${s.skill_name}</h4>
                                                <p class="mb-3 course-desciption" style="color: #949BA1">Đặc biệt dành cho những
                                                    người mới bắt đầu có đam mê về lập trình.</p>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>



                            </div>
                        </div>
                        <!-- specification courses-->
                    </div>
                </section>
            </div>
        </section>
        <!--    <section class="pt-5 pb-5">
                <div class="container-md">
                    <div class="row text-center">
                        <h2 class="main-color bolder-weight mb-0 center" style="margin: auto;">Cách học nhanh và bền vững nhất
                            chính là học hỏi từ chính những người đi trước</h2>
                    </div>
                    <div class="row mt-5">
                        <div class="col-sm-12 col-md-4">
                            <div class="box-number p-4 mt-3" style="background-color: #034D37; border-radius: 10px;">
                                <h3 class="text-white center bolder-weight">90.000+</h3>
                                <p class="text-white">Cộng đồng Vietnam Mentoring Network hiện tại trung bình hơn 90.000 thành
                                    viên, tăng trưởng trung bình hơn 10.000 thành viên/tháng</p>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-4">
                            <div class="box-number p-4 mt-3" style="background-color: #034D37; border-radius: 10px;">
                                <h3 class="text-white center bolder-weight">90.000+</h3>
                                <p class="text-white">Cộng đồng Vietnam Mentoring Network hiện tại trung bình hơn 90.000 thành
                                    viên, tăng trưởng trung bình hơn 10.000 thành viên/tháng</p>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-4">
                            <div class="box-number p-4 mt-3" style="background-color: #034D37; border-radius: 10px;">
                                <h3 class="text-white center bolder-weight">90.000+</h3>
                                <p class="text-white">Cộng đồng Vietnam Mentoring Network hiện tại trung bình hơn 90.000 thành
                                    viên, tăng trưởng trung bình hơn 10.000 thành viên/tháng</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>-->
        <!-- post body -->
        <!--    <section class="pt-5 pb-5" style="background-color: #fff;">
                <div class="posts_body">
                    <div class="container-md">
                        <div>
                            <h2 class="text-center main-color bolder-weight">Bài viết chia sẻ từ các chuyên gia</h2>
                        </div>
                        <div class="row mt-2" style="margin-right: 0px; margin-left: 0px;">
                            <div id="box-content-list-posts">
                                <div style="border-top: 0.3px solid #E9E9E9;"></div>
                                <div class="post_item col_full pt-4 mb-4">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12">
                                            <div class="entry-image post_item_img vertical-middle">
                                                <a href="#" target="_blank">
                                                    <img class="image_fade" src="temp/mje1614241540.jpg"
                                                        alt="TỔNG QUAN VỀ NGÀNH TÀI CHÍNH (FUNCTION AND INDUSTRY)">
                                                </a>
                                            </div>
                                        </div>
                                        <div class="col-md-7 col-sm-12">
                                            <div class="post_item_text">
                                                <div class="">
                                                    <a href="#" class="post_title t600" target="_blank">TỔNG QUAN VỀ NGÀNH TÀI
                                                        CHÍNH
                                                        (FUNCTION AND INDUSTRY)</a>
        
                                                    <div class="item-reviews pl-3">
                                                        <a href="#" class="name_re">
                                                            <div class="d-flex avt-box-post"
                                                                style="margin-right: 0px; margin-left: 0px;">
                                                                <img src="temp/gxn1610077596.jpg" alt="Avatar Image"
                                                                    class="img-circle avatar_header" width="50" height="50">
                                                                <div class="post_avt_des">
                                                                    <p class="mb-1" style="font-size: 16px;">Nguyễn Quý
                                                                        Tiến<span class="mb-1 ml-3"><i aria-hidden="true"
                                                                                class="fa fa-pencil-square-o mr-1"></i>25-02-2021
                                                                        </span></p>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <a href="#" class="post_teaser" style="-webkit-line-clamp: unset;"
                                                        target="_blank">Rất nhiều sinh viên không phân biệt được Chức Năng Tài
                                                        Chính (Finance Function) và Ngành Tài Chính (Finance Industry). Mình sẽ
                                                        làm rõ vấn đề đó trong bài viết này.</a>
                                                    <div class="row mt-1">
                                                        <div class="col-2">
                                                            <i class="fa fa-eye fa-lg"></i>
                                                            3919
                                                        </div>
                                                        <div class="col-2">
                                                            <i class="fa-regular fa-comment-dots"></i>
                                                            0
                                                        </div>
                                                        <div class="col-2" id="button-vote-63">
                                                            <a class="share share-facebook btn-pointer" href="/login">
                                                                <i class="fa-regular fa-heart"></i><span class="ml-1"
                                                                    style="margin-left: 5px;" id="vote-score-63">19</span>
                                                            </a>
                                                        </div>
                                                        <div class="col-3" id="button-save-63">
                                                            <a class="share share-facebook btn-pointer" href="/login">
                                                                <i class="fa-sharp fa-regular fa-bookmark"></i><span
                                                                    style="margin-left: 5px;">Lưu</span>
                                                            </a>
                                                        </div>
                                                        <div class="col-3">
                                                            <a class="share share-facebook" href="#">
                                                                <i class="fa-solid fa-share"></i><span
                                                                    style="font-size: 16px; margin-left: 5px;">Chia
                                                                    sẻ</span></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-2" style="margin-right: 0px; margin-left: 0px;">
                            <div id="box-content-list-posts">
                                <div style="border-top: 0.3px solid #E9E9E9;"></div>
                                <div class="post_item col_full pt-4 mb-4">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12">
                                            <div class="entry-image post_item_img vertical-middle">
                                                <a href="#" target="_blank">
                                                    <img class="image_fade" src="temp/mje1614241540.jpg"
                                                        alt="TỔNG QUAN VỀ NGÀNH TÀI CHÍNH (FUNCTION AND INDUSTRY)">
                                                </a>
                                            </div>
                                        </div>
                                        <div class="col-md-7 col-sm-12">
                                            <div class="post_item_text">
                                                <div class="">
                                                    <a href="#" class="post_title t600" target="_blank">TỔNG QUAN VỀ NGÀNH TÀI
                                                        CHÍNH
                                                        (FUNCTION AND INDUSTRY)</a>
        
                                                    <div class="item-reviews pl-3">
                                                        <a href="#" class="name_re">
                                                            <div class="d-flex avt-box-post"
                                                                style="margin-right: 0px; margin-left: 0px;">
                                                                <img src="temp/gxn1610077596.jpg" alt="Avatar Image"
                                                                    class="img-circle avatar_header" width="50" height="50">
                                                                <div class="post_avt_des">
                                                                    <p class="mb-1" style="font-size: 16px;">Nguyễn Quý
                                                                        Tiến<span class="mb-1 ml-3"><i aria-hidden="true"
                                                                                class="fa fa-pencil-square-o mr-1"></i>25-02-2021
                                                                        </span></p>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <a href="#" class="post_teaser" style="-webkit-line-clamp: unset;"
                                                        target="_blank">Rất nhiều sinh viên không phân biệt được Chức Năng Tài
                                                        Chính (Finance Function) và Ngành Tài Chính (Finance Industry). Mình sẽ
                                                        làm rõ vấn đề đó trong bài viết này.</a>
                                                    <div class="row mt-1">
                                                        <div class="col-2">
                                                            <i class="fa fa-eye fa-lg"></i>
                                                            3919
                                                        </div>
                                                        <div class="col-2">
                                                            <i class="fa-regular fa-comment-dots"></i>
                                                            0
                                                        </div>
                                                        <div class="col-2" id="button-vote-63">
                                                            <a class="share share-facebook btn-pointer" href="/login">
                                                                <i class="fa-regular fa-heart"></i><span class="ml-1"
                                                                    style="margin-left: 5px;" id="vote-score-63">19</span>
                                                            </a>
                                                        </div>
                                                        <div class="col-3" id="button-save-63">
                                                            <a class="share share-facebook btn-pointer" href="/login">
                                                                <i class="fa-sharp fa-regular fa-bookmark"></i><span
                                                                    style="margin-left: 5px;">Lưu</span>
                                                            </a>
                                                        </div>
                                                        <div class="col-3">
                                                            <a class="share share-facebook" href="#">
                                                                <i class="fa-solid fa-share"></i><span
                                                                    style="font-size: 16px; margin-left: 5px;">Chia
                                                                    sẻ</span></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-2" style="margin-right: 0px; margin-left: 0px;">
                            <div id="box-content-list-posts">
                                <div style="border-top: 0.3px solid #E9E9E9;"></div>
                                <div class="post_item col_full pt-4 mb-4">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12">
                                            <div class="entry-image post_item_img vertical-middle">
                                                <a href="#" target="_blank">
                                                    <img class="image_fade" src="temp/mje1614241540.jpg"
                                                        alt="TỔNG QUAN VỀ NGÀNH TÀI CHÍNH (FUNCTION AND INDUSTRY)">
                                                </a>
                                            </div>
                                        </div>
                                        <div class="col-md-7 col-sm-12">
                                            <div class="post_item_text">
                                                <div class="">
                                                    <a href="#" class="post_title t600" target="_blank">TỔNG QUAN VỀ NGÀNH TÀI
                                                        CHÍNH
                                                        (FUNCTION AND INDUSTRY)</a>
        
                                                    <div class="item-reviews pl-3">
                                                        <a href="#" class="name_re">
                                                            <div class="d-flex avt-box-post"
                                                                style="margin-right: 0px; margin-left: 0px;">
                                                                <img src="temp/gxn1610077596.jpg" alt="Avatar Image"
                                                                    class="img-circle avatar_header" width="50" height="50">
                                                                <div class="post_avt_des">
                                                                    <p class="mb-1" style="font-size: 16px;">Nguyễn Quý
                                                                        Tiến<span class="mb-1 ml-3"><i aria-hidden="true"
                                                                                class="fa fa-pencil-square-o mr-1"></i>25-02-2021
                                                                        </span></p>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <a href="#" class="post_teaser" style="-webkit-line-clamp: unset;"
                                                        target="_blank">Rất nhiều sinh viên không phân biệt được Chức Năng Tài
                                                        Chính (Finance Function) và Ngành Tài Chính (Finance Industry). Mình sẽ
                                                        làm rõ vấn đề đó trong bài viết này.</a>
                                                    <div class="row mt-1">
                                                        <div class="col-2">
                                                            <i class="fa fa-eye fa-lg"></i>
                                                            3919
                                                        </div>
                                                        <div class="col-2">
                                                            <i class="fa-regular fa-comment-dots"></i>
                                                            0
                                                        </div>
                                                        <div class="col-2" id="button-vote-63">
                                                            <a class="share share-facebook btn-pointer" href="/login">
                                                                <i class="fa-regular fa-heart"></i><span class="ml-1"
                                                                    style="margin-left: 5px;" id="vote-score-63">19</span>
                                                            </a>
                                                        </div>
                                                        <div class="col-3" id="button-save-63">
                                                            <a class="share share-facebook btn-pointer" href="/login">
                                                                <i class="fa-sharp fa-regular fa-bookmark"></i><span
                                                                    style="margin-left: 5px;">Lưu</span>
                                                            </a>
                                                        </div>
                                                        <div class="col-3">
                                                            <a class="share share-facebook" href="#">
                                                                <i class="fa-solid fa-share"></i><span
                                                                    style="font-size: 16px; margin-left: 5px;">Chia
                                                                    sẻ</span></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div style="border-top: 0.3px solid #E9E9E9;"></div>
                            </div>
                        </div>
        
                        <div class="home_title mentor_team_title text-center mt-5">
                            <button class="btn btn-info btn_search">Xem thêm</button>
                        </div>
                    </div>
                </div>
            </section>-->
        <!-- footer -->
        <div id="popup-btn-rq-statistic" class="popup-btn-rq-statistic">
            <div class="check-modal">
                a
            </div>
            <button data-close-button>Aaaaaaaaaaaaaaaaaaaaaaaaaaa</button>
        </div>
        <div id="overlay"></div>
        <jsp:include page="../home/footer.jsp"/>
    </body>
    <script src="temp/home.js"></script>
    <script src="assets/js/popup.js"></script>

</html>
