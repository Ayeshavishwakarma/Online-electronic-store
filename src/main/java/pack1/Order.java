package pack1;

public class Order {
    private String productCode; // Added product code
    private String productName; // Added product name
    private int quantity;
    private double price;
    private double totalPrice;

    // Constructor
    public Order(String productCode, String productName, int quantity, double price, double totalPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}