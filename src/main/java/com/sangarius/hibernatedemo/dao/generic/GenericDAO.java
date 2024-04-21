package com.sangarius.hibernatedemo.dao.generic;

import java.util.List;
import java.util.UUID;

public interface GenericDAO<T> {

    void save(T entity);
    void add(T entity);
    void update(T entity);
    void delete(UUID id);

    T getById(UUID id);
    T getByName(String name, String columnName);
    List<T> getAll();
}
