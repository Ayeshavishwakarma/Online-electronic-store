package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductDAO {

    // Method to update product details in the database
    public int updateProductDetails(ProductBean product) {
        String query = "UPDATE product SET pprice = ?, pqty = ? WHERE pcode = ?";
        int rowCount = 0;

        try (Connection con = DBConnect.getcon(); 
             PreparedStatement pstm = con.prepareStatement(query)) {
             
            pstm.setString(1, product.getPprice()); // Set price
            pstm.setString(2, product.getPqty());   // Set quantity
            pstm.setString(3, product.getPcode());  // Set product code

            rowCount = pstm.executeUpdate(); // Execute the update
        } catch (SQLException e) {
            // Handle exceptions (consider using a logging framework)
            System.err.println("Error updating product: " + e.getMessage());
        }

        return rowCount; // Return the number of rows affected
    }
}