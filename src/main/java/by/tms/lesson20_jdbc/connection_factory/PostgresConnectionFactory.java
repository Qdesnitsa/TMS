package by.tms.lesson20_jdbc.connection_factory;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnectionFactory implements ConnectionFactory {
    private static final String POSTGRES_PROPERTIES = "database.properties";
    private static Properties properties = PropertiesReader.getProperties(POSTGRES_PROPERTIES);
    private static PGConnectionPoolDataSource postgresDS = new PGConnectionPoolDataSource();

    public PostgresConnectionFactory() {
        postgresDS.setURL(properties.getProperty("postgres.url.instagram"));
        postgresDS.setUser(properties.getProperty("postgres.user.alena"));
        postgresDS.setPassword(properties.getProperty("postgres.password.alena"));
    }

    public PostgresConnectionFactory(String url, String username, String password) {
        postgresDS.setURL(url);
        postgresDS.setUser(username);
        postgresDS.setPassword(password);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return postgresDS.getConnection();
    }
}
