package app.entities;


import app.entities.model.User;
import org.hibernate.SessionFactory;

import java.util.List;


public interface IUserDao extends IDao<User> {

    User read(int id);

    User findByEmail(String email);

    List<User> getAll();

    User create(User user);

    User update(int id, User user);

    User delete(int id);

    SessionFactory getSessionFactory();

    void setSessionFactory(SessionFactory sessionFactory);
}
