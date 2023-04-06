<%-- 
    Document   : newjsp
    Created on : Feb 5, 2023, 6:14:35 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .news-container {
  display: flex;
  align-items: center;
  margin: 50px 0;
}

.news-image {
  width: 30%;
  height: auto;
  margin-right: 20px;
}

.news-content {
  width: 70%;
  text-align: left;
}

.news-title {
  font-size: 22px;
  margin-top: 10px;
}

.news-description {
  font-size: 16px;
  margin-top: 10px;
  margin-bottom: 10px;
}

.news-link {
  font-size: 16px;
  text-decoration: none;
  color: blue;
  margin-top: 10px;
}

        </style>
    </head>
    <body>
        <div class="news-container">
  <img src="news-image.jpg" alt="News Image" class="news-image">
  <div class="news-content">
    <h2 class="news-title">News Title</h2>
    <p class="news-description">News Description</p>
    <a href="#" class="news-link">Read More</a>
  </div>
</div>
    </body>
</html>
