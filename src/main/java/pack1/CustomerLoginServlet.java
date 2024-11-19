package pack1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("uname");
        String password = req.getParameter("pword");

        CustomerBean cbean = new CustomerLoginDAO().checkCustomerLogin(username, password);

        HttpSession session = req.getSession();
        if (cbean != null) {
            // Set customer session
            session.setAttribute("cbean", cbean);
            // Remove admin session if it exists
            session.removeAttribute("abean");
            // Redirect to product list or home page
            res.sendRedirect("CustomerHome.jsp");
        } else {
            // Handle invalid login
            req.setAttribute("msg", "Invalid Customer credentials");
            RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
            rd.forward(req, res);
        }
    }
}