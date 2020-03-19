package ru.kazeev.jaxrs.fileCRUD.DAO;

import java.util.List;

public interface Dao<T> {
    T getById(int id);

    List<T> getAllById(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}