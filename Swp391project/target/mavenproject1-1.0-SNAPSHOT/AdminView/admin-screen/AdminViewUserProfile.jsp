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
        <form action="adminViewUserProfile" method="post" class="position-relative">
            <% String role = (String) session.getAttribute("viewUserRole");%>
            <c:forEach items="${user}" var="u">
                <div class="container rounded bg-white mt-5 mb-5">
                    <div class="row">
                        <div class="col-md-3 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">${u.getFullname()}</span><span class="text-black-50">${u.getEmail()}</span><span> </span></div>
                            <br>
                            <br>
                            <div>${message}</div>
                        </div>
                        <div class="col-md-5 border-right">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Profile Settings</h4>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-md-12"><label class="labels">Name</label><input type="text" name="name" class="form-control" placeholder="first name" value="${u.getFullname()}" required=""></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="row mx-1">
                                        <div class="col-md-6"><label class="labels">User ID</label><input type="text" class="form-control" placeholder="ID" value="${u.getUserId()}" required="" readonly=""></div>
                                        <div class="col-md-6"><label class="labels">Gender</label>
                                            <select name="gender" class="form-control">
                                                <c:set var="gender" value="${u.getGender()}"/>
                                                <option value="Male" <c:if test="${gender == 'Male'}">selected</c:if>>Male</option>
                                                <option value="Female" <c:if test="${gender == 'Female'}">selected</c:if>>Female</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" name="phone" class="form-control" placeholder="enter phone number" value="${u.getPhonenumber()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Email</label><input type="email" name="email" class="form-control" placeholder="Email" value="${u.getEmail()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Account</label><input type="text" name="account" class="form-control" placeholder="Account" value="${u.getAccount()}" required="" readonly=""></div>
                                    <div class="col-md-12"><label class="labels">Date of birth</label><input type="date" name="bod" class="form-control" placeholder="Date of birth" value="${u.getBod()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Address</label><input type="text" name="address" class="form-control" placeholder="address" value="${u.getAddress()}" required=""></div>
                                    <div class="col-md-12"><label class="labels">Role</label>
                                        <select name="role" class="form-control">
                                            <option value="ADMIN" <c:if test="${u.getRole() == 'admin'}">selected</c:if>>Admin</option>
                                            <option value="DOCTOR" <c:if test="${u.getRole() == 'doctor'}">selected</c:if>>Doctor</option>
                                            <option value="CASHER" <c:if test="${u.getRole() == 'casher'}">selected</c:if>>Casher</option>
                                            <option value="CUSTOMER" <c:if test="${u.getRole() == 'customer'}">selected</c:if>>Customer</option>
                                            </select>

                                        </div>
                                        <div class="mt-5 justify-content-center d-flex">
                                            <button type="button" class="btn btn-primary profile-button" style="margin-left: 110px;" data-toggle="modal" data-target="#exampleModal">
                                                Save Profile
                                            </button>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title text-danger" id="exampleModalLabel">Warning</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div>Do you want to change profile of <b>${u.getFullname()}</b>?</div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="${backpage}" class="btn btn-primary profile-button mx-3">Exit</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </form>
</body>
</html>
