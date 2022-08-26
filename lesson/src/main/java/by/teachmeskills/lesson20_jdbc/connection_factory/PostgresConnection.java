package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection implements ConnectionFactory {
    private static Properties properties = PropertiesReader.getProperties("database.properties");
    private static String urlPostgres;
    private static String passwordPostgres;
    private static String userPostgres;

    public PostgresConnection() {
    }

    @Override
    public Connection getConnection(String url, String username, String password) throws SQLException {
        urlPostgres = properties.getProperty(url);
        userPostgres = properties.getProperty(username);
        passwordPostgres = properties.getProperty(password);
        return DriverManager.getConnection(urlPostgres, userPostgres, passwordPostgres);
    }
}
