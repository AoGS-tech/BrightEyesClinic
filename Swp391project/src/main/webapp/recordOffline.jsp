<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
      
        <link rel="stylesheet" type="text/css" href="assets/css/main1.css">
        <!--===============================================================================================-->


    </head>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <div class="limiter" >
            <form class="login100-form validate-form" action="record" method="post">


                <div class="row">
                    <div class=" col-md-3"></div>
                    <div class=" col-md-6">

                        <h1 style="margin-bottom: 30px;display: flex; justify-content: center">MEDICAL REPORT FORM</h1>
                        <div style="display: flex; justify-content: space-between">
                            <div class=" validate-input m-b-13" data-validate="Address is required">                         
                                Patient's Name <input class="input100" type="text" name="patientName" placeholder="Type Patient's name">                            
                            </div> 
                           <div class=" validate-input m-b-13" data-validate="Date of birth is required">  
                               <c:if test="${check ne null}" >
                                            <p style="color:#00ccff;font-size: 20px">${check}</p>
                                        </c:if>
                               Date of birth <input  class="input100" type="date" name="bod" placeholder="">                            
                            </div>
                            

                        </div>

                         <div class=" validate-input m-b-13" data-validate="Address is required">                         
                                Address <input class="input100" type="text" name="address" placeholder="Type your address">                            
                            </div>
                            
                        <div style="display: flex; justify-content: space-between">
                           <div class=" validate-input m-b-13" data-validate="Phone is required">                         
                               Phone <input class="input100" type="text" name="phone" placeholder="Type your Phone" minlength="10" maxlength="10">                            
                            </div>
                            
                           
                            <div class=" validate-input m-b-13" data-validate="Email is required">                         
                                Email <input  class="input100" type="text" name="email" placeholder="Type your Email">  
                              
                            </div>
                            <div style="">
                                <div> Gender:</div>
                            <select style="height: 35px; width: 100px" name="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                            </div>
                        </div>
                         
                            
                         <div class=" validate-input m-b-13" data-validate="Symptom is required">                         
                               Symptom  <textarea style="width: 100%" name="symptom" rows="5" cols="30"></textarea>

                        <div  style="margin-top: 20px;display: flex;justify-content: space-between">
                            <div class=" validate-input m-b-13" data-validate="ID Card is required">                         
                               ID Card <input class="input100" type="text" name="idcard" placeholder="ID Card" minlength="12" maxlength="12" >                            
                            </div>
                            <div>
                            Choose doctor:
                            <select style="height: 35px; width: 100%;" name="doctor">
                                <c:forEach items="${listrole}" var="l">
                                    <option>${l.getFullname()}</option>
                                </c:forEach>
                            </select>
                             </div>
                          
                        </div>
                               <div class="container-login100-form-btn" style="margin-top: 30px; margin-bottom: 30px">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>

                                <input type="submit" name="AddRecord" value="Add Record" class="login100-form-btn" style="background-color: #5bc1ac" >
                            </div>
                        </div>
                        <!--                    <div style="margin: 20px;display: flex;justify-content: center">
                                                <input style="justify-content: center" type="submit" value="Add Report"></div>-->
                    </div>
                    <div class=" col-md-3"></div>
                </div></div>

            </form>
        </div>

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
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
    </body>
</html>