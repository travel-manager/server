package com.travelmanager.domain.interfaces;

import java.util.List;

public interface ICRUD<T> {

    void create(T entity);

    T read(int id);
    Iterable<T> readAll();

    void update(T entity);

    void delete(int id);
}
