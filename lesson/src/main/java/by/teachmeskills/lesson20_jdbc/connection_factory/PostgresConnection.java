package by.teachmeskills.lesson20_jdbc.connection_factory;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection implements ConnectionFactory {
    private static final String POSTGRES_PROPERTIES = "database.properties";
    private static Properties properties = PropertiesReader.getProperties(POSTGRES_PROPERTIES);
    private static PGConnectionPoolDataSource postgresDS = new PGConnectionPoolDataSource();

    public PostgresConnection() {
    }

    @Override
    public Connection getConnection(String url, String username, String password) throws SQLException {
        postgresDS.setURL(properties.getProperty(url));
        postgresDS.setUser(properties.getProperty(username));
        postgresDS.setPassword(password);
        return postgresDS.getConnection();
    }
}
