<%-- 
    Document   : UserBasicInformation
    Created on : Feb 18, 2023, 11:00:26 PM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../admin-layout/admin-head.jsp" %>

<!--<h2 class="text-center mb-5"><b>BASIC INFORMATION</b></h2>-->
<div class="mt-5 d-flex info-line">
    <div class="info-img-box">

    </div>
    <div>
        <div class="input-group info-input-line mx-3">
            <!--<label for="user-name" class="input-group-text"><i class="fa-solid fa-user"></i></label>-->
            <input type="text" name="name" class="form-control" id="user-name" placeholder="Full name"> 
        </div>
        <div class="input-group info-input-line mx-3 mt-3">
            <!--<label for="user-name" class="input-group-text"><i class="fa-regular fa-id-card"></i></label>-->
            <input type="text" name="ID" class="form-control" id="user-id" placeholder="ID" readonly="" value="${id}">  
        </div>
    </div>

</div>

<div class="mt-3 d-flex info-line">
    <div class="w-50">
        <span id="addon-wrapping">Account:</span>
        <input type="text" name="account" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
    </div>
    <div class="mx-5">
        <div>Gender:</div>
        <select name="gender" id="user-gender">
            <option value="1">Male</option>
            <option value="0">Female</option>
        </select>
    </div>
</div>
<div class="mt-3 info-line d-flex">
    <div class="w-50">
        <label for="email">Email:</label> <br>
        <input type="email" name="email" class="form-control">
    </div>
    <div class="mx-5">
        <div>Day of birth:</div>
        <input type="date" name="dob" class="form-control">
    </div>
</div>

<div class="mt-3 d-flex info-line">
    <div class="w-50">
        <span id="addon-wrapping">Phone:</span>
        <input type="number" name="phone" class="form-control" placeholder="Phone">
    </div>
    <div class="mx-5">
        <div>Role:</div>
        <select name="role" id="user-role" onchange="deepInformation()">
            <option value="admin">Admin</option>
            <option value="doctor">Doctor</option>
            <option value="casher">Casher</option>
            <option value="">Customer</option>
        </select>
    </div>
</div>