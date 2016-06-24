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

@Transactional
@Repository
public final class UserDaoImpl extends AbstractUserDao {

    @Autowired
    private SessionFactory sessionFactory;


    public UserDaoImpl() {
    }

    @Override
    public User read(int id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        return getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User create(User user) {
        Integer integer = (Integer) getCurrentSession().save(user);
        return (User) getCurrentSession().get(User.class, integer);
    }

    @Override
    public User update(int id, User user) {
        getCurrentSession().update(user);
        return user;
    }

    @Override
    public User delete(int id) {
        User user = read(id);
        getCurrentSession().delete(user);
        return user;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
