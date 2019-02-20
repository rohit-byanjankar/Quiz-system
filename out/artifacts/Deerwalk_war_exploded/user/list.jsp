<%--
  Created by IntelliJ IDEA.
  User: Red Skull
  Date: 1/1/2019
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp"%>
</head>
<body>
<%@include file="../include/navbar.jsp"%>
<div class="container w-75 mt-4">
    <h4 class="container text-danger text-center">List of Users</h4>
    <div class="text-success bg-dark">${message}</div>
    <div class="table-responsive mt-4">
        <table class="table">
            <thead>
            <tr class="text-danger">
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Role </th>
                <th>Action</th>
            </tr>
            </thead>
        <c:forEach items = "${userList}" var = "user">
            <tbody>
            <tr class="danger">
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td>
                    <a href="updateUser?pageRequest=editUser&id=${user.id}" ><i class="fa fa-edit nav-link"></i></a>
                    &nbsp;&nbsp;
                    <a href="deleteUser?pageRequest=delete&id=${user.id}" ><i class="fa fa-trash"></i> </a>
                </td>
            </tr>
            </tbody>
    </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
