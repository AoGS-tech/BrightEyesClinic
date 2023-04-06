<%-- 
    Document   : admin-navbar
    Created on : Feb 10, 2023, 8:12:56 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="../admin-assets/css/bootstrap.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">

        <style>
            .admin-nav {
                width: 260px;
                /*border: 1px solid red;*/
                background-color: #5a6f80;
            }

            .admin-link {
                line-height: 50px;
            }

            .admin-link label {
                color: white;
                font-size: large;
            }
            .admin-link i {
                width: 40px;
                text-align: center;
            }

            .admin-link:hover {
                background-color: #5bc1ac;
                color: #5a6f80;
            }

            .admin-nav-title {
                color: white;
                font-size: x-large;
            }
            
            .admin-info {
                color: white;
            }
            
            .admin-info:hover {
                color: #5bc1ac;
            }
            
            .btn-logout {
                width: 70%;
                margin-left: 15%;
                height: 40px;
                background-color: white;
                color: #5a6f80;
            }
            
            .admin-link a{
                text-decoration: none;
                color: white;
            }
            .admin-link a:active {
                background-color: #5bc1ac;
                color: #5a6f80;
            }
        </style>
        <script>
            function getPositionNavBar(x) {
                const labels = document.getElementsByClassName('admin-nav-label');
                console.log('Total labels: ' + labels.length);
                labels[x].style.backgroundColor = "white";
                labels[x].style.color = "#5a6f80";
            }
        </script>
    </head>
    <body>
        <div class="admin-nav vh-100">
            <a href="profile" class="text-center text-decoration-none admin-info">
                <div class="fs-2"><i class="fa-solid fa-user"></i></div>
                <div>${username}</div>
            </a>

            <br>
            <div>
                <div class=" fw-bold admin-nav-title mx-1">MANAGEMENT</div>
                <div>
                    <div class="admin-link">
                        <a href="adminDashboard" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-layer-group"></i>
                            <div class="mx-2">Dashboard</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="manageStaff" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-user-nurse"></i>
                            <div class="mx-2">Staff</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="manageCustomer" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-user-plus"></i>
                            <div class="mx-2">Customer</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="manageRoom" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-house-medical"></i>
                            <div class="mx-2">Room</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="manageGlasses" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-glasses"></i>
                            <div class="mx-2">Glass</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="feedback" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-face-smile"></i>
                            <div class="mx-2">Feedback</div>
                        </a>
                    </div>
                    
                    <div class="admin-link">
                        <a href="searchBooking" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-calendar-days"></i>
                            <div class="mx-2">Booking</div>
                        </a>
                    </div>
                    
                    <div class="admin-link">
                        <a href="OrderMannagerContronler" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-calendar-days"></i>
                            <div class="mx-2">List Order</div>
                        </a>
                    </div>
                    <div class="admin-link">
                        <a href="Bill" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-calendar-days"></i>
                            <div class="mx-2">Extract Bill</div>
                        </a>
                    </div>
                </div>

            </div>
            <br>
            <br>
            <a href="logout" class="btn btn-logout text-decoration-none">Logout</a>
        </div>

    </body>
</html>
