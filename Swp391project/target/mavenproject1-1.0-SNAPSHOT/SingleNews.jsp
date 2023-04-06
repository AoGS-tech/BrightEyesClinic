<%-- 
    Document   : SingleNews
    Created on : Feb 5, 2023, 1:37:53 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <c:forEach items="${SingleNews}" var="item">                       



            <div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">
                <h3 style="margin-top: 100px;margin-left: 200px;margin-right: 200px">${item.getNewsname()}</h3>
                <p>

                <span style="margin-left: 200px">${item.getDatepublic()}</span>
                <br> <br> <div style="margin-left: 250px"><h6>${item.getIssue1()}</h6></div>
                <br> <div style="margin-left: 250px;margin-right: 250px"><span style="margin-top: 200px;" >${item.getNewscontent1()}</span></div>            
                <br> <div style="margin-left: 400px;margin-right:  400px"><img src="${item.getImages1()}" style="width: 700px;height: 400px" alt="alt"/> </div>                             
                <br> <br><div style="margin-left: 250px"><h6>${item.getIssue2()}</h6></div>
                <br> <div style="margin-left: 250px;margin-right: 250px"><span style="margin-top: 200px;" >${item.getNewscontent2()}</span></div>            
                <br> <div style="margin-left: 400px;margin-right:  400px"><img src="${item.getImages2()}" style="width: 700px;height: 400px" alt="alt"/> </div>                             
                <br> <br><div style="margin-left: 250px"><h6>${item.getIssue3()}</h6></div>
                <br> <div style="margin-left: 250px;margin-right: 250px"><span style="margin-top: 200px;" >${item.getNewscontent3()}</span></div>            
                <br> <div style="margin-left: 400px;margin-right:  400px"><img src="${item.getImages3()}" style="width: 700px;height: 400px" alt="alt"/> </div>                             
                <br> <br><div style="margin-left: 250px"><h6>${item.getIssue4()}</h6></div>
                <br> <div style="margin-left: 250px;margin-right: 250px"><span style="margin-top: 200px;" >${item.getNewscontent4()}</span></div>            
                <br> <div style="margin-left: 400px;margin-right:  400px"><img src="${item.getImages4()}" style="width: 700px;height: 400px" alt="alt"/> </div>                             
                <br><br><br><br> <div style="margin-left: 1000px"><h6>Author  : ${item.getAuthour()}</h6></div><br><br>
            </p>

        </div>

    </c:forEach>



    <jsp:include page="layout/chatbot.jsp"/>
    <jsp:include page="layout/footer.jsp"/>
</body>
</html>


