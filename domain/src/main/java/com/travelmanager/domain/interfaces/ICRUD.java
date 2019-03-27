package com.travelmanager.domain.interfaces;

import java.util.List;

public interface ICRUD<T, R> {

    R create(T entity);

    T read(int id);
    Iterable<T> readAll();

    R update(T entity);

    void delete(int id);
}
