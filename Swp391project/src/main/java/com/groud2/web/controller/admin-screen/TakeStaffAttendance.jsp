<%-- 
    Document   : TakeStaffAttendance
    Created on : Feb 26, 2023, 6:42:28 PM
    Author     : Ao
--%>

<%@page import="com.groud2.web.model.user"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <body class="vw-100">
        <form action="takeAttendance" method="post" class="row justify-content-center mt-5">
            <c:forEach items="${staff}" var="s">
                <input type="text" name="staffAccount" class="d-none" value="${staffAccount}">
                <input type="text" name="staffId" class="d-none" value="${s.getUserId()}">
                <div class="card card-body col-sm-4">
                    <h2 class="text-center">TAKE ATTENDANCE</h2>
                    <small class="w-100 text-center">FOR</small>
                    <h4 class="text-center">${s.getFullname()}</h4>
                    <div class="text-center" style="color: red;">${message}</div>
                    <div class="mb-3">
                        <label class="">Date:</label>
                        <input type="text" name="date" id="date" class="form-control" value="${today}" maxlength="10" minlength="10">
                    </div>
                    <div class="mb-5">
                        <label class="">Time:</label>
                        <input type="text" name="time" id="time" class="form-control" value="${nowTime}" minlength="5" maxlength="8">
                    </div>

                    <input type="submit" name="submitAttendance" class="btn btn-success" value="SUBMIT">
                </div>
            </c:forEach>

            <div class="col-sm-4">
                <div class="d-flex">
                    <select class="form-control" name="dateOfList">
                        <option value="${today}" selected="">${today}</option>
                        <c:forEach items="${listAtt}" var="at">
                            <option value="${at.getDate()}" selected="">${at.getDate()}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" name="searchDate" value="Search" class="btn btn-success">
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Time</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <% int count = 0; %>
                    <c:forEach items="${listAtt}" var="at">
                        <tbody>
                            <tr>
                                <td><% count++; out.print(count); %></td>
                                <td>${at.getTime()}</td>
                                <td>
                                    <input type="text" name="update" value="${at.getId()}" id="${at.getId()}" class="d-none">
                                    <label for="${at.getId()}" class="btn btn-success">
                                        <i class="fa-solid fa-pen-nib"></i>
                                    </label>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>

            </div>
        </form>
    </body>
</html>
