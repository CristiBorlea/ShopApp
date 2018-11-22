package dao;

import db.DbConnection;
import model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * * @author Cristi Borlea
 * * @version 1.0
 */

public class CategoryDao {
    private static final String PRODUCT_TABLE = "product";

    /**
     * The getReviewById method return a list of categories
     *
     * @throws SQLException
     */
    public List<Category> getAllCategories() throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();

        List<Category> categories = new ArrayList();
        Statement stmt = null;
        String query = "select * from category";
        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("category_name");
                Category c = new Category(id, categoryName);
                categories.add(c);
                System.out.println(c);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return categories;
    }
}
