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
            margin-right: 40px;
            margin-bottom: 30px;
            border-radius: 5px;
            background-color: #f0f8ff;
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
            margin-left: 41%;
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
    <body onload="getPositionNavBar(8)">
        <div class="vw-100 vh-100 d-flex" >
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="3" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="card ">
                <div class="card-body">
                    <div class="container col-md-12">
                        <div class="row d-flex align-items-baseline">

                            <div class=" float-end">
                                <a class="btn btn-light text-capitalize border-0" data-mdb-ripple-color="dark"><i
                                        class="fas fa-print text-primary"></i> Print</a>
                                <a class="btn btn-light text-capitalize" data-mdb-ripple-color="dark"><i
                                        class="far fa-file-pdf text-danger"></i> Export</a>
                            </div>
                            <hr>
                        </div>
                        <form action="Bill" method="post">
                            <div class="container">
                                <div class="col-md-12">
                                    <div class="text-center">
                                        <h1>Bill</h1>
                                        <p class="pt-0">Bright eye Clinic</p>
                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        To : <input type="text" name="name" value="${fullname}" class="form-control"  >
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-12">
                                        Phone :<input type="text" name="phone" value="${phone}" class="form-control" >
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        Address : <input type="text" name="address" value="${address}"  class="form-control"  >
                                    </div>

                                    

                                </div>

                                <div class="row my-2 mx-1 justify-content-center">
                                    <table class="table table-striped table-borderless">
                                        <thead style="background-color:#84B0CA ;" class="text-white">
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col" style="width: 40%;height: 10px">Service</th>
                                                
                                                <th scope="col">Amount</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            
                                            <tr>
                                                <th scope="row">5</th>
                                                
                                                <td><textarea name="service" class="text" value="${requestScope.text}"></textarea></td>
                                                
                                                <td>$ <span class="total" ><input type="text" name="price" value="${requestScope.price} "></span></td>
                                            </tr>
                                        </tbody>

                                    </table>
                                </div>
                                
                                <hr>
                                <div class="row">
                                    <div class="col-xl-10">
                                        <p>Thank you for you medical examination at here</p>
                                    </div>
                                    <div class="col-xl-4 ">
                                        <button type="submit" class="btn btn-primary text-capitalize"
                                                style="background-color:#60bdf3 ;" onclick="return confirm('Would you like to continue step?')">Submit</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
</body>

</html>
