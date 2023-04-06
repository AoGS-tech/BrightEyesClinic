<%-- 
    Document   : AdminDashboard
    Created on : Feb 10, 2023, 7:50:47 PM
    Author     : Ao
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <style>

        #dashboard-left {
            width: 65%;
        }
        #rate-customer {
            width: 100%;
            height: 400px;
            /*border: 1px solid red;*/
        }

        #revenue {
            width: 100%;
            height: 480px;
            border: 1px solid red;
        }

        #dashboard-right {
            width: 33%;
            margin-left: 2%;
            height: 930px;
            /*border: 1px solid red;*/
        }

        #revenue-rate-box {
            width: 100%;
            height: 450px;
            border: 1px solid blue;
        }
        #rate-of-revenue {
            width: 100%;

        }
    </style>
    <body onload="getPositionNavBar(0)">
        <form action="adminDashboard" class="vw-100 vh-100 d-flex" method="post">
            <!--            set position for not select case-->
            <input name="setPosition" type="text" value="1" class="d-none">
            <!--            --------------------------------------------------------------------->
            <%@include file="../admin-layout/admin-navbar.jsp" %>
            <div class="main-view main-view-content justify-content-between d-flex">
                
                <div id="dashboard-left">
                    <div class="justify-content-between card">
                        <div class="d-flex justify-content-between">
                            <div class=""><b>Date report:</b> </div>
                            <input type="date" name="date" class="form-control w-75" value="${date}">
                        </div>
                        <div id="rate-customer">
                            <canvas id="rate-customer-chart"></canvas>
                        </div>

                    </div>
                    <div id="revenue" class="mt-5">
                        <h3 class="text-center mb-3">REVENUE REPORT</h3>
                        <div class="text-center">Total: ${totalRevenue}</div>
                        <input type="text" name="getDays" id="get-all-days" class="d-none" value="${totalDaysOfCurrentMonth}">
                        <canvas id="month-revenue"></canvas>
                    </div>
                </div>

                <div id="dashboard-right">
                    <div id="revenue-rate-box">
                        <canvas id="rate-of-revenue"></canvas>
                        <div class="text-center fs-2">Rate of Revenue</div>
                    </div>
                </div>
            </div>
        </form>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
        var dataLabels = [<c:forEach items="${labelsCustomerBooking}" var="item" varStatus="loop">"${item}"<c:if test="${!loop.last}">, </c:if></c:forEach>]; 
        var dataCustomerBooking = [<c:forEach items="${dataCustomerBooking}" var="item" varStatus="loop">${item}<c:if test="${!loop.last}">, </c:if></c:forEach>]; 
        const rateCustomerChart = document.getElementById("rate-customer-chart");
        new Chart(rateCustomerChart, {
            type: 'line',
            data: {
                labels: dataLabels,
                datasets: [{
                        label: 'Rate of customer in hours',
                        data: dataCustomerBooking,
                        fill: false,
                        borderColor: 'rgb(75, 192, 192)',
                        tension: 0.1
                    }]
            }
        });


        const monthRevenue = document.getElementById("month-revenue");
        var allDays = document.getElementById('get-all-days').value;
        console.log('Total days of month: ' + allDays);

        var labels = [];

        for (var i = 1; i <= allDays; i++) {
            labels.push(i + "");
        }

        console.log(labels);


        new Chart(monthRevenue, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                        label: 'Revenue of day',
                        data: [12, 19, 3, 5, 2, 3],
                        borderWidth: 1
                    }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        const revenueRate = document.getElementById('rate-of-revenue');

        new Chart(revenueRate, {
            type: 'doughnut',
            data: {
                labels: [
                    'Treatment',
                    'Glasses Sale',
                    'Other'
                ],
                datasets: [{
                        label: 'My First Dataset',
                        data: [300, 50, 100],
                        backgroundColor: [
                            'rgb(255, 99, 132)',
                            'rgb(54, 162, 235)',
                            'rgb(255, 205, 86)'
                        ],
                        hoverOffset: 4
                    }]
            }
        });
        </script>
    </body>
</html>
