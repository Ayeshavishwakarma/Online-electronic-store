package pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pcode = request.getParameter("pcode");
        System.out.println("Received pcode: " + pcode); // Debugging line
        
        /*if (pcode == null || pcode.isEmpty()) {
            response.sendRedirect("ErrorPage.jsp?message=Invalid product code");
            return;
        }*/

        // Fetch the product from the database using the DAO
        EditProductDAO editProductDAO = new EditProductDAO();
        ProductBean productToEdit = editProductDAO.getProductByCode(pcode);

        if (productToEdit != null) {
            request.setAttribute("productToEdit", productToEdit);
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        } else {
            response.sendRedirect("ErrorPage.jsp?message=Product not found");
        }
    }
}