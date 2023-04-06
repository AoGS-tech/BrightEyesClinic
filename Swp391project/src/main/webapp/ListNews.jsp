<%-- 
    Document   : ListNews
    Created on : Feb 5, 2023, 12:24:34 PM
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

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center mb-4">
                        <br>  <h1>News </h1>
                        <div style="text-align: start">

                            <li class="nav-item dropdown" style="list-style-type: none; align-items: start">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdownMenuButton2" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">Category <span class="sr-only">(current)</span></a>
                                   <div class="dropdown-menu" aria-labelledby="dropdownMenuLink_1" ">
                                    <a class="dropdown-item" href="search?categoryname=TIN SỰ KIỆN"  >Events</a>
                                    <a class="dropdown-item" href="search?categoryname=CÂU CHUYỆN KHÁCH HÀNG">Customer Story </a>
                                    <a class="dropdown-item" href="search?categoryname=THÔNG TIN NHÃN KHOA">Ophthalmic information</a>
                                    
                                </div>
                            </li>   
                        </div> 
                        <form action="search" method="post" style="margin-left: 70%">
                            <input type="text" name="search_value" > 
                            <input type="submit" value="Search">
                            
                        
                        </form>
                        
                        <br>  <br>  <br> 
                    </div>

                    <c:forEach items="${listNews}" var="item">
                        <div class="col-lg-3 col-md-3 col-3 mb-2 " ">
                            <div class="custom-block-wrap">                             
                                <img src="${item.getImages1()}" style="width: 100%;height: 200px"class="custom-block-image img-fluid" alt="">
                                <div class="custom-block" >                                   
                                    <div class="custom-block-body">
                                        ${item.getCategory()}
                                        <h6 style="height: 100px">${item.getNewsname()}</h6>

                                        <div class="d-flex align-items-center my-2">
                                            <p class="ms-auto mb-0">
                                                <strong> ${item.getDatepublic()}</strong>
                                            </p>
                                        </div>
                                    </div>

                                                <a href="singleNewsController?newsname=${item.getNewsname()}" class="custom-btn  btn-lg text-center" > <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                        </svg> Xem chi tiết </a>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                     <c:forEach items="${listcategory}" var="item">
                        <div class="col-lg-3 col-md-3 col-3 mb-2 " ">
                            <div class="custom-block-wrap">                             
                                <img src="${item.getImages1()}" style="width: 100%;height: 200px"class="custom-block-image img-fluid" alt="">
                                <div class="custom-block" >                                   
                                    <div class="custom-block-body">
                                        ${item.getCategory()}
                                        <h6 style="height: 100px">${item.getNewsname()}</h6>

                                        <div class="d-flex align-items-center my-2">
                                            <p class="ms-auto mb-0">
                                                <strong> ${item.getDatepublic()}</strong>
                                            </p>
                                        </div>
                                    </div>

                                                <a href="singleNewsController?newsname=${item.getNewsname()}" class="custom-btn  btn-lg text-center" > <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                        </svg> Xem chi tiết </a>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                     <c:forEach items="${listSearchValue}" var="item">
                        <div class="col-lg-3 col-md-3 col-3 mb-2 " ">
                            <div class="custom-block-wrap">                             
                                <img src="${item.getImages1()}" style="width: 100%;height: 200px"class="custom-block-image img-fluid" alt="">
                                <div class="custom-block" >                                   
                                    <div class="custom-block-body">
                                        ${item.getCategory()}
                                        <h6 style="height: 100px">${item.getNewsname()}</h6>

                                        <div class="d-flex align-items-center my-2">
                                            <p class="ms-auto mb-0">
                                                <strong> ${item.getDatepublic()}</strong>
                                            </p>
                                        </div>
                                    </div>

                                                <a href="singleNewsController?newsname=${item.getNewsname()}" class="custom-btn  btn-lg text-center" > <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                        </svg> Xem chi tiết </a>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
            </div>
        </main>
        <br><!-- comment -->
        <br><!-- comment -->

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>


