<%--
  Created by IntelliJ IDEA.
  User: Red Skull
  Date: 1/3/2019
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp"%>
</head>
<body>
    <%@include file="../include/navbar.jsp"%>
    <div class="container w-100 mt-4">
        <h4 class="container text-danger text-center">List of Questions</h4>
        <div class="text-success bg-dark">${message}</div>
        <div class="table-responsive mt-4">
            <table class="table">
                <thead>
                <tr class="text-danger">
                    <th>Question</th>
                    <th>Category</th>
                    <th>Difficulty</th>
                    <th>Answer</th>
                    <th>Action</th>
                </tr>
                </thead>
                <c:forEach items = "${questionList}" var = "question">
                    <tbody>
                    <tr class="danger">
                        <td>${question.question}</td>
                        <td>${question.category}</td>
                        <td>${question.difficultyLevel}</td>
                        <td>${question.correctAnswer}</td>
                        <td>
                            <a href="updateQuestion?pageRequest=updatePage&id=${question.id}" ><i class="fa fa-edit"></i></a>
                            &nbsp;&nbsp;
                            <a href="deleteQuestion?pageRequest=delete&id=${question.id}" ><i class="fa fa-trash"></i> </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
