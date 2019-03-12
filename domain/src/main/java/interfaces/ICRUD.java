package interfaces;

import java.util.List;

public interface ICRUD<T, R> {

    R create(T entity);

    T read(int id);
    List<T> readAll();

    R update(T entity);

    R delete(int id);
}
