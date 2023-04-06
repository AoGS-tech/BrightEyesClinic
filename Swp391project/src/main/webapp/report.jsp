

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
        <title>report</title>

        <style>
        </style>



   </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>




          <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                    <ul>
                        <li class="menu_report" ><a href="url">Sale</a></li>
                        <li class="menu_report" ><a href="url">Total Customer</a></li>
                        <li class="menu_report" ><a href="url">Revenue</a></li>
                        <li class="menu_report" ><a href="url">Customer Feedback</a></li>
                    </ul>

                </div>
                <div class="col-md-8 border-right">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Item Id</th>
                                <th>Item Name</th>
                                <th>Price(VND)</th>
                                <th>Amount</th>
                                <th>Total Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>2</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>


                </div>

            </div>

        </div>

    </div>
</div>



        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>


</html>
