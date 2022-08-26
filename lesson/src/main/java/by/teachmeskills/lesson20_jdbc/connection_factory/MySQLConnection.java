package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection implements ConnectionFactory {
    private static Properties properties = PropertiesReader.getProperties("database.properties");
    private static String urlMysql;
    private static String passwordMysql;
    private static String userMysql;

    public MySQLConnection() {
    }

    @Override
    public Connection getConnection(String url, String username, String password) throws SQLException {
        urlMysql = properties.getProperty(url);
        userMysql = properties.getProperty(username);
        passwordMysql = properties.getProperty(password);
        return DriverManager.getConnection(urlMysql, userMysql, passwordMysql);
    }
}
