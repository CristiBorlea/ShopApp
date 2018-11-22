package dao;

import db.DbConnection;
import model.Review;

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
public class ReviewDao {

    private static final String PRODUCT_TABLE = "product";

    /**
     * The getReviewById method return a list of reviews for a specific product
     *
     * @throws SQLException
     */
    public List<Review> getReviewsById(int productId) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();

        List<Review> reviews = new ArrayList();
        Statement stmt = null;
        String query = "select * from review r, user u, product p WHERE\n" +
                " r.user_id = u.id and p.review_id = r.id and p.id =" + productId;
        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("r.id");
                String text = rs.getString("text");
                String username = rs.getString("username");
                String email = rs.getString("email");

                Review r = new Review(id, text, username, email);
                reviews.add(r);
                System.out.println(r + " ");
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return reviews;
    }
}
