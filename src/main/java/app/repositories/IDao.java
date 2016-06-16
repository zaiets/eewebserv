package app.repositories;

import java.io.Serializable;
import java.util.List;


public interface IDao<T, PK extends Serializable> {
    PK create(T t);
    T read(int id);
    List<T> getAll();
    T update(int id, T t);
    T delete(int id);
}
