package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        PostgresConnectionImpl postgresConnection = new PostgresConnectionImpl();
        MySQLConnectionImpl mySQLConnection = new MySQLConnectionImpl();

        try (Connection con = postgresConnection.getConnection("database.properties")) {
            System.out.println("Connection to Postgres is successful");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try (Connection con = mySQLConnection.getConnection("database.properties")) {
            System.out.println("Connection to MySQL is successful");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
