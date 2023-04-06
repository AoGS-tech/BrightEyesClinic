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
                margin-top: 50px;
            }
        </style>       
    </head>
    <body>
        <div class="admin-nav vh-100">
            <br><br><br>
            <a href="#" class="text-center text-decoration-none admin-info">
                <div class="fs-2"><i class="fa-solid fa-user"></i></div>
                <div style="font-size: 30px">${fullname}</div>

            </a>
            <div style="font-size: 20px;text-align: center" >${now}</div>

            <br>
            <div>
                <br><br>
                <div class=" fw-bold admin-nav-title mx-1">MANAGEMENT</div>
                <br><br>
                <div>
                    <div class="admin-link">
                        <label for="staff" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-user-nurse"></i>
                            <a href="listWattingPatient" style="text-decoration: none;color: white">Waiting</a>
                        </label>

                    </div>
                    <div class="admin-link">
                        <label for="staff" class="d-flex px-4 align-items-center admin-nav-label">
                            <i class="fa-solid fa-user-nurse"></i>
                            <a href="listCompletePatient" style="text-decoration: none;color: white">Complete</a>
                        </label>
                    </div>            
                </div>  
<!--                <a style="margin-top: 250px" type="submit" name="home" value="Logout" class="btn btn-logout">-->
                    <a href="logout" style="margin-top: 250px"  name="home" value="Logout" class="btn btn-logout">Logout</a>
            </div>


        </div>

    </body>
</html>
