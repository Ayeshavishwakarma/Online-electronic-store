package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditProductDAO {
    
    // Method to retrieve product by code
	public ProductBean getProductByCode(String pcode) {
	    String query = "SELECT * FROM product WHERE pcode = ?";
	    ProductBean product = null;

	    try (Connection con = DBConnect.getcon(); 
	         PreparedStatement pstm = con.prepareStatement(query)) {
	         
	        pstm.setString(1, pcode);
	        ResultSet rs = pstm.executeQuery();

	        if (rs.next()) {
	            product = new ProductBean();
	            product.setPcode(rs.getString("pcode"));
	            product.setPname(rs.getString("pname"));
	            product.setPcompany(rs.getString("pcompany"));
	            product.setPprice(rs.getString("pprice"));
	            product.setPqty(rs.getString("pqty"));
	        }
	    } catch (SQLException e) {
	        System.err.println("Error retrieving product: " + e.getMessage());
	    }

	    return product; // Return the product or null if not found
	
    }

    // Method to update product details
    public boolean updateProduct(String pcode, String pname, String pcompany, String pprice, String pqty) {
        String updateQuery = "UPDATE product SET pname = ?, pcompany = ?, pprice = ?, pqty = ? WHERE pcode = ?";
        try (Connection con = DBConnect.getcon(); 
             PreparedStatement pstm = con.prepareStatement(updateQuery)) {
            pstm.setString(1, pname);
            pstm.setString(2, pcompany);
            pstm.setString(3, pprice);
            pstm.setString(4, pqty);
            pstm.setString(5, pcode); // Set the pcode for the WHERE clause
            
            int rowsUpdated = pstm.executeUpdate();
            return rowsUpdated > 0; // Return true if at least one row was updated
        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
            return false; // Return false in case of an error
        }
    }
}