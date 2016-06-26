package app.entities.daoimpl;


import app.entities.IUserTokenDao;
import app.entities.model.UserToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class UserTokenDaoImpl implements IUserTokenDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserTokenDaoImpl() {
    }

    @Override
    public UserToken read(int userId) {
        return (UserToken) currentSession().createCriteria(UserToken.class)
                .add(Restrictions.eq("user_id", userId))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserToken> getAll() {
        return currentSession().createCriteria(UserToken.class).list();
    }

    @Override
    public UserToken create(UserToken userToken) {
        Integer integer = (Integer) currentSession().save(userToken);
        return (UserToken) currentSession().get(UserToken.class, integer);
    }

    @Override
    public UserToken update(int userId, UserToken userToken) {
        currentSession().saveOrUpdate(userToken);
        return (UserToken) currentSession().createCriteria(UserToken.class)
                .add(Restrictions.eq("user_id", userId))
                .uniqueResult();
    }

    @Override
    public UserToken delete(int userId) {
        UserToken userToken = read(userId);
        currentSession().delete(userToken);
        return userToken;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
