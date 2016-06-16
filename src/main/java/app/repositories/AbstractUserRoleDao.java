package app.repositories;


import app.repositories.model.UserRole;

import java.util.List;


public abstract class AbstractUserRoleDao implements IDao<UserRole, Integer> {

    public abstract UserRole read(int id);

    public abstract List<UserRole> getAll();

    public abstract Integer create(UserRole userRole);

    public abstract UserRole update(int id, UserRole userRole);

    public abstract UserRole delete(int id);
}
