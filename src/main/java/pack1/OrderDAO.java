package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Change to your database URL
    private String jdbcUsername = "your_username"; // Change to your database username
    private String jdbcPassword = "your_password"; // Change to your database password

    // Database connection
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to place an order
    public void placeOrder(String productCode, String productName, int quantity, double price, double totalPrice) {
        String sql = "INSERT INTO orders (pcode, product_name, quantity, price, total_price) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, productCode);
            statement.setString(2, productName);
            statement.setInt(3, quantity);
            statement.setDouble(4, price);
            statement.setDouble(5, totalPrice);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}