package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO {
    // Method to check customer login credentials
    public CustomerBean checkCustomerLogin(String username, String password) {
        CustomerBean customer = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
        	conn = DBConnect.getcon();            // SQL query to check for valid credentials
            String sql = "SELECT * FROM customer WHERE UNAME = ? AND PWORD = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            rs = pstmt.executeQuery();

            // If a record is found, create a CustomerBean object
            if (rs.next()) {
                customer = new CustomerBean();
                customer.setuName(rs.getString("UNAME"));
                customer.setUpword(rs.getString("PWORD"));
                // Set other fields as necessary
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customer; // Returns null if no valid customer is found
    }
}