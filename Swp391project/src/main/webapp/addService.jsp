<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Service</title>
    </head>
    <body>
        <h1>Add Service</h1>
        <form action="addServiceController" method="post">
            <label for="serviceName">Service Name:</label>
            <input type="text" id="serviceName" name="serviceName"><br><br>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description"><br><br>
            <label for="price">Price:</label>
            <input type="number" id="price" name="price"><br><br>
            <input type="submit" value="Add Service">
        </form>
    </body>
</html>