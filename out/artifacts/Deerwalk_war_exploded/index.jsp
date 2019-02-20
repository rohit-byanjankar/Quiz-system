<%@include file="include/header.jsp"%>
<div class="card mt-5" style="margin:auto; width:290px;">
        <form class="card-body" method="POST" action="index">
            <div class="d-flex justify-content-center nav nav-tabs">
                <span class="nav-item"><a href="#" class="nav-link active">Log In</a></span>
                <span class="nav-item "><a href="signup?pageRequest=signup" class="nav-link">Sign Up</a></span>
            </div>

            <div class="mt-4">
                <label for="email">Email:</label>
                <input type="email" class="form-control" placeholder="Email" name="email">
            </div>

            <div class="mt-4">
                <label for="password">Password:</label>
                <input type="password" class="form-control" placeholder="Password" name="password" >
            </div>

            <div class="d-flex justify-content-center mt-2">
                <button type="submit" class="btn btn-success mt-2">Log in</button>
                <input type="hidden" name="pageRequest" value="login">
            </div>
                <div class="text-danger text-center bg-dark mt-3">${message}</div>
        </form>
</div>