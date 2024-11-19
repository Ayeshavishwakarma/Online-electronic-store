package pack1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace this with your actual validation logic
        if (isValidAdmin(username, password)) {
            AdminBean abean = new AdminBean(); // Populate this with admin details
            abean.setFname("Admin"); // Example: Set first name (you would fetch this from the database)
            request.getSession().setAttribute("abean", abean);
            request.getSession().setAttribute("userType", "admin"); // Set userType to admin
            response.sendRedirect("AdminHome.jsp"); // Redirect to admin home page
        } else if (isValidCustomer(username, password)) {
            request.getSession().setAttribute("userType", "customer"); // Set userType to customer for regular users
            response.sendRedirect("CustomerHome.jsp"); // Redirect to customer home page
        } else {
            // Invalid credentials, redirect back to login with an error message
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("login.html").forward(request, response); // Redirect back to the login page
        }
    }

    private boolean isValidAdmin(String username, String password) {
        // Implement your logic to check if the username and password match an admin's credentials
        return "admin".equals(username) && "adminpass".equals(password); // Example logic
    }

    private boolean isValidCustomer(String username, String password) {
        // Implement your logic to check if the username and password match a customer's credentials
        return "customer".equals(username) && "customerpass".equals(password); // Example logic
    }
}