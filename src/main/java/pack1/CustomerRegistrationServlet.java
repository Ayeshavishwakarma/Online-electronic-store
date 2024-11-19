package pack1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Retrieve parameters from the request
        String username = req.getParameter("uname");
        String password = req.getParameter("pword");
        String firstname = req.getParameter("fname");
        String lastname = req.getParameter("lname");
        String address = req.getParameter("addr");
        String email = req.getParameter("mid");
        String phone = req.getParameter("phno");

        // Input validation
        if (username == null || password == null || firstname == null || lastname == null || 
            address == null || email == null || phone == null || 
            username.isEmpty() || password.isEmpty() || firstname.isEmpty() || 
            lastname.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            req.setAttribute("msg", "All fields are required.");
            RequestDispatcher rd = req.getRequestDispatcher("CustomerRegistration.html");
            rd.forward(req, res);
            return;
        }

        // Create an instance of CustomerRegistrationDAO
        CustomerRegistrationDAO registrationDAO = new CustomerRegistrationDAO();
        boolean isRegistered = registrationDAO.registerCustomer(username, password, firstname, lastname, address, email, phone);

        if (isRegistered) {
            // Create a new CustomerBean object for the registered user
            CustomerBean cbean = new CustomerBean();
            cbean.setuName(username);
            cbean.setUpword(password); // Store the password (plain text for now)
            cbean.setFname(firstname);
            cbean.setLname(lastname);
            cbean.setAddr(address);
            cbean.setMid(email);
            cbean.setPhno(phone);

            // Create a session and store the CustomerBean
            HttpSession session = req.getSession();
            session.setAttribute("cbean", cbean);

            // Set the success message
            req.setAttribute("msg", "Registration successful!!");
            
            // Forward to customerhome.jsp
            RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.jsp");
            rd.forward(req, res);
        } else {
            req.setAttribute("msg", "Registration failed. Please try again.");
            RequestDispatcher rd = req.getRequestDispatcher("CustomerRegistration.html");
            rd.forward(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method is not supported for this servlet.");
    }
}