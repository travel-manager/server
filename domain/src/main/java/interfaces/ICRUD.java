package interfaces;

import java.util.List;

public interface ICRUD<T> {

    void create(T entity);

    T read(int id);
    List<T> readAll();
    List<T> readRange(List<Integer> ids);

    void update(T entity);

    void delete(int id);
}
