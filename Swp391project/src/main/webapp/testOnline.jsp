   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <style>
        .popup{
            background: #5bc1ac;
            border-radius: 6px;
            text-align: center;
            padding:  0 30px 30px;
        }
        .popup img{
            padding:  30px 30px ;
        }
    </style>  
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    
                    <div class="col-lg-12 text-center mb-4">
                        <br>
                        <h2>Online Eye Test</h2>
                    </div>
                    <div class=" col-lg-6  mb-4">
                        <div class="popup">
                        <div>
                            <img src="https://www.personaleyes.com.au/images/site/online-eye-test.png"/>
                        </div>
                        <br>
                        <p>Take the Eyes Online Eye Test</p>
                        <a class="btn btn-secondary btn-lg active" href="TestController">Take the test</a>
                        </div>
                    </div>
                    <div class=" col-lg-6  mb-4">
                        <div class="popup">
                        <div>
                            <img src="https://www.personaleyes.com.au/images/site/online-eye-test.png"/>
                        </div>
                        <br>
                        <p>Take the Eyes Online Eye Test</p>
                        <a class="btn btn-secondary btn-lg active" href="#">Take the test</a>
                        </div>
                    </div>
                    <c:if test="${requestScope.mess !=null}">
                        <div class="text-center" style="padding:   40px 20px; border: 1px solid #5bc1ac">
                        <img src="https://www.personaleyes.com.au/images/site/tick-big.webp" width="90px" height="90px" class="logo">
                        <p>Congratulations on completing the test!</p>
                        <p>${requestScope.mess}</p>
                        </div>
                    </c:if>
                    <div >
                        <p>Test your visual acuity from the comfort of your 
                            couch or office chair with our online eye test. This test could help give you 
                            an indication of whether if you suffer 
                            from myopia (short-sightedness), hyperopia (farsightedness) 
                            or other eyesight problems that may require corrective glasses or lenses.
                        </p>
                        <p>
                            Before you start the online eye test, please remove any prescription 
                            glasses or lenses. As eyesight can change over time, performing the test 
                            without these aids will give you an indication of the accuracy of your 
                            current prescription.
                        </p>
                        <h2>How to use the Chart</h2
                        <ul>
                            <li>Make sure you're using a desktop computer (or if you're using a laptop or tablet, make sure you've got really long arms!)</li>
                            <li>Position yourself approximately 1 metre from your computer screen, facing it directly, and cover your left eye.</li>
                            <li>When you click "Start", you will be shown a line of eight characters. In the field below, type the letters as you see them, without spaces.</li>
                            <li>Once you've entered each letter, click "Next".</li>
                            <li>If you've entered all letters correctly, you'll progress to the next stage of the chart.</li>
                            <li>If you enter one or more letters incorrectly, you'll be taken through to your results. Oops, was that just a typo? Not to worry. If you feel your mistake was a result of your fingers rather than your eyes, select "Re-Do Test" to go back and try again</li>
                            <li>Once you've reached your result, repeat the process for your right eye.</li>
                            </ul>
                        <h2>How Does the Online Eye Test Work?</h2
                        <p>This interactive eye exam will test your sight from <strong>20/70</strong> to <strong>20/20</strong> vision. If you successfully reach the end of the test, you'll be directed to the 20/20 (perfect vision) results page.</p>
                        <p>If you wear glasses or contact lenses, it's important to test both <strong>with</strong> and <strong>without</strong> your corrective lenses. This will give you an idea as to whether your current script is the correct strength for you.</p>
                        <p>Book a Consultation at a personal EYES clinic</p>
                        <p>Although the test is designed to give you an idea of how good your eyesight is, it's important to have an optometrist give you a proper examination every two years. They will be able to give you a more accurate test, in addition to testing for things like glaucoma and cataracts. They'll also be able to discuss treatment options, like laser eye surgery, with you</p>
                        <p>Give personalEYES a call today on <strong><a href="#">09489539479</a></strong> to book a consultation at any of our <a href="#"><strong>locations</strong></a>.</p>
                    </div>
                    </ul>
                        <h2>How Does the Online Eye Test Work?</h2
                        <p>This interactive eye exam will test your sight from <strong>20/70</strong> to <strong>20/20</strong> vision. If you successfully reach the end of the test, you'll be directed to the 20/20 (perfect vision) results page.</p>
                        <p>If you wear glasses or contact lenses, it's important to test both <strong>with</strong> and <strong>without</strong> your corrective lenses. This will give you an idea as to whether your current script is the correct strength for you.</p>
                        <p>Book a Consultation at a personal EYES clinic</p>
                        <p>Although the test is designed to give you an idea of how good your eyesight is, it's important to have an optometrist give you a proper examination every two years. They will be able to give you a more accurate test, in addition to testing for things like glaucoma and cataracts. They'll also be able to discuss treatment options, like laser eye surgery, with you</p>
                        <p>Give personalEYES a call today on <strong><a href="#">09489539479</a></strong> to book a consultation at any of our <a href="#"><strong>locations</strong></a>.</p>
                    </div>