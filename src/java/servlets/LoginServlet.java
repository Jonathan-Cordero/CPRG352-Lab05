package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        
        if (request.getParameter("logout") != null){
            session.invalidate();
            request.setAttribute("logout", "Logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            return;
        }        
        else if (session.getAttribute("username") != null){
            response.sendRedirect("home");
            
            return;
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
         
         AccountService actsvs = new AccountService();
         
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         if (username == null || username.equals("") || password == null || password.equals("")){
             request.setAttribute("error", "Please enter your username & password");
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             
            return;
         }
         else if (actsvs.login(username, password) == null){
             request.setAttribute("error", "Please enter your username & password");
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             
             return;
         }
         else if (actsvs.login(username, password) != null){
             session.setAttribute("username", username);
             response.sendRedirect("home");
             
             return;
         }
         else {
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             
             return;
         }
    }

}
