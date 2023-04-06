<%-- 
    Document   : ViewFeedBack
    Created on : Feb 12, 2023, 8:25:23 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                 <div class="container">
      <h2>Feedback</h2>
      
      <table class="table table-bordered">
    <thead>
      <tr>
        <th> No</th>
        <th> Name</th>
        <th>Email</th>
        <th>Feedback</th>
        
      
        
      </tr>
    </thead>
    <tbody>
         <c:forEach items="${listFb}" var="item"> 
      <tr>
          <td>${item.getNo()}</td>
          <td>${item.getName()}
        <td>${item.getEmail()}</td>
        <td>${item.getFeedbacks()}</td>
     
        
      </tr>
       </tbody>
           </c:forEach>
       </table>
      </div>
            </div>
        </form>
    </body>
</html>
