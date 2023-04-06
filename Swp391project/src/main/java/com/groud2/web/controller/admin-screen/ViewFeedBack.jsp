<%-- 
    Document   : ViewFeedBack
    Created on : Feb 12, 2023, 8:25:23 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <body onload="getPositionNavBar(5)">
        <form action="feedback" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
                <input name="setPosition" type="text" value="1" class="d-none">
<!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content">
                
            </div>
        </form>
    </body>
</html>
