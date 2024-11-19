package pack1;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class AddProductDAO {
	    public int insertProduct(ProductBean pb) {
	        int rowCount = 0;
	        Connection con = null;
	        PreparedStatement pstm = null;

	        try {
	            con = DBConnect.getcon(); // Ensure this returns a valid connection from a pool
	            pstm = con.prepareStatement("INSERT INTO product (pcode, pname, pcompany, pprice, pqty) VALUES (?, ?, ?, ?, ?)");
	            pstm.setString(1, pb.getPcode());
	            pstm.setString(2, pb.getPname());
	            pstm.setString(3, pb.getPcompany());
	            pstm.setDouble(4, Double.parseDouble(pb.getPprice())); // Assuming pprice is a double
	            pstm.setInt(5, Integer.parseInt(pb.getPqty())); // Assuming pqty is an integer

	            rowCount = pstm.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("SQL Error: " + e.getMessage());
	            e.printStackTrace(); // Print stack trace for debugging
	        } catch (NumberFormatException e) {
	            System.out.println("Number format error: " + e.getMessage());
	            e.printStackTrace(); // Print stack trace for debugging
	        } catch (Exception e) {
	            System.out.println("General Error: " + e.getMessage());
	            e.printStackTrace(); // Print stack trace for debugging
	        } finally {
	            // Close resources in the finally block to ensure they are closed even if an error occurs
	            try {
	                if (pstm != null) pstm.close();
	                // Do not close the connection if using a connection pool
	                // if (con != null) con.close(); // Uncomment this only if not using a connection pool
	            } catch (SQLException e) {
	                e.printStackTrace(); // Handle closing exceptions
	            }
	        }
	        return rowCount;
	    }
	}