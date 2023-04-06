<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <nav class="navbar navbar-expand-lg bg-light shadow-lg">
        <div class="container">

            <img src="assets/images/logo.png" class="logo img-fluid col-lg-1" alt="">

                <ul class="navbar-nav ms-auto col-lg-8">
                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="home">Home</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            About
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="Overview.jsp">Overview</a>
                            <a class="dropdown-item" href="#">Staffs</a>
                            <a class="dropdown-item" href="getService">Service</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Machine System</a>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="glasses?paging=1">Glasses</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="news">News</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="#">Contact</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link click-scroll" href="FAQ.jsp">FAQ</a>
                    </li>
                </ul>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item ">
                    <a style="font-size: 30px" class="nav-link click-scroll " href="show"><ion-icon name="cart-outline"></ion-icon><span class="position-absolute translate-middle p-2"><p>${sessionScope.size}</p></span></a>
                    
                </li>

                <c:if test="${sessionScope.id == null}">
                    <li class="nav-item ">
                        <a class="nav-link click-scroll" href="loginuser"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
                                <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                            </svg><br>Login</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.id != null}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                            </svg>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="profile">Profile</a>
                                <a class="dropdown-item" href="changePass.jsp">Change Password</a>
            

                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="logout">Log out</a>

                        </div>
                    </li>
                </c:if>

            </ul>
        </div>
        <div class="navbar-nav book " style="background-color: pink;">
            <a class="nav-link text-center"  href="booking.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-calendar-event" viewBox="0 0 16 16">
                    <path d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>
                    <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                </svg><br>Book Consulting</a>

        </div>
    </nav>