package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    // Method to fetch all products from the database
    public ArrayList<ProductBean> getAllProducts() {
        ArrayList<ProductBean> productList = new ArrayList<>();
        String query = "SELECT pcode, pname, pcompany, pprice, pqty FROM product"; // Adjust the query as per your database schema

        try (Connection con = DBConnect.getcon(); 
             PreparedStatement pstm = con.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
             
            while (rs.next()) {
                ProductBean product = new ProductBean();
                product.setPcode(rs.getString("pcode"));
                product.setPname(rs.getString("pname"));
                product.setPcompany(rs.getString("pcompany"));
                product.setPprice(rs.getString("pprice")); // Consider changing to a numeric type if applicable
                product.setPqty(rs.getString("pqty")); // Consider changing to an integer type if applicable

                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching products: " + e.getMessage());
        }

        return productList;
    }

    // Static method to get products
    public static ArrayList<ProductBean> getProducts() {
        ProductDAO dao = new ProductDAO(); // Create an instance of ProductDAO
        return dao.getAllProducts(); // Call the method that retrieves products
    }

    // Method to get a product by its code
    public ProductBean getProductByCode(String pcode) {
        ProductBean product = null;
        String query = "SELECT * FROM product WHERE pcode = ?"; // Use a prepared statement to prevent SQL injection
        try (Connection con = DBConnect.getcon();
             PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, pcode);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                product = new ProductBean();
                product.setPcode(rs.getString("pcode"));
                product.setPname(rs.getString("pname"));
                product.setPcompany(rs.getString("pcompany"));
                product.setPprice(rs.getString("pprice")); // Consider changing to a numeric type if applicable
                product.setPqty(rs.getString("pqty")); // Consider changing to an integer type if applicable
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving product: " + e.getMessage());
        }
        return product;
    }
}