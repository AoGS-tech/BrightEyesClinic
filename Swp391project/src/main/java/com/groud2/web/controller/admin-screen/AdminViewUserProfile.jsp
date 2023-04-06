<%-- 
    Document   : AdminViewUserProfile
    Created on : Feb 27, 2023, 9:45:26 AM
    Author     : Ao
--%>

<%@page import="com.groud2.web.model.user"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        body {
            background-color: #5a6f80;
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #BA68C8
        }

        .profile-button {
            background: rgb(99, 39, 120);
            box-shadow: none;
            border: none
        }

        .profile-button:hover {
            background: #682773
        }

        .profile-button:focus {
            background: #682773;
            box-shadow: none
        }

        .profile-button:active {
            background: #682773;
            box-shadow: none
        }

        .back:hover {
            color: #682773;
            cursor: pointer
        }

        .labels {
            font-size: 11px
        }

        .add-experience:hover {
            background: #BA68C8;
            color: #fff;
            cursor: pointer;
            border: solid 1px #BA68C8
        }
    </style>
    <body>
        <form action="">
            <% String role = (String)session.getAttribute("viewUserRole");%>
            <c:forEach items="${user}" var="u">
                <div class="container rounded bg-white mt-5 mb-5">
                    <div class="row">
                        <div class="col-md-3 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">${u.getFullname()}</span><span class="text-black-50">${u.getEmail()}</span><span> </span></div>
                        </div>
                        <div class="col-md-5 border-right">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Profile Settings</h4>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-md-12"><label class="labels">Name</label><input type="text" class="form-control" placeholder="first name" value="${u.getFullname()}" required=""></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="row mx-1">
                                        <div class="col-md-6"><label class="labels">User ID</label><input type="text" class="form-control" placeholder="ID" value="${u.getUserId()}" required=""></div>
                                        <div class="col-md-6"><label class="labels">Gender</label><input type="text" class="form-control" placeholder="Gender" value="${u.getGender()}" required=""></div>
                                    </div>
                                    <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" class="form-control" placeholder="enter phone number" value="${u.getPhonenumber()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Email</label><input type="email" class="form-control" placeholder="Email" value="${u.getEmail()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Account</label><input type="text" class="form-control" placeholder="Account" value="${u.getAccount()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Date of birth</label><input type="text" class="form-control" placeholder="Date of birth" value="${u.getBod()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control" placeholder="address" value="${u.getAddress()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Role</label><input type="text" class="form-control" placeholder="role" value="${u.getRole().toUpperCase()}" required=""></div>
                                    
                                </div>
                                    <div class="mt-5 text-center">
                                        <button class="btn btn-primary profile-button" type="button">Save Profile</button>
                                        <a href="${backpage}" class="btn btn-primary profile-button">Exit</a>
                                    </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="p-3 py-5">
                                <% if(role.equals("customer") || role.equals("")){ %>
                                <%@include file="../admin-layout/user-profile-medical-record-list.jsp" %>
                                <% }else { %>
                                <%@include file="../admin-layout/user-profile-staff-internal-information.jsp" %>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</form>
</body>
</html>
