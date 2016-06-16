package app.repositories.daoimpl;


import app.repositories.AbstractUserRoleDao;
import app.repositories.HibernateUtil;
import app.repositories.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class UserRoleDaoImpl extends AbstractUserRoleDao {
    @Autowired
    private HibernateUtil hibernateUtil;

    public UserRoleDaoImpl() {    }

    @Override
    public UserRole read(int id) {
        return hibernateUtil.selectById(id, UserRole.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRole> getAll() {
        return hibernateUtil.selectAll(UserRole.class);
    }

    @Override
    public Integer create(UserRole userRole) {
        return (Integer)hibernateUtil.create(userRole);
    }

    @Override
    public UserRole update(int id, UserRole userRole) {
        return hibernateUtil.update(userRole);
    }

    @Override
    public UserRole delete(int id) {
        return hibernateUtil.delete(id, UserRole.class);
    }
}
