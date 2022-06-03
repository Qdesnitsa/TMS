package by.teachmeskills.lesson20_jdbc.testdb.repository;

import by.teachmeskills.lesson20_jdbc.testdb.model.Person;

import java.util.List;

public interface PersonDAO extends BaseDAO<Person>{
    List<Person> findByName(String name);
}
