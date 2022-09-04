package by.teachmeskills.lesson20_jdbc.connection_factory;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnectionFactory implements ConnectionFactory {
    private static final String MYSQL_PROPERTIES = "database.properties";
    private static Properties properties = PropertiesReader.getProperties(MYSQL_PROPERTIES);
    private static MysqlDataSource mysqlDS = new MysqlDataSource();

    public MySQLConnectionFactory() {
        mysqlDS.setURL(properties.getProperty("mysql.url.instagram"));
        mysqlDS.setUser(properties.getProperty("mysql.user.alena"));
        mysqlDS.setPassword(properties.getProperty("mysql.password.alena"));
    }

    public MySQLConnectionFactory(String url, String username, String password) {
        mysqlDS.setURL(url);
        mysqlDS.setUser(username);
        mysqlDS.setPassword(password);
    }

    public Connection getConnection() throws SQLException {
        return mysqlDS.getConnection();
    }
}