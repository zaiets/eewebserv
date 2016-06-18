package app.repositories.daoimpl;


import app.repositories.AbstractUserTokenDao;
import app.repositories.model.UserToken;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class UserTokenDaoImpl extends AbstractUserTokenDao {
    @Autowired
    private SessionFactory sessionFactory;


    public UserTokenDaoImpl() {
    }

    @Override
    public UserToken read(int userId) {
        return (UserToken) sessionFactory.getCurrentSession()
                .createCriteria(UserToken.class)
                .add(Restrictions.eq("user_id", userId))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserToken> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(UserToken.class).list();
    }

    @Override
    public UserToken create(UserToken userToken) {
        Integer integer = (Integer) sessionFactory.getCurrentSession().save(userToken);
        return (UserToken) sessionFactory.getCurrentSession().get(UserToken.class, integer);
    }

    @Override
    public UserToken update(int userId, UserToken userToken) {
        sessionFactory.getCurrentSession().saveOrUpdate(userToken);
        return (UserToken) sessionFactory.getCurrentSession()
                .createCriteria(UserToken.class)
                .add(Restrictions.eq("user_id", userId))
                .uniqueResult();
    }

    @Override
    public UserToken delete(int userId) {
        UserToken userToken = read(userId);
        sessionFactory.getCurrentSession().delete(userToken);
        return userToken;
    }
}
