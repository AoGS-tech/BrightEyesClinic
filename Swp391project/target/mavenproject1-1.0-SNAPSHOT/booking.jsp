<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="layout/head.jsp"/>
    <head>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="assets/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
    </head>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <section class="bg-half-170 d-table w-100 bg-light">
            <div class="container">
                <div class="row mt-5 justify-content-center">
                    <div class="col-12">
                        <div class="section-title text-center">
                            <h3 class="sub-title mb-4">Book Consulting</h3>
                            <p class="para-desc mx-auto text-muted">Great doctor if you need your family member to get effective immediate assistance, emergency treatment or a simple consultation.</p>


                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="position-relative">
            <div class="shape overflow-hidden text-white">
                <svg viewBox="0 0 2880 48" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M0 48H1437.5H2880V0H2160C1442.5 52 720 0 720 0H0V48Z" fill="currentColor"></path>
                </svg>
            </div>
        </div>

        <section class="section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card border-0 shadow rounded overflow-hidden">
                            <div class="tab-content p-4" id="pills-tabContent">
                                <form action="booking" method="get" onsubmit="return validateForm();">
                                    <div class="row">
                                        <c:if test="${success ne null}" >
                                            <p style="color:#00ccff;font-size: 20px">${success}</p>
                                        </c:if>
                                        <div class="p-6">
                                            <h6 class="mb-0">Patient information</h6>
                                        </div>
                                        <br><br>
                                        <div class="col-lg-6">
                                            <div class="mb-3">
                                                <label class="form-label" id="name">Name</label>
                                                <c:if test="${checkName ne null}" >
                                                    <p style="color:red;font-size: 13px">${checkName}</p>
                                                </c:if>
                                                <input name="name" id="name" value="${fullname}" class="form-control" required >
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="mb-3">
                                                <label class="form-label" >Phone</label>
                                                <c:if test="${checkPhone ne null}" >
                                                    <p style="color:red;font-size: 13px">${checkPhone}</p>
                                                </c:if>
                                                <input type="text"name="phone" value="${phoneLg}" minlength="10" maxlength="10" validate-input class="form-control" required>
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="mb-3">
                                                <label class="form-label" >Email</label>
                                                <c:if test="${checkEmail ne null}" >
                                                    <p style="color:red;font-size: 13px">${checkEmail}</p>
                                                </c:if>
                                                <input type="text" name="email" id="email" value="${emailLg}" class="form-control">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="p-6">
                                            <h6 class="mb-0">Appointment information</h6>
                                        </div>
                                        <br><br>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label" for="dateInput">Select a date:</label>
                                                <c:if test="${checkDate ne null}" >
                                                    <p style="color:red;font-size: 13px">${checkDate}</p>
                                                </c:if>
                                                <input type="date" id="dateInput" class="flatpickr flatpickr-input form-control" name="dateInput" onchange="checkDateInput()">

                                            </div>


                                        </div>

                                        <div class="col-md-6">

                                            <div class="mb-3">
                                                <label class="form-label">Time</label>
                                                <c:if test="${checkTime ne null}" >
                                                    <p style="color:red;font-size: 13px">${checkTime}</p>
                                                </c:if>
                                                <select required="" name="time" class="form-control department-name select2input">
                                                    <option value="null" checked>Choose time</option>
                                                    <option value="7:30">7:30 am</option>
                                                   
                                                    <option value="9:00">9:00 am</option>
                                                    
                                                    <option value="11:00">11:00 am</option>
                                                    <option value="14:00">14:00 pm</option>
                                                    <option value="15:30">15:30 pm</option>
                                                    
                                                    <option value="17:00">17:00 pm</option>
                                                </select>
                                            </div>
                                        </div><!--end col-->

                                        <div class="col-lg-12">
                                            <div class="mb-3">
                                                <label class="form-label">Medical information<span class="text-danger">*</span></label>
                                                <textarea required="" name="description" id="comments2" rows="4" class="form-control"></textarea>
                                            </div>
                                        </div><!--end col-->



                                        <div class="col-lg-12">

                                            <div class="d-grid gap-2 col-6 mx-auto">
                                                <button type="submit" class="btn btn-primary" type="button">Đặt lịch</button>

                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>




        <script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/bootstrap/js/popper.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/daterangepicker/moment.min.js"></script>
        <script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="assets/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="assets/js/main.js"></script>
        <script>
        </script>

    </body>

</html>