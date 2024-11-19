package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {
    // Method to check admin login credentials
    public AdminBean checkAdminLogin(String username, String password) {
        AdminBean admin = null;
        Connection conn = null; // Declare the connection variable
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = DBConnect.getcon(); // Use the correct variable
            // SQL query to check for valid credentials
            String sql = "SELECT * FROM admin WHERE UNAME = ? AND PWORD = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            rs = pstmt.executeQuery();

            // If a record is found, create an AdminBean object
            if (rs.next()) {
                admin = new AdminBean();
                admin.setuName(rs.getString("UNAME")); // Use the correct column name
                admin.setUpwd(rs.getString("PWORD")); // Use the correct column name
                // Set other fields as necessary
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close(); // Close the correct connection variable
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return admin; // Returns null if no valid admin is found
    }
}