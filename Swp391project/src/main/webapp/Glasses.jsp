<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <style>
            .page{
                margin: 0 50%;
            }
        </style>
        <main>
            <div class="container ">
                <div class="row">

                    <div class="col-lg-12 text-center mb-4">
                        <br>
                        <h2>Glasses</h2>
                    </div>
                     <div style="text-align: start">

                            <li class="nav-item dropdown" style="list-style-type: none; align-items: start">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdownMenuButton2" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">Category <span class="sr-only">(current)</span></a>
                                   <div class="dropdown-menu" aria-labelledby="dropdownMenuLink_1" ">
                                       <a class="dropdown-item" href="glasses?paging=1"  onchange>All Glasses</a>
                                    <a class="dropdown-item" href="categoryGlasses?paging=1&categoryname=0" onchange >Male</a>
                                    <a class="dropdown-item" href="categoryGlasses?paging=1&categoryname=1" onchange>FeMale </a>
                                    
                                    
                                </div>
                            </li>   
                        </div> 
                    <c:forEach items="${listGlasses}" var="item">
                        <div class="col-lg-4 col-md-6 col-3 mb-4 ">
                            <div class="custom-block-wrap">
                                <img src="${item.getImage()}" class="custom-block-image img-fluid" alt="">

                                <div class="custom-block" >
                                    <div class="custom-block-body">
                                        <h5 >${item.getGlassName()}</h5>

                                        <p>Color :${item.getColor()} </p>

                                        <p>Gender :${item.getGender()} </p>

                                        <p>Material :${item.getMaterial()} </p>

                                        <p>Style :${item.getStyle()} </p>
                                        <div class="d-flex align-items-center my-2">
                                            <p class="ms-auto mb-0">
                                                <strong>Goal:</strong>
                                                <b>$${item.getPrice()}</b>
                                            </p>
                                        </div>
                                    </div>

                                    <a href="addtocart?glassesId=${item.getGlassID()}&num=1" class="custom-btn  btn-lg text-center" > <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                        </svg> Add to card </a>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                    
                </div>
            </div>
            <nav aria-label="Page navigation example " class="page">
                <ul class="pagination">
                    
                   
                    <li class="page-item"><a class="page-link" href="glasses?paging=1">1</a></li>
                    <li class="page-item"><a class="page-link" href="glasses?paging=2">2</a></li>
                    <li class="page-item"><a class="page-link" href="glasses?paging=3">3</a></li>
                    
                </ul>
            </nav>
            
        </main>
        <br><!-- comment -->
        <br><!-- comment -->

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>

