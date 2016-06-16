package app.repositories;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Component
@Transactional
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;

    public HibernateUtil() {    }

    public <T> Serializable create(final T entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    public <T> T update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    public <T> void delete(final T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public <T> T delete(Serializable id, Class<T> entityClass) {
        T entity = selectById(id, entityClass);
        delete(entity);
        return entity;
    }

    @SuppressWarnings("rawtypes")
    public <T> List selectAll(Class<T> entityClass) {
        return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
    }

    @SuppressWarnings("unchecked")
    public <T> T selectById(Serializable id, Class<T> entityClass) {
        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
    }
}