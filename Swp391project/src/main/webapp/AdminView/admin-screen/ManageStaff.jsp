<%-- 
    Document   : ManageStaff
    Created on : Feb 10, 2023, 8:18:34 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <!--<<link rel="stylesheet" href="MyCSS/check-box-button.css"/>-->
    <style>

        /*----------------User profile card--------------------------*/
        .staff-link a {
            color: #f96332;
        }
        .m-t-5{
            margin-top: 5px;
        }
        .card {
            background: #fff;
            margin-bottom: 30px;
            transition: .5s;
            border: 0;
            border-radius: .1875rem;
            display: inline-block;
            position: relative;
            width: 100%;
            box-shadow: none;
        }
        .card .body {
            font-size: 14px;
            color: #424242;
            padding: 20px;
            font-weight: 400;
        }
        .profile-page .profile-header {
            position: relative
        }

        .profile-page .profile-header .profile-image img {
            border-radius: 50%;
            width: 140px;
            border: 3px solid #fff;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23)
        }

        .profile-page .profile-header .social-icon a {
            margin: 0 5px
        }

        .profile-page .profile-sub-header {
            min-height: 60px;
            width: 100%
        }

        .profile-page .profile-sub-header ul.box-list {
            display: inline-table;
            table-layout: fixed;
            width: 100%;
            background: #eee
        }

        .profile-page .profile-sub-header ul.box-list li {
            border-right: 1px solid #e0e0e0;
            display: table-cell;
            list-style: none
        }

        .profile-page .profile-sub-header ul.box-list li:last-child {
            border-right: none
        }

        .profile-page .profile-sub-header ul.box-list li a {
            display: block;
            padding: 15px 0;
            color: #424242
        }

        .staff-info-card {
            /*            border: 1px solid red;*/
            /*width: 550px;*/
            height: 255px;
            margin-right: 100px;
            margin-bottom: 30px;
            border-radius: 5px;
            background-color: #5bc1ac;
        }

        .staff-info-card:hover{
            box-shadow: 0px 0px 7px 0px;
        }
        .staff-content-block {
            margin-left: 5%;
        }

        .profile-image {
            width: 140px;
            height: 140px;
            /*            margin-left: 20px;*/
            border: 3px solid #fff;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
            border-radius: 50%;
        }
        .profile-image img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }

        .staff-list {
            display: flex;
            flex-flow: row wrap;
        }

        .edit-profile {
            color: white !important;
        }

        .staff-main-content {
            width: 60%;
        }

        .staff-image-box {
            margin-right: 5%;
        }

        .staff-link-media a {
            margin: 10px;
        }

        .profile-header, .body {
            height: 233px;
            margin: 0;
            padding: 0;
            background: rgba(0,0,0,0);
        }

        /*------------Main------------------*/
        .main-view-content {
            background-color: white;
            margin: 0 !important;
            padding-left: 30px;
        }

        .staff-head-title {
            font-size: 2em;
        }

        #staff-head-title {
            height: 40px;
            line-height: 40px;
            margin-left: 40%;
            font-weight: bold;
        }

        #staff-head-title select {
            border: none;
            outline: none;
            line-height: 40px;
            height: 100%;
        }

        /*---------------Search-------------------------*/
        #search {
            margin-left: 59%;
            width: 300px;
            position: relative;
        }
        
        #search-text {
            width: 100%;
            height: 38px;
            position: absolute;
            border: 1px solid #5a6f80;
            border-radius: 5px;
            box-shadow: 1px 1px #cccccc;
        }
        
        #search-submit {
            position: absolute;
            width: 38px;
            height: 34px;
            border: none;
            /*margin-left: calc(100%-40px);*/
            left: 260px;
            top: 2px;
        }
        
    </style>
    <body onload="getPositionNavBar(1)">
        <form action="manageStaff" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="2" class="d-none">
            <!--            --------------------------------------------------------------------->

            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="mb-5 mx-3">
                    <div class="row mb-5">
                        <div class="m-auto d-flex" id="staff-head-title">
                            <p class="staff-head-title">MANAGE STAFF</p>
<!--                            <select class="mx-2 staff-head-title">
                                <option class="fw-bold" value="" selected="">STAFF</option>
                                <option class="fw-bold" value="">FORMER STAFF</option>
                                <option class="fw-bold" value="">ALL</option>
                            </select>-->
                        </div>
                    </div>
                    <div class="row align-items-center">
                        <div class="d-flex">
                            <a href="addUser?backPage=manageStaff&userRole=doctor" class="btn btn-success">ADD NEW</a>
                            <!--<a href="takeAttendance" class="btn btn-success mx-3">TAKE ATTENDANCE</a>-->
                        </div>
                        <div id="search" class="d-flex">
                            <input type="text" name="search" id="search-text" placeholder="Search by name">
                            <button id="search-submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                    </div>
                </div>
                <div class="flex-wrap staff-list">
                    <c:forEach items="${listUser}" var="s">
                        <div class="staff-info-card col-sm-5">
                            <div class="card profile-header">
                                <div class="body">
                                    <div class="row staff-content-block">
                                        <div class="col-lg-4 col-md-4 col-12 staff-image-box">
                                            <div class="profile-image float-md-right"> <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt=""> </div>
                                        </div>
                                        <div class="staff-main-content">
                                            <h4 class="m-t-0 m-b-0"><b>${s.getFullname()}</b></h4>
                                            <div class="d-flex text-center align-items-center"><i class="fa-solid fa-desktop"></i> <div class="mx-2 text-success">Online</div></div>
                                            <div class="job_post d-flex text-center align-items-center"><i class="fa-solid fa-user-nurse"></i> <div class="mx-2">${s.getRole()}</div></div>
                                            <div class="d-flex text-center align-items-center"><i class="fa-solid fa-phone"></i> <div class="mx-2">${s.getPhonenumber()}</div></div>
                                            <div class="staff-link mt-4">
                                                <a href="adminViewUserProfile?account=${s.getAccount()}&&backPage=manageStaff" class="btn btn-primary btn-round edit-profile">View profile</a>
                                                <div class="btn btn-primary btn-round btn-simple">Message</div>
                                                <a href="takeAttendance?staffAccount=${s.getAccount()}" class="btn btn-primary btn-round edit-profile mt-2">Take attendance</a>
                                            </div>
                                            <p class="social-icon m-t-5 m-b-0 staff-link-media">
                                                <a title="Twitter" href="javascript:void(0);"><i class="fa-brands fa-twitter"></i></a>
                                                <a title="Facebook" href="javascript:void(0);"><i class="fa-brands fa-facebook"></i></a>
                                                <a title="Google-plus" href="javascript:void(0);"><i class="fa-brands fa-instagram"></i></a>
                                                <a title="Behance" href="javascript:void(0);"><i class="fa-brands fa-telegram"></i></a>
                                                <!--                                                    <a title="Instagram" href="javascript:void(0);"><i class="fa fa-instagram "></i></a>-->
                                            </p>
                                        </div>                
                                    </div>
                                </div>                    
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
