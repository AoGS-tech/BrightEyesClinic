<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>

        <main>
            <c:if test="${requestScope.nofi!=null}">
                <div class="text-center" style="background-color: #198754;color:white">
                    <h3>${requestScope.nofi}</h3>
                </div>
            </c:if>
            <section class="hero-section hero-section-full-height">
                <div class="container-fluid">
                    <div class="row">

                        <div class="col-lg-12 col-12 p-0">
                            <div id="hero-slide" class="carousel carousel-fade slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        
                                        <img src="assets/images/healthcare-telemedicine-banner.jpg" class="carousel-image img-fluid"  alt=""/>
                                        <div class="carousel-caption d-flex flex-column justify-content-end">
                                            <h1>Take care</h1>

                                            <p>Dedicated, professional</p>
                                        </div>
                                    </div>

                                    <div class="carousel-item">
                                        <img src="assets/images/slide/volunteer-selecting-organizing-clothes-donations-charity.jpg" class="carousel-image img-fluid" alt="...">

                                        <div class="carousel-caption d-flex flex-column justify-content-end">
                                            <h1>Staff</h1>
                                            
                                            <p>Lots of experience</p>
                                        </div>
                                    </div>


                                </div>

                                <button class="carousel-control-prev" type="button" data-bs-target="#hero-slide" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>

                                <button class="carousel-control-next" type="button" data-bs-target="#hero-slide" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>

                    </div>
                </div>
            </section>


            <section class="section-padding">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-10 col-12 text-center mx-auto">
                            <h2 class="mb-5">Welcome to Bright eyes</h2>
                        </div>

                        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
                            <div class="d-flex justify-content-center align-items-center">
                                <a href="#" class="d-block">
                                    <img src="assets/images/icons/hands.png" class="featured-block-image img-fluid" alt="">

                                    <p class="featured-block-text">Become a <strong>member</strong></p>
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 mb-md-4">
                            <div class="d-flex justify-content-center align-items-center">
                                <a href="#" class="d-block">
                                    <img src="assets/images/icons/heart.png" class="featured-block-image img-fluid" alt="">

                                    <p class="featured-block-text"><strong>Share</strong> knowledge</p>
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 mb-md-4">
                            <div class="d-flex justify-content-center align-items-center">
                                <a href="#" class="d-block">
                                    <img src="assets/images/icons/receive.png" class="featured-block-image img-fluid" alt="">

                                    <p class="featured-block-text"> <strong>Corneal donation</strong></p>
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0">
                            <div class=" d-flex justify-content-center align-items-center">
                                <a href="#" class="d-block">
                                    <img src="assets/images/icons/scholarship.png" class="featured-block-image img-fluid" alt="">

                                    <p class="featured-block-text"><strong>Learn</strong> eye knowledge</p>
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            <!--            <section class="section-padding section-bg" id="section_2">
                            <div class="container">
                                <div class="row">
            
                                    <div class="col-lg-6 col-12 mb-5 mb-lg-0">
                                        <img src="assets/images/group-people-volunteering-foodbank-poor-people.jpg" class="custom-text-box-image img-fluid" alt="">
                                    </div>
            
                                    <div class="col-lg-6 col-12">
                                        <div class="custom-text-box">
            <h2 class="mb-2">Our Story</h2>
            
                                            <h5 class="mb-3">Bright eyes,Eye Clinic</h5>
            
                                            <p class="mb-0">Chưa biết viết gì</p>
                                        </div>
            
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-12">
                                                <div class="custom-text-box mb-lg-0">
                                                    <h5 class="mb-3">Our Mission</h5>
            
                                                    <p>Sed leo nisl, posuere at molestie ac, suscipit auctor quis metus</p>
            
                                                    <ul class="custom-list mt-2">
                                                        <li class="custom-list-item d-flex">
                                                            <i class="bi-check custom-text-box-icon me-2"></i>
                                                            Charity Theme
                                                        </li>
            
                                                        <li class="custom-list-item d-flex">
                                                            <i class="bi-check custom-text-box-icon me-2"></i>
                                                            Semantic HTML
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
            
                                            <div class="col-lg-6 col-md-6 col-12">
                                                <div class="custom-text-box d-flex flex-wrap d-lg-block mb-lg-0">
                                                    <div class="counter-thumb">
                                                        <div class="d-flex">
                                                            
                                                            <span class="counter-number-text">Founded</span>
                                                        </div>
            
                                                        <span class="counter-text">16/06/2021</span>
                                                    </div>
            
                                                    <div class="counter-thumb mt-4">
                                                        <div class="d-flex">
                                                            <span class="counter-number" data-from="1" data-to="120" data-speed="1000"></span>
                                                            <span class="counter-number-text">B</span>
                                                        </div>
            
                                                        <span class="counter-text">Donations</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
            
                                </div>
                            </div>
                        </section>-->


            <section class="about-section section-padding">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-6 col-md-5 col-12">
                            <img src="assets/nhat.png" class="about-image ms-lg-auto bg-light shadow-lg img-fluid" alt="">
                        </div>

                        <div class="col-lg-5 col-md-7 col-12">
                            <div class="custom-text-block">
                                <h2 class="mb-0"> Nguyễn Đình Nhật</h2>

                                <p class="text-muted mb-lg-4 mb-md-4">Patient</p>

                                <p>This clinic is very good, the service is very enthusiastic and attentive</p>

                                <ul class="social-icon mt-4">
                                    <li class="social-icon-item">
                                        <a href="#" class="social-icon-link bi-twitter"></a>
                                    </li>

                                    <li class="social-icon-item">
                                        <a href="#" class="social-icon-link bi-facebook"></a>
                                    </li>

                                    <li class="social-icon-item">
                                        <a href="#" class="social-icon-link bi-instagram"></a>
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            <section class="cta-section section-padding section-bg">
                <div class="container">
                    <div class="row justify-content-center align-items-center">

                        <div class="col-lg-5 col-12 ms-auto">
                            <h2 class="mb-0">Make an impact. <br> Help more many people.</h2>
                        </div>

                        <div class="col-lg-5 col-12">


                            <a href="#section_4" class="custom-btn btn smoothscroll">Become a member</a>
                        </div>

                    </div>
                </div>
            </section>


            <section class="section-padding">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12 col-12 text-center mb-4">
                            <h2>Glasses</h2>
                        </div>

                        <c:forEach items="${listGlasses}" var="item" end="2">
                            <div class="col-lg-4 col-md-6 col-3 mb-4 ">
                                <div class="custom-block-wrap">
                                    <img src="${item.getImage()}" class="custom-block-image img-fluid" alt="">

                                    <div class="custom-block" >
                                        <div class="custom-block-body">
                                            <h5 >${item.getGlassName()}</h5>

                                            <p>Color :${item.getColor()} </p>

                                            <p>Gender :${item.getGender()} </p>
                                            <p>Material :${item.getMaterial()} </p>

                                            <p>Style :${item.getStyle()} </p>
                                            <div class="d-flex align-items-center my-2">
                                                <p class="ms-auto mb-0">
                                                    <strong>Goal:</strong>
                                                    <b>$${item.getPrice()}</b>
                                                </p>
                                            </div>
                                        </div>

                                        <a href="#" class="custom-btn  btn-lg text-center" > <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                            </svg> Add to card </a>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                    </div>
                </div>
            </section>



            <section class="news-section section-padding" id="section_5">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-12 col-12 mb-5">
                            <h2>Eye knowledge</h2>
                        </div>

                        <div class="col-lg-7 col-12">
                            <div class="news-block">
                                <div class="news-block-top">
                                    <a href="#">
                                        <img src="assets/images/news/medium-shot-volunteers-with-clothing-donations.jpg" class="news-image img-fluid" alt="">
                                    </a>

                                    <div class="news-category-block">
                                        <a href="#" class="category-block-link">
                                            Knowledge
                                        </a>


                                    </div>
                                </div>

                                <div class="news-block-info">
                                    <div class="d-flex mt-2">
                                        <div class="news-block-date">
                                            <p>
                                                <i class="bi-calendar4 custom-icon me-1"></i>
                                                October 12, 2021
                                            </p>
                                        </div>

                                        <div class="news-block-author mx-5">
                                            <p>
                                                <i class="bi-person custom-icon me-1"></i>
                                                By Admin
                                            </p>
                                        </div>

                                        <div class="news-block-comment">
                                            <p>
                                                <i class="bi-chat-left custom-icon me-1"></i>
                                                Comments
                                            </p>
                                        </div>
                                    </div>

                                    <div class="news-block-title mb-2">
                                        <h4><a href="#" class="news-block-title-link"> The mechanism of action of the eye</a></h4>
                                    </div>

                                    <div class="news-block-body">
                                        <p></p>
                                    </div>
                                </div>
                            </div>

                                                        <div class="news-block mt-3">
                                                            <div class="news-block-top">
                                                                <a href="#">
                                                                    <img src="assets/images/news/medium-shot-people-collecting-foodstuff.jpg" class="news-image img-fluid" alt="">
                                                                </a>
                            
                                                                <div class="news-category-block">
                                                                    <a href="#" class="category-block-link">
                                                                        Food,
                                                                    </a>
                            
                                                                    <a href="#" class="category-block-link">
                                                                        Donation,
                                                                    </a>
                            
                                                                    <a href="#" class="category-block-link">
                                                                        Caring
                                                                    </a>
                                                                </div>
                                                            </div>

                                                            <div class="news-block-info">
                                                                <div class="d-flex mt-2">
                                                                    <div class="news-block-date">
                                                                        <p>
                                                                            <i class="bi-calendar4 custom-icon me-1"></i>
                                                                            October 20, 2036
                                                                        </p>
                                                                    </div>
                            <div class="news-block-author mx-5">
                                                                        <p>
                                                                            <i class="bi-person custom-icon me-1"></i>
                                                                            By Admin
                                                                        </p>
                                                                    </div>
                            
                                                                    <div class="news-block-comment">
                                                                        <p>
                                                                            <i class="bi-chat-left custom-icon me-1"></i>
                                                                            35 Comments
                                                                        </p>
                                                                    </div>
                                                                </div>
                            
                                                                <div class="news-block-title mb-2">
                                                                    <h4><a href="#" class="news-block-title-link">Food donation area</a></h4>
                                                                </div>
                            
                                                                <div class="news-block-body">
                                                                    <p>Sed leo nisl, posuere at molestie ac, suscipit auctor mauris. Etiam quis metus elementum, tempor risus vel, condimentum orci</p>
                                                                </div>
                                                            </div>
                                                        </div>
                        </div>

                        <div class="col-lg-4 col-12 mx-auto">
                            <form class="custom-form search-form" action="#" method="get" role="form">
                                <input name="search" type="search" class="form-control" id="search" placeholder="Search" aria-label="Search">

                                <button type="submit" class="form-control">
                                    <i class="bi-search"></i>
                                </button>
                            </form>

                            <h5 class="mt-5 mb-3">Recent news</h5>

                            <div class="news-block news-block-two-col d-flex mt-4">
                                <div class="news-block-two-col-image-wrap">
                                    <a href="#">
                                        <img src="assets/images/news/africa-humanitarian-aid-doctor.jpg" class="news-image img-fluid" alt="">
                                    </a>
                                </div>

                                <div class="news-block-two-col-info">
                                    <div class="news-block-title mb-2">
                                        <h6><a href="#" class="news-block-title-link">Food donation area</a></h6>
                                    </div>

                                    <div class="news-block-date">
                                        <p>
                                            <i class="bi-calendar4 custom-icon me-1"></i>
                                            October 16, 2036
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div class="news-block news-block-two-col d-flex mt-4">
                                <div class="news-block-two-col-image-wrap">
                                    <a href="#">
                                        <img src="assets/images/news/close-up-happy-people-working-together.jpg" class="news-image img-fluid" alt="">
                                    </a>
                                </div>

                                <div class="news-block-two-col-info">
                                    <div class="news-block-title mb-2">
                                        <h6><a href="#" class="news-block-title-link">Volunteering Clean</a></h6>
                                    </div>

                                    <div class="news-block-date">
                                        <p>
                                            <i class="bi-calendar4 custom-icon me-1"></i>
                                            October 24, 2036
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div class="category-block d-flex flex-column">
                                <h5 class="mb-3">Categories</h5>

                                <a href="#" class="category-block-link">
                                    Drinking water
                                    <span class="badge">20</span>
                                </a>

                                <a href="#" class="category-block-link">
                                    Food Donation
                                    <span class="badge">30</span>
                                </a>

                                <a href="#" class="category-block-link">
                                    Children Education
                                    <span class="badge">10</span>
                                </a>

                                <a href="#" class="category-block-link">
                                    Poverty Development
                                    <span class="badge">15</span>
                                </a>

                                <a href="#" class="category-block-link">
                                    Clothing Donation
                                    <span class="badge">20</span>
                                </a>
                            </div>

                            <div class="tags-block">
                                <h5 class="mb-3">Tags</h5>

                                <a href="#" class="tags-block-link">
                                    Donation
                                </a>

                                <a href="#" class="tags-block-link">
                                    Clothing
                                </a>

                                <a href="#" class="tags-block-link">
                                    Food
                                </a>

                                <a href="#" class="tags-block-link">
                                    Children
                                </a>

                                <a href="#" class="tags-block-link">
                                    Education
                                </a>

                                <a href="#" class="tags-block-link">
                                    Poverty
                                </a>

                                <a href="#" class="tags-block-link">
                                    Clean Water
                                </a>
                            </div>

                            <form class="custom-form subscribe-form" action="#" method="get" role="form">
                                <h5 class="mb-4">Newsletter Form</h5>

                                <input type="email" name="subscribe-email" id="subscribe-email" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="Email Address" required>

                                <div class="col-lg-12 col-12">
                                    <button type="submit" class="form-control">Subscribe</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </section>


            <section class="testimonial-section section-padding section-bg">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-8 col-12 mx-auto">
                            <h2 class="mb-lg-3">Happy Customers</h2>

                            <div id="testimonial-carousel" class="carousel carousel-fade slide" data-bs-ride="carousel">

                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <div class="carousel-caption">
                                            <h4 class="carousel-title">Lorem Ipsum dolor sit amet, consectetur adipsicing kengan omeg kohm tokito charity theme</h4>

                                            <small class="carousel-name"><span class="carousel-name-title">Maria</span>, Boss</small>
                                        </div>
                                    </div>

                                    <div class="carousel-item">
                                        <div class="carousel-caption">
                                            <h4 class="carousel-title">Sed leo nisl, posuere at molestie ac, suscipit auctor mauris quis metus tempor orci</h4>

                                            <small class="carousel-name"><span class="carousel-name-title">Thomas</span>, Partner</small>
                                        </div>
                                    </div>

                                    <div class="carousel-item">
                                        <div class="carousel-caption">
                                            <h4 class="carousel-title">Lorem Ipsum dolor sit amet, consectetur adipsicing kengan omeg kohm tokito charity theme</h4>

                                            <small class="carousel-name"><span class="carousel-name-title">Jane</span>, Advisor</small>
                                        </div>
                                    </div>

                                    <div class="carousel-item">
                                        <div class="carousel-caption">
                                            <h4 class="carousel-title">Sed leo nisl, posuere at molestie ac, suscipit auctor mauris quis metus tempor orci</h4>

                                            <small class="carousel-name"><span class="carousel-name-title">Bob</span>, Entreprenuer</small>
                                        </div>
                                    </div>

                                    <ol class="carousel-indicators">
                                        <li data-bs-target="#testimonial-carousel" data-bs-slide-to="0" class="active">
                                            <img src="assets/images/avatar/portrait-beautiful-young-woman-standing-grey-wall.jpg" class="img-fluid rounded-circle avatar-image" alt="avatar">
                                        </li>

                                        <li data-bs-target="#testimonial-carousel" data-bs-slide-to="1" class="">
                                            <img src="assets/images/avatar/portrait-young-redhead-bearded-male.jpg" class="img-fluid rounded-circle avatar-image" alt="avatar">
                                        </li>

                                        <li data-bs-target="#testimonial-carousel" data-bs-slide-to="2" class="">
                                            <img src="assets/images/avatar/pretty-blonde-woman-wearing-white-t-shirt.jpg" class="img-fluid rounded-circle avatar-image" alt="avatar">
                                        </li>

                                        <li data-bs-target="#testimonial-carousel" data-bs-slide-to="3" class="">
                                            <img src="assets/images/avatar/studio-portrait-emotional-happy-funny.jpg" class="img-fluid rounded-circle avatar-image" alt="avatar">
                                        </li>
                                    </ol>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>


            <section class="contact-section section-padding" id="section_6">
            <div class="container">
                <div class="row">

                    <div class="col-lg-4 col-12 ms-auto mb-5 mb-lg-0">
                        <div class="contact-info-wrap">
                            <h2>Get in touch</h2>

                            <div class="contact-image-wrap d-flex flex-wrap">

                                
                                <img src="assets/images/map.jpg" class="img-thumbnail"  alt=""/>
                            </div>

                            <div class="contact-info">
                                <h5 class="mb-3">Contact Infomation</h5>

                                <p class="d-flex mb-2">
                                    <i class="bi-geo-alt me-2"></i>
                                    FPT University, Hoa Lac, Ha Noi
                                </p>

                                <p class="d-flex mb-2">
                                    <i class="bi-telephone me-2"></i>

                                    <a href="tel: 120-240-9600">
                                        0948539479
                                    </a>
                                </p>

                                <p class="d-flex">
                                    <i class="bi-envelope me-2"></i>

                                    <a href="mailto:info@yourgmail.com">
                                        vubahe163495@fpt.edu.vn
                                    </a>
                                </p>

                                <a href="https://www.google.com/maps/place/FPT+University/@21.013255,105.5248756,17z/data=!3m1!4b1!4m5!3m4!1s0x31345b465a4e65fb:0xaae6040cfabe8fe!8m2!3d21.01325!4d105.5270643" class="custom-btn btn mt-3">Get Direction</a>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-5 col-12 mx-auto">
                        
                            <h2>Send feedback</h2>

                            <p class="mb-4">Or, you can just send an email:
                                <a href="#">anhvubui382@gmail.com</a>
                            </p>
                            <form class="custom-form contact-form" action="FeedbackController" role="form">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-12">
                                    <input type="text" name="name" id="name" class="form-control" placeholder="Bui" required>
                                </div>

                                <div class="col-lg-6 col-md-6 col-12">
                                    <input type="text" name="name" id="name" class="form-control" placeholder="Anh Vu" required>
                                </div>
                            </div>

                            <input type="email" name="email" id="email" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="vubahe163495@fpt.edu.vn" required>

                            <textarea name="message" rows="5" class="form-control" id="message" placeholder="What do you want to say with us?"></textarea>

                            <button type="submit" class="form-control">Send Feedback</button>
                        </form>
                    </div>

                </div>
            </div>
        </section>


    </main>
    <jsp:include page="layout/chatbot.jsp"/>
    <jsp:include page="layout/footer.jsp"/>
</body>
</html>

