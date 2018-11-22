package dao;

import db.DbConnection;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristi Borlea
 * @version 1.0
 */
public class ProductDao {
    private static final String PRODUCT_TABLE = "product";

    /**
     * The getReviewById method return a list of products
     *
     * @throws SQLException
     */
    public List<Product> getAllProducts() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();

        List<Product> products = new ArrayList();
        Statement stmt = null;
        String query = "select * from " + PRODUCT_TABLE
                + " p join category c on p.category_id = c.id";
        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String categoryName = rs.getString("c.category_name");
                String description = rs.getString("description");
                float price = rs.getFloat("price");

                Product product = new Product(id, name, categoryName, description, price);
                products.add(product);
                System.out.println(product + " ");
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return products;

    }

    /**
     * The getReviewById method return a list of products for a specific id
     *
     * @throws SQLException
     */
    public Product getProductById(int productId) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();

        Statement stmt = null;
        String query = "select * from " + PRODUCT_TABLE
                + " p join category c on p.category_id = c.id WHERE p.id=" + productId;
        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String categoryName = rs.getString("c.category_name");
                String description = rs.getString("description");
                float price = rs.getFloat("price");

                Product product = new Product(id, name, categoryName, description, price);
                System.out.println(product + " ");
                return product;
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return null;
    }


    /**
     * The getReviewById method return a list of categories for a specific id
     *
     * @throws SQLException
     */
    public List<Product> getAllProductsByCategory(int categoryId) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();

        List<Product> products = new ArrayList();
        Statement stmt = null;
        String query = "select * from " + PRODUCT_TABLE
                + " p join category c on p.category_id = c.id where c.id=" + categoryId;

        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String categoryName = rs.getString("c.category_name");
                String description = rs.getString("description");
                float price = rs.getFloat("price");

                Product product = new Product(id, name, categoryName, description, price);
                products.add(product);
                System.out.println(product);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return products;

    }
}
