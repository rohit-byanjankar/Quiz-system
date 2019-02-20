<html>
    <head>
        <%@include file="../include/header.jsp"%>
        <link rel="stylesheet" href="../css/hero-text.css">
    </head>
    <body>
        <%@include file="../include/navbar.jsp"%>

    <div class="text-light text-center bg-info mt-3">${message}</div>
            <h3 class="text-center text-success mt-3 ">Welcome To The Landing Page ${sessionScope.user.name}!!</h3>
    <div class="fixed-bottom bg-dark text-success text-center">
        <i class="fa fa-copyright"> 2018 Copyright</i>
    </div>
    </body>
</html>