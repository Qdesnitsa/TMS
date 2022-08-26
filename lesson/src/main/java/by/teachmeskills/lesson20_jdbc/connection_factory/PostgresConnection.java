package by.teachmeskills.lesson20_jdbc.connection_factory;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection implements ConnectionFactory {
    private static Properties properties = PropertiesReader.getProperties("database.properties");
    private static PGConnectionPoolDataSource postgresDataSource = new PGConnectionPoolDataSource();

    public PostgresConnection() {
    }

    @Override
    public Connection getConnection(String url, String username, String password) throws SQLException {
        postgresDataSource.setURL(properties.getProperty(url));
        postgresDataSource.setUser(properties.getProperty(username));
        postgresDataSource.setPassword(password);
        return postgresDataSource.getConnection();
    }
}
