package pack1;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addOrder")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a list to hold order items
        List<String[]> orderItems = new ArrayList<>();

        // Example: Add some items (In a real application, you would get these from user input)
        orderItems.add(new String[]{"Product 1", "2", "10.00"}); // {productName, quantity, price}
        orderItems.add(new String[]{"Product 2", "1", "20.00"});

        // Store the order items in the session
        HttpSession session = request.getSession();
        session.setAttribute("orderItems", orderItems);

        // Redirect to the bill page
        response.sendRedirect("bill.jsp"); // Adjust the path as necessary
    }
}