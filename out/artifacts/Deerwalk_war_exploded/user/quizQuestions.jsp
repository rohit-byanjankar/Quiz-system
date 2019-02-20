<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp"%>
</head>
<body>
    <%@include file="../include/navbar.jsp"%>
    <form method="post" action="startQuiz">
        <div class="container-fluid">
        <c:forEach items="${questionList}" var="question" varStatus="status">
            <div class="text-white text-center mt-3 bg-dark">${question.question}</div>
            <div class="container-fluid mt-3 bg-light">
                <div class="form-check mt-2">
                    <input class="form-check-input" type="radio" value="${question.option1}" name ="userAnswer">
                    <label class="form-check-label">
                            ${question.option1}
                    </label>
                </div>

                <div class="form-check mt-2">
                    <input class="form-check-input" type="radio" value="${question.option2}" name ="userAnswer">
                    <label class="form-check-label">
                            ${question.option2}
                    </label>
                </div>

                <div class="form-check mt-2">
                    <input class="form-check-input" type="radio" value="${question.option3}" name ="userAnswer">
                    <label class="form-check-label">
                            ${question.option3}
                    </label>
                </div>

                <div class="form-check mt-2">
                    <input class="form-check-input" type="radio" value="${question.option4}" name ="userAnswer">
                    <label class="form-check-label">
                            ${question.option4}
                    </label>
                </div>
            </div>
            <div class="text-center">
                 <input type="hidden" value="start" name="pageRequest">
                 <input type="hidden" value="${question.id}" name="id">
                <button class="btn btn-dark text-white">${ status.last ? 'NEXT' : 'FINISH'}</button>
            </div>
        </c:forEach>
        </div>
    </form>
</body>
</html>
