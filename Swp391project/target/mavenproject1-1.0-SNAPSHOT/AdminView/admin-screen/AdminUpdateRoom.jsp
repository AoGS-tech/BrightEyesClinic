<%-- 
    Document   : AdminUpdateRoom
    Created on : Mar 8, 2023, 10:37:39 PM
    Author     : Ao
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        .card-room {
            width: 250px;
            height: 250px;
        }

        .card-header {
            height: 60px;
            background-color: #5a6f80;
            font-size: 1.5em;
        }

        .card-body {
            background-color: #5bc1ac;
        }

        .my-btn {
            margin-top: 17%;
            /*margin-left: 5%;*/
        }

        .group-btn {
            width: 200px;
            margin: 30px;
        }
    </style>

    <body onload="getPositionNavBar(3)">
        <form action="updateRoom" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="5" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="row justify-content-center">
                    <c:forEach items="${listRoom}" var="r">
                        <div class="card card-body col-4 mt-5">
                            <div>
                                <label for="room-name">Room Name:</label>
                                <input type="text" name="roomName" value="${r.getRoomName()}" id="room-name" placeholder="room-name" class="form-control" required="">
                            </div>
                            <div>
                                <label for="room-id">Doctor:</label>
                                <select name="userID" class="form-control">
                                    ${username}
                                    <c:forEach items="${listStaff}" var="s">
                                        <option value="${s.getUserId()}" <c:if test="${s.getFullname() == username}">selected</c:if>>${s.getFullname()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <label for="room-function">Room Function:</label>
                                <input type="text" name="roomFunction" value="${r.getRoomFunction()}" id="room-name" placeholder="room-name" class="form-control" required="">
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <br>
                <div class="row justify-content-center my-btn">
                    <!--<input type="submit" name="update" class="btn btn-success" value="UPDATE">-->
                    <!-- Button to trigger the modal -->
                    <button type="button" class="btn btn-success group-btn" data-toggle="modal" data-target="#update">
                        UPDATE
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel1">Warning</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure to update room information?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" name="update" class="btn btn-success" value="UPDATE">
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-warning group-btn" data-toggle="modal" data-target="#delete">
                        DELETE
                    </button>

                    <!--Modal--> 
                    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel2">Warning</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure to delete this room?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" name="delete" class="btn btn-warning mx-3" value="DELETE">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </form>
    </body>
</html>
