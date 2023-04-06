<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="layout/head.jsp"/>
    <style>

        .title{
            margin-bottom: 5vh;
        }
        .card{
            margin: auto;
            max-width: 90%;
            width: 90%;
            box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 1rem;
            border: transparent;
        }
        @media(max-width:767px){
            .card{
                margin: 3vh auto;
            }
        }
        .cart{
            background-color: #fff;
            padding: 4vh 5vh;
            border-bottom-left-radius: 1rem;
            border-top-left-radius: 1rem;
        }
        @media(max-width:767px){
            .cart{
                padding: 4vh;
                border-bottom-left-radius: unset;
                border-top-right-radius: 1rem;
            }
        }
        .summary{
            background-color: #ddd;
            border-top-right-radius: 1rem;
            border-bottom-right-radius: 1rem;
            padding: 4vh;
            color: rgb(65, 65, 65);
        }
        @media(max-width:767px){
            .summary{
                border-top-right-radius: unset;
                border-bottom-left-radius: 1rem;
            }
        }
        .summary .col-2{
            padding: 0;
        }
        .summary .col-10
        {
            padding: 0;
        }
        .row{
            margin: 0;
        }
        .title b{
            font-size: 1.5rem;
        }
        .main{
            margin: 0;
            padding: 2vh 0;
            width: 100%;
        }
        .col-2, .col{
            padding: 0 1vh;
        }
        a{
            padding: 0 1vh;
        }
        .close{
            margin-left: auto;
            font-size: 1.7rem;
        }
        img{
            width: 10.5rem;
        }
        .back-to-shop{
            margin-top: 4.5rem;
        }
        h5{
            margin-top: 4vh;
        }
        hr{
            margin-top: 1.25rem;
        }
        form{
            padding: 2vh 0;
        }
        select{
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1.5vh 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input{
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input:focus::-webkit-input-placeholder
        {
            color:transparent;
        }
        .btn{
            background-color: #000;
            border-color: #000;
            color: white;
            width: 100%;
            font-size: 0.7rem;
            margin-top: 4vh;
            padding: 1vh;
            border-radius: 0;
        }
        .btn:focus{
            box-shadow: none;
            outline: none;
            box-shadow: none;
            color: white;
            -webkit-box-shadow: none;
            -webkit-user-select: none;
            transition: none;
        }
        .btn:hover{
            color: white;
        }
        a{
            color: black;
        }
        a:hover{
            color: black;
            text-decoration: none;
        }
        #code{
            background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253) , rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
            background-repeat: no-repeat;
            background-position-x: 95%;
            background-position-y: center;
        }
    </style>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <main>
            
            <div class="card">
                <div class="row">
                    <div class="col-md-8 cart">
                        <div class="title">
                            <div class="row">
                                <div class="col"><h4><b>Shopping Glasses</b></h4></div>
                                
                            </div>
                        </div>
                        <c:set var="o" value="${requestScope.cart}"  />
                        <c:forEach items="${o.items}" var="i">
                            <div class="row border-top border-bottom">
                                <div class="row main align-items-center">
                                    <div class="col-2"><img class="img-fluid" src="${i.getGlass().getImage()} "></div>
                                    <div class="col">
                                        <div class="row text-muted">${i.getGlass().getGlassName()}</div>
                                        <div class="row">${i.getGlass().getColor()}</div>
                                    </div>
                                    <div class="col">

                                        <a href="process?num=-1&id=${i.getGlass().getGlassID()}">-</a><a class="border">${i.getQuantity()}</a>
                                        <a href="process?num=1&id=${i.getGlass().getGlassID()}">+</a>

                                    </div>
                                    <div class="col">$${i.getGlass().getPrice()}  </div>
                                    <div class="col">
                                        <form action="process" method="post">
                                            <input type="hidden" name="id" value="${i.getGlass().getGlassID()}"/>
                                            <button  type="submit" ><span class="close">&#10005;</span></button>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </c:forEach>
                        <div class="back-to-shop"><a href="home">&leftarrow;<span class="text-muted">Back to home</span></div></a>
                    </div>
                    <div class="col-md-4 summary">
                        <div><h5><b>Summary</b></h5></div>
                        <div class="checkoutpay">
                            <form action="checkout" method="post">
                                <div class="default">
                                    <div class="row">
                                       
                                            
                                            <p style="color: red">${requestScope.error}</p> 
                                        
                                   
                                        
                                        <div class="col-lg-6 col-md-6 col-12">
                                            <label><p>Name</p></label>
                                            <input type="text" name="name" class="form-control" placeholder="Enter full Name" />
                                        </div>

                                        <div class="col-lg-6 col-md-6 col-12">
                                            <label><p>Email</p></label>
                                            <input type="email" name="emailOrder" id="emailOrder" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="Enter your mail" />
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-12">
                                            <label><p>Phone</p></label>
                                            <input type="text" name="phone" id="phoneOrder" class="form-control" placeholder="Enter your Phone" />
                                        </div>

                                        <div class="col-lg-6 col-md-6 col-12">
                                            <label><p>City</p></label>
                                            <select name="city"class="form-control">
                                                <option value="1"class="text-muted">Hà Nội</option>
                                                <option value="2"class="text-muted">Hồ Chí Minh</option>
                                                <option value="3"class="text-muted">Cần Thơ</option>

                                                <option value="4" class="text-muted">Lào Cai</option>
                                                <option value="5" class="text-muted">Hà Tĩnh</option>
                                                <option value="6" class="text-muted">Đà Nẵng</option>

                                            </select>
                                        </div>
                                        <div class="col-12">
                                            <label><p>Adress</p></label>
                                            <input type="text" name="adress"  class="form-control"/>
                                        </div>
                                    </div>
                                    <p>Choose Unit Ship</p>
                                    <select name="unitShip" class="form-control department-name select2input">
                                        <option value="1"class="text-muted">VNpost – EMS</option>
                                        <option value="2"class="text-muted">Giao hàng tiết kiệm</option>
                                        <option value="3"class="text-muted">Giao hàng Nhanh</option>
                                    </select>
                                </div>
                                <br><!-- comment -->
                                <br><!-- comment -->

                                <p>Shiping : $3</p>

                                <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                                    <div class="col">TOTAL PRICE</div>
                                    <div class="col text-right">${o.getTotalMoney()}</div>
                                </div>
                                <label class="form-label"> Payment method</label>
                                <select name="payment" oninvalid="Select(this);" oninput="Select(this);" id="mySelect" class="form-control department-name select2input">

                                    <option value="default">Payment after receiving goods</option>
                                    <option value="paypal">Payment by Paypal</option>
                                </select>

                                <input type="submit"class="btn"value="CHECKOUT"/> 


                            </form>
                        </div>

                    </div>
                </div>

            </div>

        </main>
        <br><!-- comment -->
        <br><!-- comment -->

        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/flatpickr.min.js"></script>
        <script src="assets/js/flatpickr.init.js"></script>
        <script src="assets/js/select2.min.js"></script>
        <script src="assets/js/select2.init.js"></script>
        <script src="assets/js/jquery.timepicker.min.js"></script> 
        <script src="assets/js/timepicker.init.js"></script>
        <script src="assets/js/feather.min.js"></script>
        <script src="assets/js/vn.js"></script>
        <script src="assets/js/app.js"></script>
        <script src="assets/js/sweetalert.min.js"></script>
        <script>
            function Select(text) {
                if (text.value == "default") {
                    $(".default").show();
                    $(".paypal").hide();
                } else if (text.value == "paypal") {
                    $(".paypal").show();
                    $(".default").hide();
                } else {
                    $(".default").hide();
                    $(".paypal").hide();
                }
            }
        </script>
    </body>

</html>

