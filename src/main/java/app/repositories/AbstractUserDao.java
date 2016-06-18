package app.repositories;


import app.repositories.model.User;

import java.util.List;


public abstract class AbstractUserDao implements IDao<User> {

    public abstract User read(int id);

    public abstract User findByEmail(String email);

    public abstract List<User> getAll();

    public abstract User create(User user);

    public abstract User update(int id, User user);

    public abstract User delete(int id);
}
