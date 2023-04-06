<%-- 
    Document   : detail
    Created on : Jan 29, 2023, 9:40:02 PM
    Author     : asus
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    thead {
        background-color: #5bc1ac;
    }
    thead th {
        text-align: center;
    }
    td {
        text-align: center;
        margin-top: 10px;
    }
    button a {
        text-decoration: none;
        color: inherit;
        cursor: inherit;
    }
    .td-body{
        margin-top: 10px;
    }
    td {

    }
</style>
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<html>

    <%@include file="AdminView/admin-layout/admin-head.jsp" %>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <body onload="getPositionNavBar(6)">
        <div class="vw-100 vh-100 d-flex">
            <%@include file="AdminView/admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="container">



                    <div class="row align-items-start">
                        <div class="section-title text-center" style="margin: 20px">

                            <form method="post" action="currentBooking" onsubmit="return validateSearch()">
                                <label for="email">Email:</label>
                                <input type="email" name="email" id="email">

                                <label for="phone">Số điện thoại:</label>
                                <input type="tel" maxlength="10" minlength="10" name="phone" id="phone">

                                <button type="submit">Search</button>
                                <a style="border-style: solid;
                                   border-width: 1px;
                                   border-radius: 5px;
                                   border-color: #ccc;
                                   background-color: #f7f7f7;
                                   padding: 10px 20px;
                                   color: #333;
                                   text-decoration: none;
                                   display: inline-block;" href="record.jsp">Add New Patient</a>
                                <a style="border-style: solid;
                                   border-width: 1px;
                                   border-radius: 5px;
                                   border-color: #ccc;
                                   background-color: #f7f7f7;
                                   padding: 10px 20px;
                                   color: #333;
                                   text-decoration: none;
                                   display: inline-block;" href="searchBooking">History Booking</a>
                                <c:if test="${check ne null}" >
                                    <p style="color: red;font-size: 20px">${check}</p>
                                </c:if>
                            </form>
                        </div>


                    </div>
                    <% int count = 0;%>
                    <div class="row align-items-center">
                        <div class="col">

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Email</th>
                                        <th>Day</th>
                                        <th>Time</th>
                                        <th>Status</th>
                                        <th>Add</th>
                                        <th>Late</th>
                                    </tr>
                                </thead>


                                <c:forEach items="${listCurrent}" var="p">
                                    <tbody> 
                                                <tr><td><% count++;
                                            out.print(count);%> </td>
                                            <td>${p.getName()}</td>
                                            <td>${p.getPhone()}</td>
                                            <td>${p.getEmail()}</td>
                                            <td>${p.getDay()}</td>
                                            <td class="td-body">${p.getTime()}</td>        
                                            <td class="td-body"> <c:if test="${p.getStatus()==1}" >
                                                    <p style="color: red;font-size: 20px">done</p>
                                                </c:if>
                                                <c:if test="${p.getStatus()==0}" >
                                                    <p style="color: green;font-size: 20px">not yet</p>
                                                </c:if></td>

                                            <td class="td-body"><c:if test="${p.getStatus()!=1}">
                                                    <a href="GetPatientOnline?id=${p.getBookingId()}"><ion-icon style="font-size:30px; margin-top: 10px" name="add-circle-outline"></ion-icon></a>
                                                </c:if></td>
                                            <td><c:if test="${p.getStatus()!=1}"><a href="lateBooking?id=${p.getBookingId()}"><ion-icon style="font-size:30px; margin-top: 10px" name="close-circle-outline"></ion-icon></a>
                                                </c:if></td>
                                        </tr>

                                    </tbody>
                                </c:forEach>

                            </table>

                        </div>

                    </div>

                    <div class="row align-items-end">


                    </div>



                </div>

            </div>
        </div>

    </body>
    <script>
        function validateSearch() {
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;

            if (email === "" || phone === "") {
                alert("Vui lòng nhập đủ hai ô tìm kiếm");
                return false;
            }
            return true;
        }
    </script>
</html>
