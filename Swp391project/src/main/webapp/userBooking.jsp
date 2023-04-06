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
        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            .user-list{
                text-align: center;
            }
        </style>
    </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <form action="userBooking">
            <div class="container">



                <div class="row align-items-start">
                    <div class="section-title text-center" style="margin: 20px">



                    </div>


                </div>
                <c:if test="${cancel ne null}" >
                    <p style="color:#00ccff;font-size: 20px">${cancel}</p>
                </c:if>
                <div class="row align-items-center">
                    <div class="col">

                        <table class="table table-bordered">
                            <thead>
                                <% int count = 0;%>
                                <tr style="background-color: #5bc1ac">
                                    <th class="user-list">No.</th>
                                    <th class="user-list">Name</th>
                                    <th class="user-list">Phone</th>
                                    <th class="user-list">Email</th>
                                    <th class="user-list">Day</th>
                                    <th class="user-list">Time</th>
                                    <th class="user-list">Medical Information</th>
                                                      
                                    <th class="user-list">Cancel</th>                             
                                </tr>
                            </thead>


                            <c:forEach items="${list}" var="p">
                                <tbody> 
                                    <tr><td><% count++;
                                    out.print(count);%> </td>
                                        <td>${p.getName()}</td>
                                        <td>${p.getPhone()}</td>
                                        <td>${p.getEmail()}</td>
                                        <td>${p.getDay()}</td>
                                        <td>${p.getTime()}</td>
                                        <td>${p.getMedical()}</td>
                                        
                                        <td style="text-align: center">
                                            
                                            <button  type="button" class="btn btn-danger" data-toggle="modal" data-target="#cancel">
                                                    Cancel
                                            </button>  
                                            <div class="modal fade" id="cancel" tabindex="-1" role="dialog" aria-labelledby="cancelForm"
                                                 aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="cancelForm">Confirm Cancel Booking</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            Do you want to cancel booking?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                                                            <button type="button" style="background: none; outline: none;border: none"><a  href="cancelBooking?id=${p.getBookingId()}" class="btn btn-danger m-auto"><i class="fa-solid fa-pen">Cancel</i></a>
                                                            </button>
                                                            </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>

                        </table>

                    </div>

                </div>

                <div class="row align-items-end">


                </div>

        </form>

    </div>

    <jsp:include page="layout/chatbot.jsp"/>
    <jsp:include page="layout/footer.jsp"/>
</body>
</html>
