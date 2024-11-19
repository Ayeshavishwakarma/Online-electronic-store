package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductDAO {
    public int deleteProduct(String pcode) {
        int rowCount = 0;
        try (Connection con = DBConnect.getcon();
             PreparedStatement pstm = con.prepareStatement("DELETE FROM product WHERE pcode = ?")) {
            pstm.setString(1, pcode);
            rowCount = pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
        return rowCount;
    }
}
