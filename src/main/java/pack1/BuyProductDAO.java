package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BuyProductDAO {

    // SQL Queries as constants
    private static final String SQL_SELECT_PRODUCT_DETAILS = "SELECT PNAME, PPRICE FROM product WHERE PCODE = ?";

    // Method to get product details
    public Optional<ProductDetails> findProductByCode(String productCode) {
        try (Connection conn = DBConnect.getcon(); 
             PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_PRODUCT_DETAILS)) {
             
            pstmt.setString(1, productCode); // Set the product code parameter
            try (ResultSet rs = pstmt.executeQuery()) { // Execute the query
                if (rs.next()) {
                    String name = rs.getString("PNAME"); // Retrieve the product name
                    double price = rs.getDouble("PPRICE"); // Retrieve the product price
                    return Optional.of(new ProductDetails(productCode, name, price)); // Return the product details wrapped in Optional
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving product details: " + e.getMessage());
        }
        return Optional.empty(); // Return an empty Optional if not found
    }

    // Inner class to represent product details
    public static class ProductDetails {
        private String code;
        private String name;
        private double price;

        public ProductDetails(String code, String name, double price) {
            this.code = code;
            this.name = name;
            this.price = price;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}