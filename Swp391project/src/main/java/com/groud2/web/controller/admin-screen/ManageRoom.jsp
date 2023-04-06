<%-- 
    Document   : ManageRoom
    Created on : Feb 11, 2023, 4:19:31 PM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        #manage-room-header {
            width: 300px;
            height: 40px;
        }

        #search-room-btn {
            width: 60px;
        }

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

        .icon-plus {
            font-size: 5em;
        }

        .hidden{
            display: none;
        }
        .display {
            display: block !important;
        }
    </style>
    <body onload="getPositionNavBar(3)">
        <form action="manageRoom" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="4" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                <div class="alert alert-success alert-dismissible hidden ${display}">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    ${message}
                </div>
                <div class="d-flex justify-content-between mt-3">
                    <h2>Room Management</h2>
                    <div class="d-flex" id="manage-room-header">
                        <input type="text" name="searchRoom" id="search-room" class="form-control h-100"><!-- comment -->
                        <button id="search-room-btn"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
                <br>
                <br>
                <div class="d-flex flex-wrap overflow-scroll">
                    <div>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn room-modal-btn" data-toggle="modal" data-target="#createRoom">
                            <div class="card card-room">
                                <div class="card-header text-center text-light">
                                    Create new room
                                </div>
                                <div class="card-body text-center text-light">
                                    <div class="icon-plus"><i class="fa-solid fa-plus"></i></div>
                                </div>
                            </div>
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="createRoom" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Create a new room</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-floating">
                                            <input type="text" name="newRoomID" class="form-control" id="new-room-id" placeholder="Room ID">
                                        </div>
                                        <div class="form-floating mt-3">
                                            <input type="text" name="newRoomName" class="form-control" id="new-room-name" placeholder="Room Name">
                                        </div>
                                        <div class="form-floating mt-3">
                                            <input type="text" name="newRoomFunction" class="form-control" id="new-room-function" placeholder="Room Function">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <input type="submit" name="addRoom" value="Create" class="btn btn-success">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <c:forEach items="${listRoom}" var="r">
                        <div>
                            <a href="updateRoom?roomID=${r.getRoomID()}" style="text-decoration: none;">
                                <div class="card card-room mt-1 mx-2">
                                    <div class="card-header text-left text-light">
                                        ${r.getRoomName()}
                                    </div>
                                    <div class="card-body text-left text-light">
                                        <div>Room ID: ${r.getRoomID()}</div>
                                        <div>Room Function: ${r.getRoomFunction()}</div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>


            </div>
        </form>
    </body>
</html>
