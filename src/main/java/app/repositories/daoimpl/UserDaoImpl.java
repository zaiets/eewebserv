package app.repositories.daoimpl;


import app.repositories.AbstractUserDao;
import app.repositories.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public final class UserDaoImpl extends AbstractUserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User read(int id) {
        return (User) currentSession().get(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        return (User) currentSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        return currentSession().createCriteria(User.class).list();
    }

    @Override
    public User create(User user) {
        Integer integer = (Integer) currentSession().save(user);
        return (User) currentSession().get(User.class, integer);
    }

    @Override
    public User update(int id, User user) {
        currentSession().update(user);
        return user;
    }

    @Override
    public User delete(int id) {
        User user = read(id);
        currentSession().delete(user);
        return user;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
