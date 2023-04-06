<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <style>
        h1 {
            text-align: center;
            color: #5bc1ac;
            border: 10px solid #5bc1ac;
            padding: 15px;
            border-radius: 40px;
            font-size: 25px;
        }
        .p-sc{
            color: black;
            font-size: 20px;
        }
        .body-sc{
            margin-top: 20px;
            border: 4px solid #5bc1ac;
            padding: 10px 10px;
            margin-bottom: 20px;
            border-radius: 10px;
        }
    </style>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <!-- Nội dung cột 1 -->
                </div>



                <div class="col-md-6">
                    <h1 style="text-align: center; color: #28a745"> <b>Booking Consulting Successfully</b></h1>
                    <div class="body-sc">
                        <p class="p-sc"><b>Name:</b> ${name}</p><br>
                        <p class="p-sc"><b>Phone Number:</b> ${phone} </p><br>
                        <p class="p-sc"><b>Email:</b> ${email}</p><br>
                        <p class="p-sc"><b>Date consulting:</b> ${date}</p><br>
                        <p class="p-sc"><b>Time:</b> ${time}</p><br>
                        <p class="p-sc"><b>Address clinic:</b> FPT University, Thạch Hòa, Thạch Thất, Hà Nội</p><br>
                        <p style="color: orange">Please come at that time. If you late, We must force to postpone your appointment to the end of the day </p>
                        
                        <p style="text-align: right; font-size: 20px;color: black">Bright Eyes Clinic,</p>
<p>If you want to booking another consulting, please enter<a style="color: blue" href="booking.jsp"> Booking Consulting</a> again.</p>
                        
                    </div> </div>

                <div class="col-md-3">
                    <!-- Nội dung cột 3 -->
                </div>


            </div>

            <jsp:include page="layout/chatbot.jsp"/>
            <jsp:include page="layout/footer.jsp"/>
            <script>

            </script>
    </body>
</html>