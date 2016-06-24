package app.repositories;


import app.repositories.model.UserToken;
import org.hibernate.SessionFactory;

import java.util.List;


public abstract class AbstractUserTokenDao implements IDao<UserToken> {

    public abstract UserToken read(int userId);

    public abstract List<UserToken> getAll();

    public abstract UserToken create(UserToken userToken);

    public abstract UserToken update(int userId, UserToken userToken);

    public abstract UserToken delete(int userId);

    public abstract SessionFactory getSessionFactory();

    public abstract void setSessionFactory(SessionFactory sessionFactory);
}
