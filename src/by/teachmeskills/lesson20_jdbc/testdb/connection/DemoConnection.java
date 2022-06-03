package by.teachmeskills.lesson20_jdbc.testdb.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoConnection {
    public static void main(String[] args) {
        JDBCConnector jdbcConnector = new JDBCConnector();
        try(Connection con = jdbcConnector.getConnection()) {
            System.out.println(con.getSchema());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
