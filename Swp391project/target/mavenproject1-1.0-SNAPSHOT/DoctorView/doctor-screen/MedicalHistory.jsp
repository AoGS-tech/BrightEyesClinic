<%-- 
    Document   : ListWattingPatient
    Created on : Mar 6, 2023, 10:47:17 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../doctor-layout/doctor-head.jsp" %>
    <header> <script>
        function redirectToServlet() {
            const selectedOption = document.getElementById("selectOption").value;
            if (selectedOption !== "") {
                window.location.href = "ChooseOn_Of?option=" + selectedOption;
            }
        }
        </script>
        <style>
            .sort-icon {
                width: 25px;
                height: 25px;
                border-radius: 50%;
                background-color: #5a6f80;
                color: white;
                text-align: center;
                line-height: 25px;
                cursor: pointer;
            }

            #table-head {
                background-color: #5bc1ac;
            }

            #search-staff-content {
                height: 40px;
            }

            #staff-search-btn {
                width: 70px;
                height: 40px;
                outline: none;
                border: 1px solid black;
            }

            /*------------------*/
            .cssbuttons-io-button {
                display: flex;
                align-items: center;
                font-family: inherit;
                font-weight: 500;
                font-size: 16px;
                padding: 0.7em 1.4em 0.7em 1.1em;
                color: white;
                background: #ad5389;
                background: linear-gradient(0deg, rgba(20,167,62,1) 0%, rgba(102,247,113,1) 100%);
                border: none;
                box-shadow: 0 0.7em 1.5em -0.5em #14a73e98;
                letter-spacing: 0.05em;
                border-radius: 20em;
            }

            .cssbuttons-io-button svg {
                margin-right: 6px;
            }

            .cssbuttons-io-button:hover {
                box-shadow: 0 0.5em 1.5em -0.5em #14a73e98;
            }

            .cssbuttons-io-button:active {
                box-shadow: 0 0.3em 1em -0.5em #14a73e98;
            }

            /*--------------------------------------------*/
            select {
                /* Reset Select */
                appearance: none;
                outline: 0;
                border: 0;
                box-shadow: none;
                /* Personalize */
                flex: 1;
                padding: 0 1em;
                color: white;
                background-color: #5a6f80;
                background-image: none;
                cursor: pointer;
            }
            /* Remove IE arrow */
            select::-ms-expand {
                display: none;
            }
            /* Custom Select wrapper */
            .select {
                position: relative;
                display: flex;
                width: 10em;
                height: 3em;
                border-radius: .25em;
                overflow: hidden;
            }
            /* Arrow */
            .select::after {
                content: '\25BC';
                position: absolute;
                top: 0;
                right: 0;
                padding: 1em;
                background-color: #5a6f80;
                transition: .25s all ease;
                pointer-events: none;
            }
            /* Transition */
            .select:hover::after {
                color: #f39c12;
            }
        </style>
    </header>
    <body>
        <form action="manageCustomer" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->           
            <!--            --------------------------------------------------------------------->
            <%@include file="../doctor-layout/doctor-navbar.jsp" %>
            <div class="main-view main-view-content">
                <br><br>
                <div class="d-flex justify-content-between header-staff-list align-items-center mb-4">
                    <h2 class="text-center w-100">HISTORY MEDICAL </h2>
                </div>
                <br>
                <% int count = 0;%>
                <!-- Modal -->
                <table class="table table-bordered">
                    <thead id="table-head">
                        <tr>
                            <th>No</th>
                            <th>
                                <div class="d-flex justify-content-between">
                                    <div>Name</div>                                   
                                </div>
                            </th>


                            <th>ID Card</th>
                            <th>Symptom</th>
                            <th>Conclude</th>
                            <th>Medicine</th>
                            <th>Doctor</th>
                            <th>Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                          <c:forEach items="${listPatientHistory}" var="c">
                                <tr>
                                    <th><% count++;
                                    out.print(count);%></th>
                                    <th>${c.getUser().getFullname()}</th> 
                                    <th>${c.getIdcard()}</th>
                                    <th>${c.getSymptom()}</th>
                                    <th>${c.getConclude()}</th>
                                    <th>${c.getMedicine()}</th>
                                    <th>${c.getDoctorName()}</th>
                                    <th>${c.getMedicalDate()}</th>
                                    
                                </tr>
                           
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html>