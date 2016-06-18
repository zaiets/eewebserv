package app.services;


import app.dto.UserDto;
import app.exceptions.EmailExistsException;
import app.repositories.model.Role;
import app.repositories.model.User;

import java.util.List;


public interface IUserService {

    User read(int id);

    List<User> getAll();

    User update(int id, UserDto userDto, Role role);

    User delete(int id);

    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
