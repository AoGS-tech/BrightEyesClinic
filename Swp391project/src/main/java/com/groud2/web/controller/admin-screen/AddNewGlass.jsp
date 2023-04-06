<%-- 
    Document   : AddNewGlass
    Created on : Mar 9, 2023, 12:11:49 AM
    Author     : Ao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <body class="row justify-content-center">
        <form action="addGlass" method="post" class="col-sm-5 card card-body mt-5" style="background-color: #5bc1ac82; box-shadow: 0px 0px 13px 0px;">
            <h2 class="text-center">Create glass information</h2>
            <div class="text-center" style="color: red;">${message}</div>
            <div>
                <label>Glass ID:</label>
                <input type="text" name="glassID" value="${glassID}" class="form-control">
            </div>
            <div>
                <label>Glass Name:</label>
                <input type="text" name="glassName" class="form-control" required="" value="${glassName}">
            </div>
            <div>
                <label>Glass Color:</label>
                <input type="text" name="glassColor" class="form-control" required="" value="${glassColor}">
            </div>
            <div>
                <label>Glass Gender:</label>
                <select name="gender" class="form-control" value="${gender}">
                    <option value="1">Male</option>
                    <option value="0">Female</option>
                </select>
            </div>
            <div>
                <label>Glass Material:</label>
                <input type="text" name="glassMaterial" class="form-control" required="" value="${glassMaterial}">
            </div>
            <div>
                <label>Glass Style:</label>
                <input type="text" name="glassStyles" class="form-control" required="" value="${glassStyles}">
            </div>
            <div>
                <label>Glass Image:</label>
                <input type="text" name="glassImage" class="form-control" required="" value="${glassImage}">
            </div>
            <div>
                <label>Price:</label>
                <input type="text" name="glassPrice" class="form-control" required="" value="${glassPrice}">
            </div>
            <div>
                <label>Quantity:</label>
                <input type="text" name="glassQuantity" class="form-control" required="" value="${glassQuantity}">
            </div>
            <div class="row justify-content-center">
                <input type="submit" name="saveAsNew" value="SAVE AS NEW" class="btn btn-warning mt-5 mr-3">
                <input type="submit" name="saveAsUpdate" value="SAVE AS UPDATE" class="btn btn-warning mt-5">
            </div>
        </form>
    </body>
</html>
