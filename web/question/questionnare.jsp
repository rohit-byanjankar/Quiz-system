<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/header.jsp"%>
</head>
<body>
    <%@include file="../include/navbar.jsp"%>
    <div class="text-light text-center bg-info mt-3">${message}</div>
    <h3 class="text-center text-danger mt-4">Add Questions</h3>
        <div class="container mt-2 border border-success mb-5">
            <form class="card-body" action='addQuestions'  method="post">
                <input type="hidden" value="question" name="pageRequest">

                <div class="mt-2">
                        <label>Category</label>
                        <select class="form-control" name="category">
                            <option selected>Select Category</option>
                            <option value="math">Math</option>
                            <option value="science">Science</option>
                            <option value="gk">GK</option>
                            <option value="computer">Computer</option>
                        </select>
                </div>

                <div class="mt-3">
                    <label>Question</label>
                    <input type="text" class="form-control" name="question" required>
                </div>

                <div class="mt-3">
                    <label>Option 1</label>
                    <input type="text" class="form-control" name="option 1" required>
                </div>

                <div class="mt-3">
                    <label>Option 2</label>
                    <input type="text" class="form-control" name="option 2" required>
                </div>

                <div class="mt-3">
                    <label>Option 3</label>
                    <input type="text" class="form-control" name="option 3" required>
                </div>

                <div class="mt-3">
                    <label>Option 4</label>
                    <input type="text" class="form-control" name="option 4" required>
                </div>

                <div class="mt-3">
                    <label>Correct Answer</label>
                    <select class="form-control" name="answer">
                        <option value="option 1" selected>Option 1</option>
                        <option value="option 2">Option 2</option>
                        <option value="option 3">Option 3</option>
                        <option value="option 4">Option 4</option>
                    </select>
                </div>

                <div class="mt-3">
                        <label>Difficulty Level</label>
                        <select class="form-control" name="difficultylevel">
                            <option selected>Select Difficulty</option>
                            <option value="easy">Easy</option>
                            <option value="hard">Hard</option>
                            <option value="expert">Expert</option>
                        </select>
                </div>

                <div class="d-flex justify-content-center mt-3">
                    <button type="submit" class="btn btn-success">Add Questions</button>
                </div>
            </form>
        </div>
</body>
</html>
