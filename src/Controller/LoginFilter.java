package Controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String pageRequest=request.getParameter("pageRequest");
        HttpSession session= request.getSession(false);

        if(pageRequest == null){
            pageRequest = "NA";
            redirectToIndex(request,response);
        }

        if ((session == null || session.getAttribute("user") == null) && !pageRequest.equalsIgnoreCase("login")
        && !pageRequest.equalsIgnoreCase("logout") && !pageRequest.equalsIgnoreCase("signup")){
            request.setAttribute("message","Please Login First!!");
                redirectToIndex(request,response);
                 }else{
                     chain.doFilter(req, resp);
        }
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
