<%--
  Created by IntelliJ IDEA.
  User: Red Skull
  Date: 1/1/2019
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
    <div class="card mt-5" style="margin:auto; width:400px;">
        <form class="card-body" action='signup'  method="post">
            <input type="hidden" value="registeruser" name="pageRequest">
            <div class="d-flex justify-content-center nav nav-tabs">
                <span class="nav-item"><a href="index?pageRequest=signin" class="nav-link">Log In</a></span>
                <span class="nav-item "><a href="#" class="nav-link active">Sign Up</a></span>
            </div>

            <div class="mt-1">
                <label for="Uname">Username:</label>
                <input type="text" class="form-control" placeholder="Username" name="username" id="uname">
                <p id="p0" class='text-danger small'></p>
            </div>

            <div class="mt-1">
                <label for="email">Email:</label>
                <input type="email" class="form-control" name="email" placeholder="Email" id="email">
                <p id="p2" class='text-danger small'></p>
            </div>

            <div class="row mt-1">
                                <span class="col-md-6">
                                    <label for="password">Password:</label>
                                    <input type="password" class="form-control" name = 'password' placeholder="Password" id="psw">
                                    <p id="p3" class='text-danger small'></p>
                                </span>

                <span class="col-md-6">
                                    <label for="Cpassword">Confirm Password:</label>
                                    <input type="password" class="form-control" name="cpsw" placeholder="Confirm Password" id="cpsw">
                                    <p id="p4" class='text-danger'></p>
                                </span>
            </div>

            <div class="d-flex justify-content-center mt-1">
                <button type="submit" class="btn btn-success" id="validate">Sign up</button>
            </div>
        </form>
    </div>
</body>
</html>
