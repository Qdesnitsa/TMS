package by.teachmeskills.lesson20_jdbc.testdb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    private static String URL = "jdbc:mysql://localhost:3306/testdb";
    private static String USER = "root";
    private static String PASSWORD = "2cool4u";

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            return connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
