<%-- 
    Document   : MedicalRecord
    Created on : Mar 7, 2023, 9:52:37 AM
    Author     : nguye
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../doctor-layout/doctor-head.jsp" %>

    <head>
        
    </head>
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



        .dialog p {
            padding: 10px;
            font-size: 16px;
            line-height: 1.5;

        }

        .dialog .close {
            position: absolute;
            top: 5px;
            right: 10px;
            font-size: 24px;
            font-weight: bold;
            color: #aaaaaa;
            cursor: pointer;
        }

    </style>
    <body>
        <form action="medicalRecord" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->           
            <!--            --------------------------------------------------------------------->
            <%@include file="../doctor-layout/doctor-navbar.jsp" %>
            <div class="main-view main-view-content">
                <br><br>

                <br>
                <% int count = 0;%>
                <!-- Modal -->

                <c:forEach items="${listInformationPatient}" var="c">

                    <form action="medicalRecord" method="POST">
                        <div class="row">

                            <div class=" col-md-3"></div>

                            <div class=" col-md-6">
                                <h1 style="margin-bottom: 30px;display: flex; justify-content: center">MEDICAL REPORT FORM</h1>
                                <div style="display: flex; justify-content: space-between">
                                    <p>Patient's Full Name<input style="width: 250px" name="namePatient" type="text" value="${c.getUser().getFullname()} " readonly></p> 
                                    <p>Date of Birth<input type="text" name ="dobPatient" value="${c.getUser().getBod()} "readonly ></p>
                                </div>
                                <div style="display: flex; justify-content: space-between">
                                    <p>Phone Number<input style="width: 250px" name="phonePatient" type="text" value="${c.getUser().getPhonenumber()} "readonly></p> 

                                    <p>Gender:<input type="text" name ="emailPatient" value="${c.getUser().getGender()} "readonly></p>
                                </div>
                                <p style="margin-top: 20px">Address<input type="text" name="addressPatient" style="width: 100%" value="${c.getUser().getAddress()} "readonly></p>                                
                                <p style="margin-top: 20px">Email<input type="text" name="addressPatient" style="width: 100%" value="${c.getUser().getEmail()} "readonly></p>
                                <div style="display: flex; justify-content: space-between">


                                </div> 


                                <p>Symptom<br><input type="text" name ="syptom" value="${c.getSymptom()}  " style="height: 100px;width: 100%"  readonly></p>

                                <p>Conclude </p>
                                <textarea style="width: 100%" name="conclude" rows="5" cols="30"></textarea>
                                <p>Medicine </p>
                                <textarea style="width: 100%" name="medicine" rows="5" cols="30"></textarea>

                                   
                                <div style="margin: 20px;display: flex;justify-content: center">
                                   
                                    <input style="justify-content: center" type="submit" value="Submit" onclick="return confirm('Are you sure you want to submit this form?')" ></div>
                                    
                            </div>
                            <div class=" col-md-3"></div>
                        </div>
                    </c:forEach>        



            </div>
        </form>      
    </body>
</html>
