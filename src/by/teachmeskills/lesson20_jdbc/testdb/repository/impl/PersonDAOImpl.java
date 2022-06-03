package by.teachmeskills.lesson20_jdbc.testdb.repository.impl;

import by.teachmeskills.lesson20_jdbc.testdb.connection.JDBCConnector;
import by.teachmeskills.lesson20_jdbc.testdb.model.Person;
import by.teachmeskills.lesson20_jdbc.testdb.repository.PersonDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private static final String CREATE_PERSON = "INSERT INTO person(name, address, age) VALUES (?,?,?)";
    private static final String FIND_ALL_PERSON = "SELECT * FROM person";
    private JDBCConnector connector;

    public PersonDAOImpl(JDBCConnector conn) {
        this.connector = conn;
    }
    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection1 = connector.getConnection();
             Statement statement = connection1.createStatement();) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_PERSON);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setCity(resultSet.getString("address"));
                person.setAge(resultSet.getInt("age"));
                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person findByID(int id) {
        return null;
    }

    @Override
    public boolean create(Person person) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PERSON);) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2,person.getCity());
            preparedStatement.setInt(3,person.getAge());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Person criteria) {
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }

    @Override
    public List<Person> findByName(String name) {
        return null;
    }
}
