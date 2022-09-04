package by.teachmeskills.lesson20_jdbc.connection_factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
}
