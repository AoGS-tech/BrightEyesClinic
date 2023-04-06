<%-- 
    Document   : FAQ
    Created on : Mar 9, 2023, 3:07:33 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <div class="container-fluid">
            <div class="text-center fs-2 mt-2 bg-light" style="height: 80px; line-height: 80px;">
                FREQUENTLY ASKED QUESTIONS
            </div>
            <div>
                <%@include file="FAQComponent.jsp" %>
            </div>
        </div>


    </body>
</html>
