<%--
  Created by IntelliJ IDEA.
  User: Red Skull
  Date: 1/2/2019
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp"%>

</head>
<body>
    <%@include file="../include/navbar.jsp"%>

    <h3 class="text-center text-danger mt-4">Update User Information</h3>
        <div class="card mt-2" style="margin:auto; width:400px;">
            <form class="card-body" action='editUser'  method="post">
                <input type="hidden" value="edit" name="pageRequest">
                <input type="hidden" value="${userList.id}" name="id">

                <div class="mt-1">
                    <label for="Uname">Username:</label>
                    <input type="text" class="form-control" placeholder="Username" name="username" id="uname" value="${userList.name}" required>
                    <p id="p0" class='text-danger small'></p>
                </div>

                <div class="mt-1">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" name="email" placeholder="Email" id="email" value="${userList.email}" required>
                    <p id="p2" class='text-danger small'></p>
                </div>

                <div class="mt-1">
                        <label for="psw">Password:</label>
                        <input type="password" class="form-control" name = 'password' placeholder="Password" id="psw" value="${userList.password}" required>
                        <p id="p3" class='text-danger small'></p>
                </div>

                <div class="d-flex justify-content-center mt-1">
                    <button type="submit" class="btn btn-success">Update</button>
                </div>
            </form>
        </div>
</body>
</html>
