<%-- 
    Document   : detail
    Created on : Jan 29, 2023, 9:40:02 PM
    Author     : asus
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>

        </style>
    </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <div class="container">



            <div class="row align-items-start">


            </div>

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
                                    <th>Medical Information</th>
                                    <th>Payment</th>
                                    <th>Time Booking</th>
                                </tr>
                            </thead>


                             <c:forEach items="${list}" var="p">
                            <tbody> 
                                <tr><td>${p.getBookingId()} </td>
                                    <td>${p.getName()}</td>
                                    <td>${p.getPhone()}</td>
                                    <td>${p.getEmail()}</td>
                                    <td>${p.getDay()}</td>
                                    <td>${p.getTime()}</td>
                                    <td>${p.getMedical()}</td>
                                    <td>${p.getPayment()}</td>
                                    <td>${p.getSbtime()}</td>
                                    
                                    <td>Delete</td>
                                </tr>
                            </tbody>
                        </c:forEach>

                    </table>

                </div>

            </div>

            <div class="row align-items-end">


            </div>



        </div>
        

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
