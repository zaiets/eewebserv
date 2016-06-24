package app.repositories.daoimpl;


import app.repositories.AbstractUserTokenDao;
import app.repositories.model.UserToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public final class UserTokenDaoImpl extends AbstractUserTokenDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserTokenDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
}
