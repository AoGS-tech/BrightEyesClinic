<%-- 
    Document   : AdminAddNewUser
    Created on : Feb 25, 2023, 9:02:30 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login V4</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
        <!--===============================================================================================-->


    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('assets/images/bgr.jpg');">
                <div class="wrap-login100 p-l-50 p-r-50 p-t-60 p-b-49">
                    <form class="login100-form validate-form" action="addUser" method="post">
                        <c:if test="${ms1 ne null}" >
                            <p  style="color: red;font-size: 20px">${ms1}</p>
                        </c:if>  
                        <span class="login100-form-title p-b-30">
                            NEW USER
                        </span>
                        <div class="wrap-input100 validate-input m-b-13" data-validate = "Username is reauired">
                            <span class="label-input100">Full Name</span>
                            <input class="input100" type="text" name="name" placeholder="Type user full name">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-13" data-validate = "Username is reauired">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="account" placeholder="Type user username">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-13" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="password" minlength="6" placeholder="Type user password">
                           
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-13" data-validate="Phone number is required">
                            <span class="label-input100">Phone number</span>
                            <input class="input100" type="number" name="phonenumber" maxlength="10" minlength="10"  placeholder="Type user Phone number">
                            <span class="focus-input100" data-symbol="&#xf204;"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-13" data-validate="Address is required">
                            <span class="label-input100">Address</span>
                            <input class="input100" type="text" name="address" placeholder="Type user Address">
                            <span class="focus-input100" data-symbol="&#xf215;"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-13" data-validate="Email is required">
                            <span class="label-input100">Email</span>
                            <input class="input100" type="text" name="email" placeholder="Type user Email">
                            <span class="focus-input100" data-symbol="&#xf195;"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-13" data-validate="Address is required">
                            <span class="label-input100">Role</span>
                            <input class="input100" type="text" name="role" placeholder="Type user Role" value="${userRole}" readonly="">
                            <span class="focus-input100" data-symbol="&#xf215;"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-13" >
                            <input type="radio" name="gender" value="Male" style="margin-left: 50px" checked> Male
                            <input type="radio" name="gender" value="FeMale" style="margin-left: 150px"> FeMale 
                        </div>
                        <div class="wrap-input100 validate-input m-b-13" data-validate="Phone user is required">
                            <span class="label-input100">Birth of Date</span>
                            <input class="input100" type="date" name="bod" placeholder="Type user Birth of Date">
                            <span class="focus-input100" data-symbol="&#xf160;"></span>
                        </div>


                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                
                                <input type="text" name="backPage" value="${backPage}" class="d-none">
                                <input type="submit" name="ADD" value="ADD" class="login100-form-btn" style="background-color: #5bc1ac" >
                            </div>
                        </div>                 
                        <div class="flex-col-c p-t-20">


<!--                            <a href="" class="txt2">
                                Comeback
                            </a>-->
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/bootstrap/js/popper.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="assets/js/main.js"></script>

    </body>
</html>