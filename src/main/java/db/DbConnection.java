package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class handling db connection
 *
 * @author Cristi Borlea
 * @version 1.0
 */
public class DbConnection {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String SERVER_NAME = "localhost";
    private static final String DB_NAME = "shop";
    public static final String URL = "jdbc:mysql://" + SERVER_NAME + "/" + DB_NAME;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";


    /**
     * The getConnection method make the connection with database
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Db is connected");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Cannot load db driver!");
        }
        throw new SQLException();
    }
}
