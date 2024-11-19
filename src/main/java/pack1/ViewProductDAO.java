package pack1;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewProductDAO {
    
    // Method to get a single product by code
    public ProductBean getProductByCode(String pcode) {
        ProductBean product = null;
        try (Connection con = DBConnect.getcon();
             PreparedStatement pstm = con.prepareStatement("SELECT * FROM product WHERE pcode = ?")) {
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
        return product;
    }

    // Method to delete a product
    public void deleteProduct(String pcode) {
        try (Connection con = DBConnect.getcon();
             PreparedStatement pstm = con.prepareStatement("DELETE FROM product WHERE pcode = ?")) {
            pstm.setString(1, pcode);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
    }

    // Method to get all products
    public ArrayList<ProductBean> getProducts() {
        ArrayList<ProductBean> productList = new ArrayList<>();
        try (Connection con = DBConnect.getcon();
             PreparedStatement pstm = con.prepareStatement("SELECT * FROM product")) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ProductBean product = new ProductBean();
                product.setPcode(rs.getString("pcode"));
                product.setPname(rs.getString("pname"));
                product.setPcompany(rs.getString("pcompany"));
                product.setPprice(rs.getString("pprice"));
                product.setPqty(rs.getString("pqty"));
                productList.add(product);
            }
            System.out.println("Number of products retrieved: " 
            + productList.size());
        } catch (SQLException e) {
            System.err.println("Error retrieving products: " + e.getMessage());
        }
        return productList;
    }
}