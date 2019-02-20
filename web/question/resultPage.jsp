<%--
  Created by IntelliJ IDEA.
  User: Red Skull
  Date: 1/7/2019
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="../include/header.jsp"%>
</head>
<body>
    <%@include file="../include/navbar.jsp"%>
<%--    <div>
        <%! int count=0; %>
        <c:forEach items="${correctAnswer}" var="correctanswer" varStatus="status">
             <div class="mt-3 text-white bg-dark text-center">${correctanswer.question}</div>
             <div class="ml-3 mt-3 text-danger text-center">Correct Answer for Question ${correctanswer.id} is ${correctanswer.correctAnswer}</div>
                 <c:forEach items="${userAnswer}" var="useranswer">
                        <c:if test="${correctanswer.correctAnswer == useranswer.value && correctanswer.id == useranswer.key}">
                             <div class="ml-3 mt-3 text-danger text-center">Your Answer for Question ${useranswer.key} is ${useranswer.value}</div>
                                <% count++; %>
                         </c:if>
                        <c:if test="${correctanswer.correctAnswer != useranswer.value && correctanswer.id == useranswer.key}">
                             <div class="ml-3 mt-3 text-danger text-center">Your Answer for Question ${useranswer.key} is ${useranswer.value}</div>
                         </c:if>
                </c:forEach>
            <div class="container text-center mt-2 result">
                <h4 class="text-success">YOU SCORED <%= count %> POINTS OUT OF ${status.count} POINTS!!</h4>
            </div>
        </c:forEach>
            <% count=0; %>
    </div>--%>

    <div class="container">
        <h2 class="text-center text-danger mt-3">Result</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Question</th>
                <th>User Answer</th>
                <th>Correct Answer</th>
            </tr>
            </thead>
            <c:forEach items="${quiz}" var="quizList">
                <tbody class="${quizList.correctAnswer == quizList.userAnswer ? 'bg-success' : 'bg-danger'}">
                    <tr>
                        <td>${quizList.question}</td>
                        <td>${quizList.correctAnswer}</td>
                        <td>${quizList.userAnswer}</td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</body>
</html>
