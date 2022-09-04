package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory postgresConnection = new PostgresConnectionFactory(
                        "jdbc:postgresql://localhost:5432/instagram",
                "postgres",
                "2cool4u");
        ConnectionFactory mySQLConnection = new MySQLConnectionFactory(
                "jdbc:mysql://localhost:3306/instagram?useSSL=false",
                "root",
                "2cool4u");

        try (Connection con = postgresConnection.getConnection()) {
            System.out.println("Connection to Postgres is successful");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try (Connection con = mySQLConnection.getConnection()) {
            System.out.println("Connection to MySQL is successful");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}