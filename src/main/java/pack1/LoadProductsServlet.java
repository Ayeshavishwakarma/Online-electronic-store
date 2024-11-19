package pack1;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loadProducts")
public class LoadProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        ArrayList<ProductBean> productList = productDAO.getAllProducts(); // Fetch products from database
        
        HttpSession session = req.getSession();
        session.setAttribute("products", productList); // Set product list in session
        
        req.getRequestDispatcher("ProductDetails.jsp").forward(req, res); // Forward to the JSP to display products
    }
}