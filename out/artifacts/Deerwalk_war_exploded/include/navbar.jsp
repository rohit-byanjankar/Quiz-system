
<div class="nav navbar-expand-md  bg-dark sticky-top ">
    <a class="nav-link text-success" href="index?pageRequest=home">
        Home
    </a>
    <a class="nav-link text-success" href="#">
        Contact
    </a>
    <a class="nav-link text-success" href="#">
        About
    </a>
    <c:if test="${sessionScope.user.role=='admin'}">

        <a class="nav-link text-success" href="list?pageRequest=userlist">
            UserList
        </a>
        <div class="dropdown">
            <div class="btn nav-link text-success bg-dark dropdown-toggle" data-toggle="dropdown">
                Questionare
            </div>
            <div class="dropdown-menu bg-dark">
                <a class="dropdown-item text-success " href="questionare?pageRequest=questionare">Add Questions</a>
                <a class="dropdown-item text-success" href="viewquestion?pageRequest=questionarelist">View Questions</a>
            </div>
        </div>
    </c:if>
    <a class="nav-link text-success" href="play?pageRequest=playQuiz">
        Play Quiz
    </a>
    <div class="ml-auto text-white mt-2">
            ${sessionScope.user.name}
    </div>
    <div class="mr-2">
            <a href="logout?pageRequest=logout" class="nav-link text-success">Log Out</a>
    </div>
</div>