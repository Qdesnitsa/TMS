package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory postgresConnection = new PostgresConnection();
        ConnectionFactory mySQLConnection = new MySQLConnection();

        try (Connection con = postgresConnection
                .getConnection("postgres.url.instagram", "postgres.user.alena", "12345")) {
            System.out.println("Connection to Postgres is successful");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try (Connection con = mySQLConnection
                .getConnection("mysql.url.instagram", "mysql.user.alena", "12345")) {
            System.out.println("Connection to MySQL is successful");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
