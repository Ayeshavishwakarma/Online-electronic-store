package pack1;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/viewProducts")
public class ViewProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assume this method retrieves a list of products
        ArrayList<ProductBean> productList = ProductDAO.getProducts(); // Replace with your actual method
        
        // Debugging output
        System.out.println("Products in servlet: " + productList); // Log the products
        
        // Set the products attribute
        request.setAttribute("products", productList);
        
        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProduct.jsp");
        dispatcher.forward(request, response);
    }
}