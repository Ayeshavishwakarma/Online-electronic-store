package pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
    
    // Handle POST request
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pcode = req.getParameter("pcode");
        DeleteProductDAO dao = new DeleteProductDAO(); // Ensure you're using the correct DAO for deletion
        int rowCount = dao.deleteProduct(pcode); // Call the method to delete the product
        
        // Optional: Check if the product was deleted successfully
        if (rowCount > 0) {
            req.setAttribute("msg", "Product deleted successfully.");
        } else {
            req.setAttribute("msg", "Failed to delete product. It may not exist.");
        }
        
        // Redirect back to the product list
        res.sendRedirect("viewProducts"); // Adjust this to the correct URL for viewing products
    }

    // Handle GET request
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // If you want to allow deletion via GET, you can do the same as in doPost
        String pcode = req.getParameter("pcode");
        DeleteProductDAO dao = new DeleteProductDAO();
        int rowCount = dao.deleteProduct(pcode);
        
        // Optional: Check if the product was deleted successfully
        if (rowCount > 0) {
            req.setAttribute("msg", "Product deleted successfully.");
        } else {
            req.setAttribute("msg", "Failed to delete product. It may not exist.");
        }
        
        // Redirect back to the product list
        res.sendRedirect("viewProducts"); // Adjust this to the correct URL for viewing products
    }
}