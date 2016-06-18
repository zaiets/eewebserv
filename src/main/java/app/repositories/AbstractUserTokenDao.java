package app.repositories;


import app.repositories.model.UserToken;

import java.util.List;


public abstract class AbstractUserTokenDao implements IDao<UserToken> {

    public abstract UserToken read(int userId);

    public abstract List<UserToken> getAll();

    public abstract UserToken create(UserToken userToken);

    public abstract UserToken update(int userId, UserToken userToken);

    public abstract UserToken delete(int userId);
}
