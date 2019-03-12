package interfaces;

import java.util.List;

public interface ICRUD<T, R> {

    R create(T entity);

    T read(int id);
    List<T> readAll();
    List<T> readRange(List<Integer> ids);

    R update(T entity);

    R delete(int id);
}
