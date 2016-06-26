package app.entities;


import app.entities.model.UserToken;
import org.hibernate.SessionFactory;

import java.util.List;


public interface IUserTokenDao extends IDao<UserToken> {

    UserToken read(int userId);

    List<UserToken> getAll();

    UserToken create(UserToken userToken);

    UserToken update(int userId, UserToken userToken);

    UserToken delete(int userId);

    SessionFactory getSessionFactory();

    void setSessionFactory(SessionFactory sessionFactory);
}
