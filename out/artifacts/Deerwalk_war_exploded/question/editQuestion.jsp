<%--
  Created by IntelliJ IDEA.
  User: Red Skull
  Date: 1/3/2019
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp"%>
</head>
<body>
    <%@include file="../include/navbar.jsp"%>
    <div class="text-light text-center bg-info mt-3">${message}</div>
    <h3 class="text-center text-danger mt-4">Update Questions</h3>
    <div class="container mt-2 border border-success mb-5">
        <form class="card-body" action='updateQuestion' method="post">
            <input type="hidden" value="update" name="pageRequest">
            <input type="hidden" value="${questionList.id}" name="id">

            <div class="mt-2">
                <label>Category</label>
                <select class="form-control" name="category">
                    <option value="math" ${questionList.category == 'math' ? 'selected' : ''}>Math</option>
                    <option value="science" ${questionList.category == 'science' ? 'selected' : ''}>Science</option>
                    <option value="gk" ${questionList.category == 'gk' ? 'selected' : ''}>GK</option>
                    <option value="computer" ${questionList.category == 'computer' ? 'selected' : ''}>Computer</option>
                </select>
            </div>

            <div class="mt-3">
                <label>Question</label>
                <input type="text" class="form-control" name="question"  value="${questionList.question}" required>
            </div>

            <div class="mt-3">
                <label>Option 1</label>
                <input type="text" class="form-control" name="option 1" value="${questionList.option1}" required>
            </div>

            <div class="mt-3">
                <label>Option 2</label>
                <input type="text" class="form-control" name="option 2" value="${questionList.option2}" required>
            </div>

            <div class="mt-3">
                <label>Option 3</label>
                <input type="text" class="form-control" name="option 3" value="${questionList.option3}" required>
            </div>

            <div class="mt-3">
                <label>Option 4</label>
                <input type="text" class="form-control" name="option 4" value="${questionList.option4}" required>
            </div>

            <div class="mt-3">
                <label>Correct Answer</label>
                <select class="form-control" name="answer">
                    <option value="${questionList.option1}" ${questionList.correctAnswer == questionList.option1 ? 'selected' : ''}>${questionList.option1}</option>
                    <option value="${questionList.option2}" ${questionList.correctAnswer == questionList.option2 ? 'selected' : ''}>${questionList.option2} </option>
                    <option value="${questionList.option3}" ${questionList.correctAnswer == questionList.option3 ? 'selected' : ''}>${questionList.option3} </option>
                    <option value="${questionList.option4}" ${questionList.correctAnswer == questionList.option4 ? 'selected' : ''}>${questionList.option4} </option>
                </select>
            </div>

            <div class="mt-3">
                <label>Difficulty Level</label>
                <select class="form-control" name="difficultylevel">
                    <option value="easy" ${questionList.difficultyLevel == 'easy' ? 'selected' : ''}>Easy</option>
                    <option value="hard" ${questionList.difficultyLevel == 'hard' ? 'selected' : ''}>Hard</option>
                    <option value="expert" ${questionList.difficultyLevel == 'expert' ? 'selected' : ''}>Expert</option>
                </select>
            </div>

            <div class="d-flex justify-content-center mt-3">
                <button type="submit" class="btn btn-success">Update Questions</button>
            </div>
        </form>
    </div>
</body>
</html>
