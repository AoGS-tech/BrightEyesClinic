<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <style>
        .carousel{
            padding:   8%
        }
        .bt-next{
            margin:  10%
        }
        input[type="text" ] {
            padding: 1px 2px;
        }
        input {
            writing-mode: horizontal-tb !important;
            font-style: ;
            font-variant-ligatures: ;
            font-variant-caps: ;
            font-variant-numeric: ;
            font-variant-east-asian: ;
            font-weight: ;
            font-stretch: ;
            font-size: ;
            font-family: ;
            text-rendering: auto;
            color: fieldtext;
            letter-spacing: normal;
            word-spacing: normal;
            line-height: normal;
            text-transform: none;
            text-indent: 0px;
            text-shadow: none;
            display: inline-block;
            text-align: start;
            appearance: auto;
            -webkit-rtl-ordering: logical;
            cursor: text;
            background-color: field;
            margin: 0em;
            padding: 1px 2px;
            border-width: 2px;
            border-style: inset;
            border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
            border-image: initial;
        }
        .text-box {
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 5px;
            height: 32px;
        }
        #step1text {
            font-family: gotham-medium;
            font-size: 19px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step2text {
            font-family: gotham-medium;
            font-size: 17px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step3text {
            font-family: gotham-medium;
            font-size: 14.5px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step4text {
            font-family: gotham-medium;
            font-size: 11px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step5text {
            font-family: gotham-medium;
            font-size: 9px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
        #step6text {
            font-family: gotham-medium;
            font-size: 7px;
            font-style: normal;
            font-weight: 700;
            font-variant: normal;
            text-transform: uppercase;
            color: #000;
            letter-spacing: 5px;
        }
    </style>
    <jsp:include page="layout/head.jsp"/>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <jsp:include page="layout/menu.jsp"/>
        <div class="container">
    <div class="row">
         <div class="col-md-1">
            
        </div>
        <div class="col-md-5">
            cot 2
        </div>
        <div class="col-md-5">
            cot 1
        </div>
         <div class="col-md-1">
            
        </div>
    </div>
</div>
        <jsp:include page="layout/chatbot.jsp"/>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>