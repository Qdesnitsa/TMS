package by.tms.lesson20_jdbc.testdb.repository;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();
    T findByID(int id);
    boolean create(T entity);
    boolean update(T criteria);
    boolean deleteByID(int id);
}
