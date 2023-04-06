<%-- 
    Document   : AddNewGlass
    Created on : Mar 9, 2023, 12:11:49 AM
    Author     : Ao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../admin-layout/admin-head.jsp" %>
    <body class="row justify-content-center">
        <form action="addGlass" method="post" class="col-sm-5 card card-body mt-5" style="background-color: #5bc1ac82; box-shadow: 0px 0px 13px 0px;">
            <h2 class="text-center">Create glass information</h2>
            <div class="text-center" style="color: red;">${message}</div>
            <!--            <div>
                            <label>Glass ID:</label>
                            <input type="text" name="glassID" value="${glassID}" class="form-control">
                        </div>-->
            <div>
                <label>Glass Name:</label>
                <input type="text" name="glassName" class="form-control" required="" value="${glassName}" minlength="3" maxlength="20">
            </div>
            <div>
                <label>Glass Color:</label>
                <input type="text" name="glassColor" class="form-control" required="" value="${glassColor}" minlength="3" maxlength="15">
            </div>
            <div>
                <label>Glass Gender:</label>
                <select name="gender" class="form-control" value="${gender}">
                    <option value="1" <c:if test="${gender == '1'}">selected=""</c:if> >Male</option>
                    <option value="0" <c:if test="${gender == '0'}">selected=""</c:if>>Female</option>
                    </select>
                </div>
                <div>
                    <label>Glass Material:</label>
                    <input type="text" name="glassMaterial" class="form-control" required="" value="${glassMaterial}" minlength="3" maxlength="20">
            </div>
            <div>
                <label>Glass Style:</label>
                <input type="text" name="glassStyles" class="form-control" required="" value="${glassStyles}" minlength="3" maxlength="20">
            </div>
            <div>
                <label>Glass Image:</label>
                <input type="text" name="glassImage" class="form-control" required="" value="${glassImage}" maxlength="100">
            </div>
            <div>
                <label>Price:</label>
                <input type="text" name="glassPrice" class="form-control" required="" value="${glassPrice}" minlength="3" maxlength="100">
            </div>
            <div>
                <label>Quantity:</label>
                <input type="number" name="glassQuantity" class="form-control" required="" value="${glassQuantity}" minlength="0">
            </div>
            <div class="row justify-content-center">
                ${pageType}
                <c:if test="${pageType == null || pageType == 'add'}">
                    <input type="submit" name="saveAsNew" value="ADD GLASS" class="btn btn-warning mt-5 mr-3">
                </c:if>
                <c:if test="${pageType == 'update'}">
                    <input type="submit" name="saveAsUpdate" value="UPDATE GLASS" class="btn btn-warning mt-5">
                </c:if>

            </div>
        </form>
    </body>
</html>
