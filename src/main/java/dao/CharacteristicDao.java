package dao;

import db.DbConnection;
import model.Characteristic;

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
public class CharacteristicDao {

    private static final String PRODUCT_TABLE = "product";

    /**
     * The getReviewById method return a list of characteristics for a specific product
     *
     * @throws SQLException
     */
    public List<Characteristic> getCharacteristicForProduct(int productId) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();

        List<Characteristic> characteristicList = new ArrayList();
        Statement stmt = null;
        String query = "select c.characteristic_name, c.characteristic_value from characteristic " +
                "c, product_characteristic pc, product p WHERE\n " +
                "c.id = pc.characteristic_id and p.id= pc.product_id  and p.id=" + productId;
        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("characteristic_name");
                String value = rs.getString("characteristic_value");

                Characteristic c = new Characteristic(name, value);
                characteristicList.add(c);
                System.out.println(c);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return characteristicList;
    }
}