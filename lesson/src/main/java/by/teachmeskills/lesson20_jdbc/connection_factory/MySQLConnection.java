package by.teachmeskills.lesson20_jdbc.connection_factory;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection implements ConnectionFactory {
    private static Properties properties = PropertiesReader.getProperties("database.properties");
    private static MysqlDataSource mysqlDS = new MysqlDataSource();

    public MySQLConnection() {
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        mysqlDS.setURL(properties.getProperty(url));
        mysqlDS.setUser(properties.getProperty(username));
        mysqlDS.setPassword(password);
        return mysqlDS.getConnection();
    }
}
