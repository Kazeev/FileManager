package ru.kazeev.jaxrs.fileCRUD.services;

import java.util.List;

public interface Service<T> {
    T getById(int id);

    List<T> getAllById(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
