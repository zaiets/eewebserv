package app.repositories.daoimpl;


import app.repositories.AbstractUserDao;
import app.repositories.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class UserDaoImpl extends AbstractUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    @Override
    public User read(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User create(User user) {
        Integer integer = (Integer) sessionFactory.getCurrentSession().save(user);
        return (User) sessionFactory.getCurrentSession().get(User.class, integer);
    }

    @Override
    public User update(int id, User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }

    @Override
    public User delete(int id) {
        User user = read(id);
        sessionFactory.getCurrentSession().delete(user);
        return user;
    }
}
