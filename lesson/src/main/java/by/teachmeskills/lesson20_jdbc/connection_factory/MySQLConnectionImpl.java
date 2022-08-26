package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnectionImpl implements ConnectionFactory {
    private static final String MYSQL_URL = "mysql.url";
    private static final String MYSQL_PASSWORD = "mysql.password";
    private static final String MYSQL_USER = "mysql.user";
    private static Properties properties;
    private static String urlMysql;
    private static String passwordMysql;
    private static String userMysql;

    public MySQLConnectionImpl() {
    }

    @Override
    public Connection getConnection(String databasePropertiesFile) throws SQLException {
        properties = PropertiesReader.getProperties(databasePropertiesFile);
        urlMysql = properties.getProperty(MYSQL_URL);
        passwordMysql = properties.getProperty(MYSQL_PASSWORD);
        userMysql = properties.getProperty(MYSQL_USER);
        return DriverManager.getConnection(urlMysql, userMysql, passwordMysql);
    }
}
