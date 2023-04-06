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
            body {
                background: rgb(99, 39, 120);
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
    </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <form action="updateProfile" method="post">


            <div class="container rounded bg-white mt-5 mb-5">
                <div class="row">
                    <div class="col-md-4 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold"></span><span class="text-black-50"></span><span> </span></div>
                    </div>
                    <div class="col-md-6 border-right">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                               
                            </div>



                            <div class="row mt-2" style="border: 5px solid #5bc1ac; padding: 20px 20px; border-radius: 5px">

                                <div class="col-md-12"><label class="labels">Full Name</label><input type="text" name="newName" class="form-control" value="${fullname}"></div>
                                <div class="col-md-6"><label class="labels">Account</label><input type="text" class="form-control" value="${account}" readonly></div>

                                <div class="col-md-6"><label class="labels">Gender</label><input type="text" name="newGender" class="form-control" value="${gender}"  ></div>
                                <div class="col-md-12"><label class="labels">Choose new gender</label><input type="radio" name="newGender" value="Male" style="margin-left: 50px"> Male
                                    <input type="radio" name="newGender" value="FeMale" style="margin-left: 150px"> FeMale 

                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12"><label class="labels">Mobile Number</label><input validate-input type="text" name="newPhone" class="form-control" value="${phonenumber}"></div>
                                    
                                    <div class="col-md-12"><label class="labels">Address</label><input type="text" name="newAddress" class="form-control" value="${address}"></div>

                                    <div class="col-md-12"><label class="labels">Email</label><input type="text" name="newEmail" validate-input class="form-control" value="${email}" ></div>

                                    <div class="col-md-12"><label class="labels">Birth Of Date</label><input type="date" name="newBod" class="form-control" value="${bod}"></div>

                                    <div class="d-grid gap-2 col-4 mx-auto" style="margin-top: 10px;color: black">
                                        <button type="button" class="btn btn-primary profile-button" style="margin-left: 45px;" data-toggle="modal" data-target="#exampleModal">
                                                Update
                                            </button>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title text-danger" id="exampleModalLabel">Confirm Update Profile</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div>Do you want to change your profile?</div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>



                                </div>

                            </div>

                        </div>

                    </div>

                </div>
            </div>
        </form>
        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
