package app.services;


import app.dto.UserDto;
import app.exceptions.EmailExistsException;
import app.entities.model.Role;
import app.entities.model.User;

import java.util.List;


public interface IUserService {

    User read(int id);

    List<User> getAll();

    User update(int id, UserDto userDto, Role role);

    User delete(int id);

    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;

    User findByEmail(String email);
}
