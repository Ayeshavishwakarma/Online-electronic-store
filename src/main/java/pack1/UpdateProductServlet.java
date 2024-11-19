package pack1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pcode = request.getParameter("pcode");
        String pname = request.getParameter("pname");
        String pcompany = request.getParameter("pcompany");
        String pprice = request.getParameter("pprice");
        String pqty = request.getParameter("pqty");

        try {
            EditProductDAO editProductDAO = new EditProductDAO();
            boolean updated = editProductDAO.updateProduct(pcode, pname, pcompany, pprice, pqty);

            if (updated) {
                request.setAttribute("message", "Product updated successfully!");

                // Retrieve the updated product details
                ProductBean updatedProduct = editProductDAO.getProductByCode(pcode);
                request.setAttribute("productToEdit", updatedProduct);
            } else {
                request.setAttribute("message", "Product update failed.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid number format.");
        }

        // Forward to the JSP page that displays the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct.jsp"); // Change this to your JSP file name
        dispatcher.forward(request, response);
    }
}