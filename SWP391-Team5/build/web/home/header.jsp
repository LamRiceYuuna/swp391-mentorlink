<%-- 
    Document   : header
    Created on : Jun 11, 2023, 12:57:11 PM
    Author     : Tuan Vinh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="temp/home.css">
    </head>

    <body> 
        
        <header id="header" class="sticky-header">
            <div id="header-wrap">
                <div class="container-md header">
                    <div id="primary-menu-trigger" class="align-middle" style="opacity: 1; pointer-events: unset;"><!--mobile icon-->
                        <a href="home" class="standard-logo"><img src="temp/logo.png" alt="logo" class="main_logo"></a>
                        <span class="standard-logo mobile-icon"><i class="fa-solid fa-bars"></i></span>
                    </div>
                    <div id="logo">
                        <a href="#" class="standard-logo"><img src="temp/logo.png" alt="logo" class="main_logo"></a>
                    </div>
                    <div class="dt-menu-mega d-flex ">
                        <ul id="mobile-menu" class="dt-menu-mega d-flex justify-content-between mobile-menu-none"
                            hide="true">
                            <li class="sub-menu dropdown_list">
                                <a href="http://localhost:9999/SWP391-Team5/viewSkill" target="_blank">
                                    List skill
                                </a>

                            </li>
                            <li class="sub-menu">
                                <a href="viewListMentor">
                                    <div>Tìm kiếm Mentor</div>
                                </a>
                            </li>
                            <li class="sub-menu dropdown_list">
                                <a href="#">
                                    <div>Đối tác</div>
                                </a>
                                <ul id="mega2" class="mega_menu_box" style="display: none;"> <!--dropdown-menu-->
                                    <li>
                                        <a href="#" class="mega_menu_box_content" target="_blank">
                                            <div style="">Rikkei Mentoring</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="mega_menu_box_content" target="_blank">
                                            <div style="text-transform: initial;">fMENTORING</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="mega_menu_box_content" target="_blank">
                                            <div>VNU-IS Mentoring</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="mega_menu_box_content" target="_blank">
                                            <div>Dynagen Mentoring</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="mega_menu_box_content" target="_blank">
                                            <div>Mentori</div>
                                        </a>
                                    </li>
                                </ul>
                            </li>

                            <c:if test="${sessionScope.acc == null}">  

                                <li class="login-box">
                                    <a href="login" class="btn-info btn">Đăng nhập</a>
                                </li>
                                <li class="login-box">
                                    <a href="http://localhost:9999/SWP391-Team5/signupController" class="btn-info btn">Đăng ký</a>
                                </li>
                            </c:if>
                        </ul>

                        <!--Mentor / Mentee / Admin-->
                        <c:if test="${sessionScope.acc != null}"> 
                            <!--Mentee -->
                            <c:if test="${sessionScope.acc.role == 1}"> 
                                <div id="top-user">
                                    <div class="div" id="user-avatar">
                                        <img alt="" class="img-circle avatar_header"
                                             style="width: 36px; height: 36px; -o-object-fit: cover; object-fit: cover;-o-object-position: center; object-position: center;"
                                             src="https://mentori.vn/upload/images/57fe6df2f2dabd4566022d17622f7e05.jpg">
                                        <i class="fa fa-angle-down fa-lg" aria-hidden="true" style="color:#fff;"></i>
                                    </div>
                                    <ul class="select_user_box" id="select_user_box" style=" display: none; ">
                                        <li class="dt-menu-item-parent pt-2 pb-2">
                                            <div class="div">
                                                <div class="" style="display: flex">
                                                    <div class="pr-2" style="width: 54px;">
                                                        <a href="/user/523868402" class="" title="Duy Dao">
                                                            <img alt="" class="img-circle avatar_header"
                                                                 style="width: 36px; height: 36px; -o-object-fit: cover; object-fit: cover;-o-object-position: center; object-position: center;"
                                                                 src="https://mentori.vn/upload/images/57fe6df2f2dabd4566022d17622f7e05.jpg">
                                                        </a>
                                                    </div>
                                                    <div class="pl-0" style="width: 100%;">
                                                        <div>
                                                            <a href="#" class="" style="font-size: 14px;" title="Duy Dao">
                                                                Mentee: ${sessionScope.acc.username} </a>
                                                        </div>
                                                        <div>
                                                            <a href="http://localhost:9999/SWP391-Team5/UserProfile" class="" style="font-size: 12px;" title="Duy Dao">
                                                                Xem hồ sơ của bạn
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li role="separator" class="divider"></li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-leaf"></i>Đăng ký làm Mentor
                                            </a>
                                        </li>
                                        <li role="separator" class="divider"></li>


                                        <li><a class="pb-0">Cá nhân</a></li>
                                        <li class="dt-menu-item-parent"></li>
                                        <li>
                                            <a href="#" class="pb-0" style="cursor: pointer;">
                                                <i class="fa fa-tag"></i>requestMentor
                                            </a>
                                        </li>
                                        <li>
                                            <a href="listRequestMenTee" class="pb-0" style="cursor: pointer;">
                                                <i class="fa fa-shopping-cart"></i>list Request MenTee
                                            </a>
                                        </li>
                                        <li>
                                            <a data-toggle="modal" data-target="#add-interest-field" class="pb-0"
                                               style="cursor: pointer;">
                                                <i class="fa-solid fa-lightbulb"></i>Lĩnh vực quan tâm
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="pb-0">
                                                <i class="fa-solid fa-user"></i></i>Thông tin cá nhân </a>
                                        </li>
                                        <li>
                                            <a href="#" class="">
                                                <i class="fa fa-key"></i>Đổi mật khẩu
                                            </a>
                                        </li>

                                        <li role="separator" class="divider"></li>

                                        <li>
                                            <a href="#" target="_blank" class="pb-0">
                                                <i class="fa fa-question-circle"></i>Trợ giúp và Hỗ trợ
                                            </a>
                                        </li>

                                        <li>
                                            <a href="http://localhost:9999/SWP391-Team5/logout">
                                                <i class="fa fa-sign-out" style=" -ms-transform: rotate(180deg); /* IE 9 */
                                                   -webkit-transform: rotate(180deg); /* Chrome, Safari, Opera */
                                                   transform: rotate(180deg);"></i>Đăng xuất </a>
                                        </li>
                                    </ul>
                                </div>
                            </c:if>
                            <!-- Mentor -->
                            <c:if test="${sessionScope.acc.role == 2}"> 
                                <div id="top-user">
                                    <div class="div" id="user-avatar">
                                        <img alt="" class="img-circle avatar_header"
                                             style="width: 36px; height: 36px; -o-object-fit: cover; object-fit: cover;-o-object-position: center; object-position: center;"
                                             src="https://mentori.vn/upload/images/57fe6df2f2dabd4566022d17622f7e05.jpg">
                                        <i class="fa fa-angle-down fa-lg" aria-hidden="true" style="color:#fff;"></i>
                                    </div>
                                    <ul class="select_user_box" id="select_user_box" style=" display: none; ">
                                        <li class="dt-menu-item-parent pt-2 pb-2">
                                            <div class="div">
                                                <div class="" style="display: flex">
                                                    <div class="pr-2" style="width: 54px;">
                                                        <a href="/user/523868402" class="" title="Duy Dao">
                                                            <img alt="" class="img-circle avatar_header"
                                                                 style="width: 36px; height: 36px; -o-object-fit: cover; object-fit: cover;-o-object-position: center; object-position: center;"
                                                                 src="https://mentori.vn/upload/images/57fe6df2f2dabd4566022d17622f7e05.jpg">
                                                        </a>
                                                    </div>
                                                    <div class="pl-0" style="width: 100%;">
                                                        <div>
                                                            <a href="#" class="" style="font-size: 14px;" title="Duy Dao">
                                                                Mentor:   ${sessionScope.acc.username} </a>
                                                        </div>
                                                        <div>
                                                            <a href="http://localhost:9999/SWP391-Team5/UserProfile" class="" style="font-size: 12px;" title="Duy Dao">
                                                                Xem hồ sơ của bạn
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li role="separator" class="divider"></li>
                                        <li>
                                            <a href="http://localhost:9999/SWP391-Team5/CreateCV">
                                                <i class="fa fa-leaf"></i>Tạo CV Cho Mentor
                                            </a>
                                        </li>
                                        <li role="separator" class="divider"></li>


                                        <li><a class="pb-0">Cá nhân</a></li>
                                        <li class="dt-menu-item-parent"></li>
                                        <li>
                                            <a href="#" class="pb-0">
                                                <i class="fa-solid fa-user"></i></i>Thông tin cá nhân </a>
                                        </li>
                                        <li>
                                            <a href="#" class="">
                                                <i class="fa fa-key"></i>Đổi mật khẩu
                                            </a>
                                        </li>

                                        <li role="separator" class="divider"></li>
                                        <li>
                                            <a href="#" target="_blank" class="pb-0">
                                                <i class="fa fa-question-circle"></i>Trợ giúp và Hỗ trợ
                                            </a>
                                        </li>

                                        <li>
                                            <a href="http://localhost:9999/SWP391-Team5/logout">
                                                <i class="fa fa-sign-out" style=" -ms-transform: rotate(180deg); /* IE 9 */
                                                   -webkit-transform: rotate(180deg); /* Chrome, Safari, Opera */
                                                   transform: rotate(180deg);"></i>Đăng xuất </a>
                                        </li>
                                    </ul>
                                </div>
                            </c:if>
                            <!-- Admin -->
                            <c:if test="${sessionScope.acc.role == 3}"> 

                                <div id="top-user">
                                    <div class="div" id="user-avatar">
                                        <img alt="" class="img-circle avatar_header"
                                             style="width: 36px; height: 36px; -o-object-fit: cover; object-fit: cover;-o-object-position: center; object-position: center;"
                                             src="https://mentori.vn/upload/images/57fe6df2f2dabd4566022d17622f7e05.jpg">
                                        <i class="fa fa-angle-down fa-lg" aria-hidden="true" style="color:#fff;"></i>
                                    </div>
                                    <ul class="select_user_box" id="select_user_box" style=" display: none; ">
                                        <li class="dt-menu-item-parent pt-2 pb-2">
                                            <div class="div">
                                                <div class="" style="display: flex">
                                                    <div class="pr-2" style="width: 54px;">
                                                        <a href="/user/523868402" class="" title="Duy Dao">
                                                            <img alt="" class="img-circle avatar_header"
                                                                 style="width: 36px; height: 36px; -o-object-fit: cover; object-fit: cover;-o-object-position: center; object-position: center;"
                                                                 src="https://mentori.vn/upload/images/57fe6df2f2dabd4566022d17622f7e05.jpg">
                                                        </a>
                                                    </div>
                                                    <div class="pl-0" style="width: 100%;">
                                                        <div>
                                                            <a href="#" class="" style="font-size: 14px;" title="Duy Dao">
                                                                Admin: ${sessionScope.acc.username} </a>
                                                        </div>
                                                        <div>
                                                            <a href="#" class="" style="font-size: 12px;" title="Duy Dao">
                                                                Xem hồ sơ của bạn
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li role="separator" class="divider"></li>
                                        <li>
                                            <a href="http://localhost:9999/SWP391-Team5/dashboard">
                                                <i class="fa fa-leaf"></i>DashBoard
                                            </a>
                                        </li>


                                        <li role="separator" class="divider"></li>

                                        <li>
                                            <a href="http://localhost:9999/SWP391-Team5/logout">
                                                <i class="fa fa-sign-out" style=" -ms-transform: rotate(180deg); /* IE 9 */
                                                   -webkit-transform: rotate(180deg); /* Chrome, Safari, Opera */
                                                   transform: rotate(180deg);"></i>Đăng xuất </a>
                                        </li>
                                    </ul>
                                </div>
                            </c:if>

                        </c:if>
                        <!-- icon after login-->
                        <!--top cart-->
                        <!--                        <div id="top-cart">
                                                    <i class="fa-solid fa-calendar-days"><a href="#"></a></i>
                                                </div>
                                                top message
                                                <div id="top-messenger">
                                                    <i class="fa-brands fa-facebook-messenger"><a href="#"></a></i>
                                                </div>
                                                 notify
                                                <div id="top-notify">
                                                    <i class="fa-solid fa-earth-asia"><a href="#"></a></i>
                        
                                                </div>
                                                 favorite
                                                <div id="top-favorite" class="sub-menu">
                                                    <i class="fa-solid fa-heart"><a href="#"></a></i>
                                                </div>-->


                    </div>

                </div>
            </div>
        </header>

    </body>
    <script src="temp/home.js"></script>

</html>

