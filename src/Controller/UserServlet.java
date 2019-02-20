package Controller;

import Domain.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pageRequest = request.getParameter("pageRequest");

        //Request for logging in and checking database for valid credentials
        if (pageRequest.equalsIgnoreCase("login")) {
            User user=userService.loginUser(email,password);
            if (user!=null){
                HttpSession session=request.getSession(false);
                session.setAttribute("user",user);
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                request.setAttribute("message", "You have successfully Login!!");
                rd.forward(request, response);
            } else {
                request.setAttribute("message", "Invalid Credentials!!");
                redirectTo(request, response);
            }
        }

        //Request for logout from webpage
        if (pageRequest.equalsIgnoreCase("logout")){
            HttpSession session=request.getSession(false);
            session.invalidate();
            request.setAttribute("message","You have succesfully Logout!!");
            redirectTo(request, response);
        }

        //Request for signup page
        if(pageRequest.equalsIgnoreCase("signup")){
            RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
            rd.forward(request,response);
        }

        //Request for signin page
        if(pageRequest.equalsIgnoreCase("signin")){
            redirectTo(request, response);
        }

        //Request for registering user
        if(pageRequest.equalsIgnoreCase("registeruser")){
            userService.registerUser(getUser(request));
            request.setAttribute("message", "You are signed up and logged in successfully!!");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);
        }

        //Request for home page
        if(pageRequest.equalsIgnoreCase("home")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);
        }

        //Request for list of user
        if(pageRequest.equalsIgnoreCase("userlist")){
            redirectToList(request, response);
        }

        //Request for deleting user
        if(pageRequest.equalsIgnoreCase("delete")){
            request.setAttribute("message", "User Deleted Succesfully!!");
            userService.delete(request.getParameter("id"));
            redirectToList(request, response);
        }

        //Request for editing user
        if(pageRequest.equalsIgnoreCase("edit")){
            request.setAttribute("message", "User Updated Succesfully!!");
            userService.edit(getUser(request),request.getParameter("id"));
            redirectToList(request,response);
        }

        //Request for editing user page
        if(pageRequest.equalsIgnoreCase("editUser")){
            User user=userService.getUser(request.getParameter("id"));
            request.setAttribute("userList",user);
            RequestDispatcher rd=request.getRequestDispatcher("user/editUser.jsp");
            rd.forward(request,response);
        }
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new UserService().userList();
        request.setAttribute("userList", userList);
        RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
        rd.forward(request, response);
    }

    private void redirectTo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        }


    public User getUser(HttpServletRequest request){
        User user=new User();
        user.setName(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
}
