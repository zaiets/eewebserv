package app.repositories;


import app.repositories.IDao;
import app.repositories.model.User;

import java.util.List;


public abstract class AbstractUserDao implements IDao<User, Integer> {

    public abstract User read(int id);

    public abstract List<User> getAll();

    public abstract Integer create(User user);

    public abstract User update(int id, User user);

    public abstract User delete(int id);
}
