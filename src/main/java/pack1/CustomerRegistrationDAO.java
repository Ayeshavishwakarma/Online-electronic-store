package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegistrationDAO {
    public boolean registerCustomer(String username, String password, String firstname, String lastname, String address, String email, String phone) {
        boolean isSuccess = false;
        try {
            Connection con = DBConnect.getcon(); // Ensure this method returns a valid connection
            if (con == null) {
                System.out.println("Failed to establish database connection.");
                return false;
            }

            String query = "INSERT INTO customer (uname, pword, fname, lname, addr, mid, phno) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password); // Store the password as plain text for now
            pstm.setString(3, firstname);
            pstm.setString(4, lastname);
            pstm.setString(5, address);
            pstm.setString(6, email);
            pstm.setString(7, phone);

            int rowsInserted = pstm.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}