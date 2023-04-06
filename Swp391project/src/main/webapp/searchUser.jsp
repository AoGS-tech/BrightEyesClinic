<%-- 
    Document   : searchUser
    Created on : Mar 12, 2023, 1:17:32 PM
    Author     : Admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            thead {
                background-color: #5bc1ac;
            }
            thead th {
                text-align: center;
            }
            td {
                text-align: center;
            }
            button a {
                text-decoration: none;
                color: inherit;
                cursor: inherit;
            }
        </style>
    </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>


        <div class="container">



            <div class="row align-items-start">
                <div class="section-title text-center" style="margin: 20px">

                    <form method="post" action="searchUser" onsubmit="return validateSearch()">
                        <div>${check}</div>

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
                           display: inline-block;" href="record">Add New Patient</a>
                        
                    </form>
                </div>


            </div>

            <div class="row align-items-center">
                <div class="col">

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Gender</th>
                                <th>Date</th>

                                <th>Add</th>
                            </tr>
                        </thead>


                        <c:forEach items="${list}" var="p">
                            <tbody> 
                                <tr><td>${p.getUserId()} </td>
                                    <td>${p.getFullname()}</td>
                                    <td>${p.getPhonenumber()}</td>
                                    <td>${p.getAddress()}</td>
                                    <td>${p.getEmail()}</td>
                                    <td>${p.getGender()}</td>
                                    <td>${p.getBod()}</td>        

                                    <td><a href="GetPatientOnline?id=${p.getUserId()} "><ion-icon style="font-size:25px" name="add-circle-outline"></ion-icon></a></td>
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
    <script>
        function validateSearch() {
            
            var phone = document.getElementById("phone").value;

            if (phone === "") {
                alert("Vui lòng nhập ô tìm kiếm");
                return false;
            }
            return true;
        }
    </script>
</html>