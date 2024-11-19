package pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    HttpSession session = req.getSession(false);

	    if (session == null) {
	        req.setAttribute("msg", "Session Expired!!!");
	        RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
	        rd.forward(req, res);
	        return;
	    }

	    ProductBean pbean = new ProductBean();
	    pbean.setPcode(req.getParameter("pcode"));
	    pbean.setPname(req.getParameter("pname"));
	    pbean.setPcompany(req.getParameter("pcompany"));
	    pbean.setPprice(req.getParameter("pprice"));
	    pbean.setPqty(req.getParameter("pqty"));

	    System.out.println("Inserting Product: " + pbean.getPcode() + ", " + pbean.getPname() + ", " + pbean.getPcompany() + ", " + pbean.getPprice() + ", " + pbean.getPqty());

	    int rowCount = new AddProductDAO().insertProduct(pbean);

	    if (rowCount > 0) {
	        req.setAttribute("msg", "Product added successfully!");

	        // Retrieve the updated list of products
	        ArrayList<ProductBean> products = new ProductDAO().getAllProducts(); // Ensure this method is implemented
	        req.setAttribute("products", products); // Set the products list

	        RequestDispatcher rd = req.getRequestDispatcher("AddProduct.jsp");
	        
	        rd.forward(req, res);
	    } else {
	        req.setAttribute("msg", "Failed to add product. Please try again.");
	        RequestDispatcher rd = req.getRequestDispatcher("AddProduct.jsp");
	        rd.forward(req, res);
	    }
	    
	}}