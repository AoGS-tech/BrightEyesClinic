<%-- 
    Document   : AdminEditUser
    Created on : Feb 18, 2023, 2:32:44 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>
        .edit-user-title {
            height: 80px;
            /*width: 100vw;*/
            background-color: #5a6f80;
            line-height: 80px;
            font-size: 2em;
        }

        #infor-box-left {
            /*width: 50%;*/
            height: calc(100vh - 100px);
            border-right: 2px red;
            border-right-style: dashed;
            width: 40%;
        }
        form {
            margin: 0;
            padding: 0;
        }

        .info-line{
            margin-left: 10%;
            width: 80%;
        }

        .info-img-box {
            width: 8em;
            height: 6em;
            border: 1px solid red;

        }

        .info-input-line {
            height: 40px;
            /*margin-top: 3.7em;*/
        }

        #user-gender, #user-role {
            height: 35px;
        }

        #infor-box-right {
            height: calc(100vh - 100px);
            width: 60%;
        }

        #staff-info, #customer-info {
            display: none;
        }

        /*-----------------------------------------------------*/
        #save-btn {
            /*margin-left: 50%;*/
            height: 40px;
            width: 150px;
        }

        #edit-btn {
            height: 35px;
        }
    </style>

    <body onload="deepInformation()">

        <form action="" class="vw-100">
            <div class="edit-user-title text-center text-light justify-content-between vw-100 d-flex align-items-center">
                <input type="submit" name="exit" value="EXIT" class="btn btn-warning mx-3" id="edit-btn">
                <div>
                    <b>USER INFORMATION MANAGEMENT</b>
                </div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-success mr-3" id="save-btn" data-toggle="modal" data-target="#save-change">
                    SAVE CHANGE
                </button>
            </div>
            <div class="vw-100 d-flex">
                <div id="infor-box-left">
                    <%@include file="UserBasicInformation.jsp" %>
            </div>
            <div id="infor-box-right">
                <div id="staff-info">
                    <%@include file="InformationOfStaff.jsp" %>
                </div>
                <div id="customer-info">
                    <%@include file="InformationOfCustomer.jsp" %>
                </div>
            </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="save-change" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Save your change</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure with your changing?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input type="submit" name="save" value="Save changes" class="btn btn-primary">
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <script>
            function deepInformation() {
                console.log('Im here');
                var userRole = document.getElementById('user-role').value;
                const staffInfo = document.getElementById('staff-info');
                const customerInfo = document.getElementById('customer-info');
                if (userRole === "") {
                    staffInfo.style.display = 'none';
                    customerInfo.style.display = 'block';
                } else {
                    staffInfo.style.display = 'block';
                    customerInfo.style.display = 'none';
                }
            }

        </script>
    </body>
</html>
