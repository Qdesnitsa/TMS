package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnectionImpl implements ConnectionFactory {
    private static final String POSTGRES_URL = "postgres.url";
    private static final String POSTGRES_PASSWORD = "postgres.password";
    private static final String POSTGRES_USER = "postgres.user";
    private static Properties properties;
    private static String urlPostgres;
    private static String passwordPostgres;
    private static String userPostgres;

    public PostgresConnectionImpl() {
    }

    @Override
    public Connection getConnection(String databasePropertiesFile) throws SQLException {
        properties = PropertiesReader.getProperties(databasePropertiesFile);
        urlPostgres = properties.getProperty(POSTGRES_URL);
        passwordPostgres = properties.getProperty(POSTGRES_PASSWORD);
        userPostgres = properties.getProperty(POSTGRES_USER);
        return DriverManager.getConnection(urlPostgres, userPostgres, passwordPostgres);
    }
}
