package by.teachmeskills.lesson20_jdbc.testdb.demoConnection;

import by.teachmeskills.lesson20_jdbc.testdb.connection.JDBCConnector;
import by.teachmeskills.lesson20_jdbc.testdb.repository.impl.PersonDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        JDBCConnector connector = new JDBCConnector();
        PersonDAOImpl personDAO = new PersonDAOImpl(connector);
        //Person person = new Person("Bob", "Minsk", 73);
        //personDAO.create(person);
        personDAO.findAll().forEach(System.out::println);

//        JDBCConnector jdbcConnector = new JDBCConnector();
//        try (Connection con = jdbcConnector.getConnection()) {
//            System.out.println(con.isClosed());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
