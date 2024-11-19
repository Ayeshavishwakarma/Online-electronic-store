package pack1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AdminBean abean = new AdminLoginDAO().checkAdminLogin(username, password);

        HttpSession session = req.getSession();
        if (abean != null) {
            // Set customer session
            session.setAttribute("abean", abean);
            // Remove admin session if it exists
            session.removeAttribute("cbean");
            // Redirect to product list or home page
            res.sendRedirect("AdminHome.jsp");
        } else {
            // Handle invalid login
            req.setAttribute("msg", "Invalid Customer credentials");
            RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
            rd.forward(req, res);
        }
    }
}