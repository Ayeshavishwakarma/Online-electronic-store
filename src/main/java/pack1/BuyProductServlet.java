package pack1;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/buyProduct")
public class BuyProductServlet extends HttpServlet {
    private OrderDAO orderDao;

    @Override
    public void init() throws ServletException {
        orderDao = new OrderDAO(); // Initialize OrderDAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pcode = request.getParameter("pcode");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Retrieve product details from database
        BuyProductDAO buyProductDAO = new BuyProductDAO();
        Optional<BuyProductDAO.ProductDetails> productOptional = buyProductDAO.findProductByCode(pcode);
        if (productOptional.isPresent()) {
            BuyProductDAO.ProductDetails product = productOptional.get();
            String productName = product.getName(); // Get product name
            double price = product.getPrice(); // Get product price

            // Calculate total price
            double totalPrice = price * quantity;

            // Create an Order object
            Order order = new Order(pcode, productName, quantity, price, totalPrice);

            // Store the order in the session
            HttpSession session = request.getSession();
            session.setAttribute("order", order);

            // Redirect to the bill page
            response.sendRedirect("bill.jsp");
        } else {
            // Handle product not found error
            response.sendRedirect("error.jsp");
        }
    }
}