package app.entities;

import java.util.List;


public interface IDao<T> {
    T create(T t);
    T read(int id);
    List<T> getAll();
    T update(int id, T t);
    T delete(int id);
}
