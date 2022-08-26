package by.teachmeskills.lesson20_jdbc.connection_factory;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    Connection getConnection(String url, String username, String password) throws SQLException;
}
