<%-- 
    Document   : 404
    Created on : Jan 29, 2023, 9:47:52 AM
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        
        <!-- Hero Start -->
        <section class="bg-home d-flex bg-light align-items-center" >
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7 col-md-10 text-center">
                        <img src="assets/images/error.svg" class="img-fluid" alt="">
                        <h3 class="mb-4">Looks like your link is not available.</h3>
                        <a href="home" class="btn btn-primary mt-2">Back to home page</a>
                    </div>
                </div>
            </div>
        </section>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.sticky.js"></script>
        <script src="assets/js/counter.js"></script>
        <script src="assets/js/custom.js"></script>
    </body>
</html>
